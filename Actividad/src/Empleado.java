/**
 * Clase que representa a un empleado con un ID unico y un nombre.
 */
public class Empleado {
    public int ID;
    public String Nombre;

    /**
     * Constructor para crear un nuevo objeto Empleado.
     * @param valID El ID unico del empleado. No puede ser negativo.
     * @param valNombre El nombre del empleado.
     */
    public Empleado(int valID, String valNombre) {
        if (valID < 0) {
            throw new IllegalArgumentException("El ID del empleado no puede ser negativo.");
        }
        this.ID = valID;
        this.Nombre = valNombre;
    }

    /**
     * Obtiene el ID del empleado.
     * @return El ID del empleado.
     */
    public int getID() {
        return ID;
    }

    /**
     * Retorna una representacion en cadena del objeto Empleado.
     * @return Una cadena que contiene el ID y el nombre del empleado.
     */
    @Override
    public String toString() {
        return "ID: " + this.ID + ", Nombre: " + this.Nombre;
    }
}