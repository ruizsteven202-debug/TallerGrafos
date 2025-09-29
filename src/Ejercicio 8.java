public class Ejercicio8 {
    public static void main(String[] args) {
        int[][] anchoBanda = {
            {0, 5, 0, 0, 0},
            {5, 0, 3, 0, 0},
            {0, 3, 0, 4, 0},
            {0, 0, 4, 0, 2},
            {0, 0, 0, 2, 0}
        };

        rutaMasRapida(anchoBanda, 0, 4);
    }

    public static void rutaMasRapida(int[][] grafo, int origen, int destino) {
        int V = grafo.length;
        int[] maxAncho = new int[V];
        boolean[] visitado = new boolean[V];
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            maxAncho[i] = -1;
            parent[i] = -1;
        }
        maxAncho[origen] = Integer.MAX_VALUE;

        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int j = 0; j < V; j++) {
                if (!visitado[j] && (u == -1 || maxAncho[j] > maxAncho[u])) u = j;
            }
            visitado[u] = true;
            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != 0 && Math.min(maxAncho[u], grafo[u][v]) > maxAncho[v]) {
                    maxAncho[v] = Math.min(maxAncho[u], grafo[u][v]);
                    parent[v] = u;
                }
            }
        }

        System.out.print("Ruta más rápida: ");
        imprimirRuta(parent, destino);
        System.out.println(" (ancho de banda: " + maxAncho[destino] + ")");
    }

    public static void imprimirRuta(int[] parent, int destino) {
        if (parent[destino] != -1) imprimirRuta(parent, parent[destino]);
        System.out.print((char)('A'+destino) + " ");
    }
}
