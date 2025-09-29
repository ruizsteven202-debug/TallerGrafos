public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0}
        };

        int V = grafo.length;
        boolean[][] alcanzable = new boolean[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                alcanzable[i][j] = grafo[i][j] != 0;

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    alcanzable[i][j] = alcanzable[i][j] || (alcanzable[i][k] && alcanzable[k][j]);

        System.out.println("Matriz de alcanzabilidad:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((alcanzable[i][j] ? "1 " : "0 "));
            }
            System.out.println();
        }

        System.out.println("Componentes fuertemente conexos:");
        for (int i = 0; i < V; i++) {
            System.out.print("{" + (char)('A'+i));
            for (int j = 0; j < V; j++) {
                if (i != j && alcanzable[i][j] && alcanzable[j][i]) {
                    System.out.print(", " + (char)('A'+j));
                }
            }
            System.out.println("}");
        }
    }
}