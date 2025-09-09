import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArbolBinario arbolEmpleados = new ArbolBinario();
        List<Empleado> arregloEmpleados = new ArrayList<>();

        System.out.println("--- GENERANDO 100 EMPLEADOS ---");
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ids.add(i);
        }
        Collections.shuffle(ids); // IDs todos desordenados

        for (int i = 0; i < 100; i++) {
            int id = ids.get(i);
            String nombre = "Empleado_" + id;
            Empleado nuevoEmpleado = new Empleado(id, nombre);
            arbolEmpleados.insertar(nuevoEmpleado);
            arregloEmpleados.add(nuevoEmpleado);
        }

        System.out.println("100 empleados generados y almacenados en ambas estructuras.");
        System.out.println("Continúa en la siguiente fase para las operaciones y comparaciones.");
    }
}