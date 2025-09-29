public class Ejercicio6 {
    public static void main(String[] args) {
        int INF = 999;
        int[][] grafo = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        int V = grafo.length;
        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = grafo[i][j];
                if (grafo[i][j] != INF && i != j) next[i][j] = j;
                else next[i][j] = -1;
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) {
                    System.out.print("Distancia mínima " + (char)('A'+i) + "→" + (char)('A'+j) + " = " + dist[i][j] + ", Camino: ");
                    imprimirCamino(next, i, j);
                    System.out.println();
                }
            }
        }
    }

    public static void imprimirCamino(int[][] next, int u, int v) {
        if (next[u][v] == -1) {
            System.out.print("No hay camino");
            return;
        }
        System.out.print((char)('A'+u));
        while (u != v) {
            u = next[u][v];
            System.out.print(" → " + (char)('A'+u));
        }
    }
}