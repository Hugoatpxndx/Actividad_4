/**
 * Clase que representa un nodo del arbol binario.
 * Cada nodo contiene un objeto Empleado y referencias a sus nodos hijos.
 */
public class Nodo {
    public Empleado Data;
    public Nodo izquierdo;
    public Nodo derecho;

    /**
     * Constructor para crear un nuevo nodo.
     * @param valData El objeto Empleado que se almacenara en el nodo.
     */
    public Nodo(Empleado valData) {
        this.Data = valData;
        this.izquierdo = null;
        this.derecho = null;
    }
}