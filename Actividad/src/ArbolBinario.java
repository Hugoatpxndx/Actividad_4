public class ArbolBinario {
    public Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(Empleado Data) {
        this.raiz = insertarRec(this.raiz, Data);
    }

    private Nodo insertarRec(Nodo root, Empleado Data) {
        if (root == null) {
            root = new Nodo(Data);
            return root;
        }

        if (Data.getID() < root.Data.getID()) {
            root.izquierdo = insertarRec(root.izquierdo, Data);
        } else if (Data.getID() > root.Data.getID()) {
            root.derecho = insertarRec(root.derecho, Data);
        }

        return root;
    }
}