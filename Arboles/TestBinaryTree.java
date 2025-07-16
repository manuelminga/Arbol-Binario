public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree arbol = new BinaryTree();

        // Insertar elementos
        arbol.insertar(23);
        arbol.insertar(29);
        arbol.insertar(4);
        arbol.insertar(2);
        arbol.insertar(5);
        arbol.insertar(67);
        arbol.insertar(34);

        // Mostrar árbol gráficamente
        arbol.mostrarArbolGrafico();

        // Información del árbol
        System.out.println("\nRecorrido en preorden: ");
        arbol.recorrerEnPreOrden();
        System.out.println("\nRecorrido en orden: ");
        arbol.recorrerEnOrden();
        System.out.println("\nRecorrido en postorden: ");
        arbol.recorrerEnPostOrden();
        System.out.println("\nPeso: " + arbol.getWeight() + ", Altura: " + arbol.getHeight());
    }
}
