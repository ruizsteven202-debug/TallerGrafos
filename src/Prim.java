public class Prim {
    public static void ejecutarPrim(Grafo grafo) {
        int[][] matriz = grafo.obtenerMatriz();
        int numVertices = matriz.length;
        boolean[] visitado = new boolean[numVertices];
        int[] minPeso = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            minPeso[i] = Integer.MAX_VALUE;
        }

        minPeso[0] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = seleccionarMinimo(minPeso, visitado);
            visitado[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (matriz[u][v] != 0 && !visitado[v] && matriz[u][v] < minPeso[v]) {
                    minPeso[v] = matriz[u][v];
                }
            }
        }

        System.out.println("Algoritmo de Prim ejecutado.");
    }

    private static int seleccionarMinimo(int[] pesos, boolean[] visitado) {
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < pesos.length; i++) {
            if (!visitado[i] && pesos[i] < min) {
                min = pesos[i];
                index = i;
            }
        }
        return index;
    }
}