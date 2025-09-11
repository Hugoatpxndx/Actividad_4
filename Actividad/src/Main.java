import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Clase principal que gestiona la creacion de los datos, la demostracion de las operaciones
 * del arbol binario y la comparacion de rendimiento con una busqueda secuencial.
 */
public class Main {

    /**
     * Realiza una busqueda secuencial en una lista de empleados.
     * Este metodo se utiliza para comparar el rendimiento con el arbol binario.
     * @param arreglo La lista de empleados a buscar.
     * @param id El ID del empleado a encontrar.
     * @return El objeto Empleado si se encuentra, de lo contrario null.
     */
    public static Empleado buscarEnArreglo(List<Empleado> arreglo, int id) {
        for (Empleado empleado : arreglo) {
            if (empleado.getID() == id) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Metodo principal que coordina todas las operaciones del programa.
     * Genera los empleados, los inserta en el arbol y el arreglo,
     * y realiza las demostraciones de busqueda, recorridos y eliminacion.
     * Ademas, redirige la salida a un archivo de logs.
     * @param args Argumentos de la linea de comandos (no se usan en este programa).
     */
    public static void main(String[] args) {
        try {
            File logFile = new File("logs.txt");
            FileOutputStream fos = new FileOutputStream(logFile);
            PrintStream ps = new PrintStream(fos);
            PrintStream originalOut = System.out;
            System.setOut(ps);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("LOG GENERADO EL: " + sdf.format(new Date()));
            System.out.println("----------------------------------------------");

            ArbolBinario arbolEmpleados = new ArbolBinario();
            List<Empleado> arregloEmpleados = new ArrayList<>();

            System.out.println("--- GESTION DE EMPLEADOS ---");
            System.out.println("Generando 100 empleados...");

            List<Integer> ids = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                ids.add(i);
            }
            Collections.shuffle(ids);

            for (int i = 0; i < 100; i++) {
                int id = ids.get(i);
                String nombre = "Empleado_" + id;
                Empleado nuevoEmpleado = new Empleado(id, nombre);
                arbolEmpleados.insertar(nuevoEmpleado);
                arregloEmpleados.add(nuevoEmpleado);
            }

            System.out.println("100 empleados generados y almacenados en ambas estructuras.");

            System.out.println("\n--- COMPARANDO RENDIMIENTO DE BUSQUEDA ---");
            int idABuscar = 50;

            long inicioArreglo = System.nanoTime();
            buscarEnArreglo(arregloEmpleados, idABuscar);
            long finArreglo = System.nanoTime();
            double tiempoArreglo = (finArreglo - inicioArreglo) / 1_000_000.0;

            long inicioArbol = System.nanoTime();
            arbolEmpleados.buscar(idABuscar);
            long finArbol = System.nanoTime();
            double tiempoArbol = (finArbol - inicioArbol) / 1_000_000.0;

            System.out.println("Buscando ID: " + idABuscar);
            System.out.printf("Tiempo de busqueda en arreglo: %.2f ms\n", tiempoArreglo);
            System.out.printf("Tiempo de busqueda en arbol:   %.2f ms\n", tiempoArbol);

            System.out.println("\n--- RECORRIDOS DEL ARBOL BINARIO ---");
            System.out.println("\nRecorrido Preorden:");
            arbolEmpleados.recorridoPreorden();

            System.out.println("\nRecorrido Inorden (ordenado por ID):");
            arbolEmpleados.recorridoInorden();

            System.out.println("\nRecorrido Postorden:");
            arbolEmpleados.recorridoPostorden();

            System.out.println("\n--- DEMOSTRACION DE ELIMINACION ---");
            int idAEliminar = 50;
            System.out.println("Eliminando empleado con ID " + idAEliminar + "...");
            arbolEmpleados.eliminar(idAEliminar);

            System.out.println("\nListado de empleados despues de la eliminacion (Inorden):");
            arbolEmpleados.recorridoInorden();

            System.setOut(originalOut);
            System.out.println("\nLa ejecucion ha finalizado. Revisa el archivo 'logs.txt' para ver el resultado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}