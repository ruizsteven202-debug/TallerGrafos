public class Ejercicio1 {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int costoPrim = prim(grafo);
        int costoKruskal = kruskal(grafo);

        System.out.println("Costo MST con Prim: " + costoPrim);
        System.out.println("Costo MST con Kruskal: " + costoKruskal);

        if (costoPrim == costoKruskal) {
            System.out.println("✅ Ambos algoritmos coinciden en el costo.");
        } else {
            System.out.println("⚠️ Los algoritmos dieron resultados diferentes.");
        }
    }

    // Implementación simplificada de Prim
    public static int prim(int[][] grafo) {
        int V = grafo.length;
        boolean[] visitado = new boolean[V];
        int[] minPeso = new int[V];
        for (int i = 0; i < V; i++) minPeso[i] = Integer.MAX_VALUE;
        minPeso[0] = 0;
        int costo = 0;

        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int j = 0; j < V; j++) {
                if (!visitado[j] && (u == -1 || minPeso[j] < minPeso[u])) u = j;
            }
            visitado[u] = true;
            costo += minPeso[u];
            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != 0 && !visitado[v] && grafo[u][v] < minPeso[v]) {
                    minPeso[v] = grafo[u][v];
                }
            }
        }
        return costo;
    }

    // Implementación simplificada de Kruskal
    public static int kruskal(int[][] grafo) {
        int V = grafo.length;
        int[] padre = new int[V];
        for (int i = 0; i < V; i++) padre[i] = i;

        class Arista {
            int u, v, peso;
            Arista(int u, int v, int peso) { this.u = u; this.v = v; this.peso = peso; }
        }

        java.util.List<Arista> aristas = new java.util.ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (grafo[i][j] != 0) aristas.add(new Arista(i, j, grafo[i][j]));
            }
        }

        aristas.sort(java.util.Comparator.comparingInt(a -> a.peso));
        int costo = 0;
        for (Arista a : aristas) {
            int ru = encontrar(padre, a.u);
            int rv = encontrar(padre, a.v);
            if (ru != rv) {
                padre[ru] = rv;
                costo += a.peso;
            }
        }
        return costo;
    }

    public static int encontrar(int[] padre, int i) {
        if (padre[i] != i) padre[i] = encontrar(padre, padre[i]);
        return padre[i];
    }
}
