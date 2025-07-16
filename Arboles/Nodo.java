public class Nodo {
    private Nodo parent;
    private Nodo left;
    private Nodo right;
    private Integer data;

    // Constructor
    public Nodo(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    // Getters y Setters
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public Nodo getParent() {
        return parent;
    }

    public void setParent(Nodo parent) {
        this.parent = parent;
    }
}
