import java.util.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 4, 0, 0, 0},
            {4, 0, 3, 0, 0},
            {0, 3, 0, 2, 0},
            {0, 0, 2, 0, 1},
            {0, 0, 0, 1, 0}
        };

        int origen = 0;
        int destino = 4;
        dijkstraConCamino(grafo, origen, destino);
    }

    public static void dijkstraConCamino(int[][] grafo, int origen, int destino) {
        int V = grafo.length;
        int[] dist = new int[V];
        int[] parent = new int[V];
        boolean[] visitado = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[origen] = 0;

        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int j = 0; j < V; j++) {
                if (!visitado[j] && (u == -1 || dist[j] < dist[u])) u = j;
            }
            visitado[u] = true;
            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != 0 && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.print("Camino: ");
        imprimirCamino(parent, destino);
        System.out.println(" (costo " + dist[destino] + ")");
    }

    public static void imprimirCamino(int[] parent, int destino) {
        if (parent[destino] != -1) imprimirCamino(parent, parent[destino]);
        System.out.print((char) ('A' + destino) + " ");
    }
}