import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static Empleado buscarEnArreglo(List<Empleado> arreglo, int id) {
        for (Empleado empleado : arreglo) {
            if (empleado.getID() == id) {
                return empleado;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            // Crea un nuevo archivo de salida para los logs
            File logFile = new File("logs.txt");
            FileOutputStream fos = new FileOutputStream(logFile);
            PrintStream ps = new PrintStream(fos);

            // Guarda la salida original de la consola
            PrintStream originalOut = System.out;

            // Redirige la salida estándar a tu archivo
            System.setOut(ps);

            // --- AQUI VA EL CONTENIDO DEL MAIN ---

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

            // --- COMPARACION DE RENDIMIENTO ---
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

            // --- RECORRIDOS DEL ARBOL BINARIO ---
            System.out.println("\n--- RECORRIDOS DEL ARBOL BINARIO ---");
            System.out.println("\nRecorrido Preorden:");
            arbolEmpleados.recorridoPreorden();

            System.out.println("\nRecorrido Inorden (ordenado por ID):");
            arbolEmpleados.recorridoInorden();

            System.out.println("\nRecorrido Postorden:");
            arbolEmpleados.recorridoPostorden();

            // --- DEMOSTRACION DE ELIMINACION ---
            System.out.println("\n--- DEMOSTRACION DE ELIMINACION ---");
            int idAEliminar = 50;
            System.out.println("Eliminando empleado con ID " + idAEliminar + "...");
            arbolEmpleados.eliminar(idAEliminar);

            System.out.println("\nListado de empleados despues de la eliminacion (Inorden):");
            arbolEmpleados.recorridoInorden();

            // --- RESTAURA LA SALIDA DE LA CONSOLA ---
            System.setOut(originalOut);
            System.out.println("\nLa ejecucion ha finalizado. Revisa el archivo 'logs.txt' para ver el resultado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}