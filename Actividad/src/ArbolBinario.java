/**
 * Clase que implementa la estructura de un arbol binario de busqueda para gestionar empleados.
 */
public class ArbolBinario {
    public Nodo raiz;

    /**
     * Constructor para inicializar el arbol binario vacio.
     */
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Inserta un nuevo empleado en el arbol basandose en su ID.
     * @param Data El objeto Empleado a insertar.
     */
    public void insertar(Empleado Data) {
        this.raiz = insertarRec(this.raiz, Data);
    }

    /**
     * Metodo auxiliar recursivo para encontrar la posicion de insercion.
     * @param root El nodo actual en la recursion.
     * @param Data El objeto Empleado a insertar.
     * @return El nodo actual despues de la insercion.
     */
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

    /**
     * Busca un empleado en el arbol por su ID.
     * @param id El ID del empleado a buscar.
     * @return El objeto Empleado si se encuentra, de lo contrario null.
     */
    public Empleado buscar(int id) {
        return buscarRec(this.raiz, id);
    }

    /**
     * Metodo auxiliar recursivo para realizar la busqueda en el arbol.
     * @param root El nodo actual en la busqueda.
     * @param id El ID a buscar.
     * @return El objeto Empleado encontrado o null.
     */
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

    /**
     * Realiza un recorrido Preorden del arbol y muestra los elementos.
     * (Raiz, Izquierda, Derecha)
     */
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

    /**
     * Realiza un recorrido Inorden del arbol y muestra los elementos.
     * (Izquierda, Raiz, Derecha)
     */
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

    /**
     * Realiza un recorrido Postorden del arbol y muestra los elementos.
     * (Izquierda, Derecha, Raiz)
     */
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

    /**
     * Elimina un empleado del arbol por su ID.
     * @param id El ID del empleado a eliminar.
     */
    public void eliminar(int id) {
        this.raiz = eliminarRec(this.raiz, id);
    }

    /**
     * Metodo auxiliar recursivo para eliminar un nodo del arbol.
     * @param root El nodo actual.
     * @param id El ID del empleado a eliminar.
     * @return El nodo resultante despues de la eliminacion.
     */
    private Nodo eliminarRec(Nodo root, int id) {
        if (root == null) {
            return root;
        }

        if (id < root.Data.getID()) {
            root.izquierdo = eliminarRec(root.izquierdo, id);
        } else if (id > root.Data.getID()) {
            root.derecho = eliminarRec(root.derecho, id);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (root.izquierdo == null) {
                return root.derecho;
            } else if (root.derecho == null) {
                return root.izquierdo;
            }

            // Nodo con dos hijos
            Nodo temp = findMin(root.derecho);
            root.Data = temp.Data;
            root.derecho = eliminarRec(root.derecho, temp.Data.getID());
        }
        return root;
    }

    /**
     * Encuentra el nodo con el valor mas pequeno en un subarbol.
     * Es un metodo auxiliar para el proceso de eliminacion.
     * @param node La raiz del subarbol.
     * @return El nodo con el valor minimo.
     */
    private Nodo findMin(Nodo node) {
        while (node.izquierdo != null) {
            node = node.izquierdo;
        }
        return node;
    }
}