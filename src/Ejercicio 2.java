public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 2, 0, 0},
            {2, 0, 3, 0},
            {0, 3, 0, 0},
            {0, 0, 0, 0}
        };

        if (esConexo(grafo)) {
            System.out.println("El grafo es conexo. Ejecutando Prim...");
            System.out.println("Costo MST: " + Ejercicio1.prim(grafo));
        } else {
            System.out.println("❌ El grafo no tiene árbol de expansión mínima");
        }
    }

    public static boolean esConexo(int[][] grafo) {
        int V = grafo.length;
        boolean[] visitado = new boolean[V];
        dfs(grafo, 0, visitado);
        for (boolean v : visitado) if (!v) return false;
        return true;
    }

    public static void dfs(int[][] grafo, int u, boolean[] visitado) {
        visitado[u] = true;
        for (int v = 0; v < grafo.length; v++) {
            if (grafo[u][v] != 0 && !visitado[v]) dfs(grafo, v, visitado);
        }
    }
}
