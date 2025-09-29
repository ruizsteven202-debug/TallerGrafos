public class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
        matrizAdyacencia[destino][origen] = peso; // Para grafo no dirigido
    }

    public int[][] obtenerMatriz() {
        return matrizAdyacencia;
    }
}