public class Ejercicio3 {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 1, 0, 0},
            {1, 0, 2, 0},
            {0, 2, 0, 3},
            {0, 0, 3, 0}
        };

        int ciclosEvitados = contarCiclosEvitados(grafo);
        System.out.println("Ciclos evitados por Kruskal: " + ciclosEvitados);
    }

    public static int contarCiclosEvitados(int[][] grafo) {
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
        int ciclos = 0;
        for (Arista a : aristas) {
            int ru = Ejercicio1.encontrar(padre, a.u);
            int rv = Ejercicio1.encontrar(padre, a.v);
            if (ru != rv) {
                padre[ru] = rv;
            } else {
                ciclos++;
            }
        }
        return ciclos;
    }
}