public class Nodo {
    public Empleado Data;
    public Nodo izquierdo;
    public Nodo derecho;

    public Nodo(Empleado valData) {
        this.Data = valData;
        this.izquierdo = null;
        this.derecho = null;
    }
}