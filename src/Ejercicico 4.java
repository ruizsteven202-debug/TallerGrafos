import java.util.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 4, 0, 0},
            {4, 0, 3, 0},
            {0, 3, 0, 2},
            {0, 0, 2, 0}
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Origen: ");
        int origen = sc.nextInt();
        System.out.print("Destino: ");
        int destino = sc.nextInt();

        int distancia = dijkstra(grafo, origen, destino);
        if (distancia == Integer.MAX_VALUE) {
            System.out.println("❌ No hay ruta posible entre los vértices");
        } else {
            System.out.println("Distancia mínima: " + distancia);
        }
    }

    public static int dijkstra(int[][] grafo, int origen, int destino) {
        int V = grafo.length;
        int[] dist = new int[V];
        boolean[] visitado = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
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
                }
            }
        }
        return dist[destino];
    }
}