public class Empleado {
    public int ID;
    public String Nombre;

    public Empleado(int valID, String valNombre) {
        if (valID < 0) {
            throw new IllegalArgumentException("El ID del empleado no puede ser negativo.");
        }
        this.ID = valID;
        this.Nombre = valNombre;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + ", Nombre: " + this.Nombre;
    }
}