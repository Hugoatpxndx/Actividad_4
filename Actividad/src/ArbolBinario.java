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

    public Empleado buscar(int id) {
        return buscarRec(this.raiz, id);
    }

    private Empleado buscarRec(Nodo root, int id) {
        if (root == null) {
            return null;
        }
        if (root.Data.getID() == id) {
            return root.Data;
        }
        if (id < root.Data.getID()) {
            return buscarRec(root.izquierdo, id);
        } else {
            return buscarRec(root.derecho, id);
        }
    }

    public void recorridoPreorden() {
        recorridoPreordenRec(this.raiz);
    }
    private void recorridoPreordenRec(Nodo root) {
        if (root != null) {
            System.out.println(root.Data);
            recorridoPreordenRec(root.izquierdo);
            recorridoPreordenRec(root.derecho);
        }
    }

    public void recorridoInorden() {
        recorridoInordenRec(this.raiz);
    }
    private void recorridoInordenRec(Nodo root) {
        if (root != null) {
            recorridoInordenRec(root.izquierdo);
            System.out.println(root.Data);
            recorridoInordenRec(root.derecho);
        }
    }

    public void recorridoPostorden() {
        recorridoPostordenRec(this.raiz);
    }
    private void recorridoPostordenRec(Nodo root) {
        if (root != null) {
            recorridoPostordenRec(root.izquierdo);
            recorridoPostordenRec(root.derecho);
            System.out.println(root.Data);
        }
    }

    public void eliminar(int id) {
        this.raiz = eliminarRec(this.raiz, id);
    }

    private Nodo eliminarRec(Nodo root, int id) {
        if (root == null) {
            return root;
        }

        if (id < root.Data.getID()) {
            root.izquierdo = eliminarRec(root.izquierdo, id);
        } else if (id > root.Data.getID()) {
            root.derecho = eliminarRec(root.derecho, id);
        } else {
            if (root.izquierdo == null) {
                return root.derecho;
            } else if (root.derecho == null) {
                return root.izquierdo;
            }

            Nodo temp = findMin(root.derecho);
            root.Data = temp.Data;
            root.derecho = eliminarRec(root.derecho, temp.Data.getID());
        }
        return root;
    }

    private Nodo findMin(Nodo node) {
        while (node.izquierdo != null) {
            node = node.izquierdo;
        }
        return node;
    }
}