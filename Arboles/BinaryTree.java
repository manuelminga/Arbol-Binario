public class BinaryTree {
    private Nodo root;
    private Integer weight;
    private Integer height;

    public BinaryTree() {
        this.root = null;
        this.weight = 0;
        this.height = 0;
    }

    // Método para insertar un elemento en el árbol binario
    public boolean insertar(Integer valor) {
        if (root == null) {
            // Si no hay raíz, lo fijamos como raíz
            root = new Nodo(valor);
            weight++;
            height = 1;
            return true;
        } else {
            // Si existe raíz, insertamos recursivamente
            return insertarRecursivo(root, valor);
        }
    }

    private boolean insertarRecursivo(Nodo nodo, Integer valor) {
        // Si el dato es == a cualquiera no se fija
        if (valor.equals(nodo.getData())) {
            return false; // No se inserta elementos duplicados
        }

        // Comparamos si es > va a la derecha, si es < va a la izquierda
        if (valor > nodo.getData()) {
            // Va a la derecha
            if (nodo.getRight() == null) {
                Nodo nuevoNodo = new Nodo(valor);
                nodo.setRight(nuevoNodo);
                nuevoNodo.setParent(nodo);
                weight++;
                actualizarAltura();
                return true;
            } else {
                return insertarRecursivo(nodo.getRight(), valor);
            }
        } else {
            // Va a la izquierda (valor < nodo.getData())
            if (nodo.getLeft() == null) {
                Nodo nuevoNodo = new Nodo(valor);
                nodo.setLeft(nuevoNodo);
                nuevoNodo.setParent(nodo);
                weight++;
                actualizarAltura();
                return true;
            } else {
                return insertarRecursivo(nodo.getLeft(), valor);
            }
        }
    }

    // Método para actualizar la altura del árbol
    private void actualizarAltura() {
        height = calcularAltura(root);
    }

    private int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = calcularAltura(nodo.getLeft());
        int alturaDerecha = calcularAltura(nodo.getRight());
        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    // Método para buscar un elemento
    public boolean buscar(Integer valor) {
        return buscarRecursivo(root, valor);
    }

    private boolean buscarRecursivo(Nodo nodo, Integer valor) {
        if (nodo == null) {
            return false;
        }

        if (valor.equals(nodo.getData())) {
            return true;
        } else if (valor > nodo.getData()) {
            return buscarRecursivo(nodo.getRight(), valor);
        } else {
            return buscarRecursivo(nodo.getLeft(), valor);
        }
    }

    // Métodos para obtener información del árbol
    public Nodo getRoot() {
        return root;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Método para recorrer el árbol en orden (izquierda, raíz, derecha)
    public void recorrerEnOrden() {
        recorrerEnOrdenRecursivo(root);
    }

    // Método para recorrer el árbol en preorden (raíz, izquierda, derecha)
    public void recorrerEnPreOrden() {
        recorrerEnPreOrdenRecursivo(root);
    }

    private void recorrerEnPreOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getData() + " ");
            recorrerEnPreOrdenRecursivo(nodo.getLeft());
            recorrerEnPreOrdenRecursivo(nodo.getRight());
        }
    }

    // Método para recorrer el árbol en postorden (izquierda, derecha, raíz)
    public void recorrerEnPostOrden() {
        recorrerEnPostOrdenRecursivo(root);
    }

    private void recorrerEnPostOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorrerEnPostOrdenRecursivo(nodo.getLeft());
            recorrerEnPostOrdenRecursivo(nodo.getRight());
            System.out.print(nodo.getData() + " ");
        }
    }

    private void recorrerEnOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorrerEnOrdenRecursivo(nodo.getLeft());
            System.out.print(nodo.getData() + " ");
            recorrerEnOrdenRecursivo(nodo.getRight());
        }
    }

    // Método para mostrar el árbol
    public void mostrarArbol() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío");
        } else {
            System.out.println("Árbol en orden: ");
            recorrerEnOrden();
            System.out.println("\nPeso: " + weight + ", Altura: " + height);
        }
    }

    // Método para mostrar el árbol gráficamente
    public void mostrarArbolGrafico() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío");
        } else {
            System.out.println("Estructura del árbol:");
            mostrarArbolGraficoRecursivo(root, "", true);
        }
    }

    private void mostrarArbolGraficoRecursivo(Nodo nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.getData());

            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

            if (nodo.getLeft() != null || nodo.getRight() != null) {
                if (nodo.getRight() != null) {
                    mostrarArbolGraficoRecursivo(nodo.getRight(), nuevoPrefijo, nodo.getLeft() == null);
                }
                if (nodo.getLeft() != null) {
                    mostrarArbolGraficoRecursivo(nodo.getLeft(), nuevoPrefijo, true);
                }
            }
        }
    }
}
