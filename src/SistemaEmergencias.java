import java.util.Scanner;

public class SistemaEmergencias {
    public static void main(String[] args) throws Exception {
        var entry = new Scanner(System.in);

        ControladorEmergencias controlador = ControladorEmergencias.getInstance();
        ServicioNotificacion notificacion = new ServicioNotificacion();
        controlador.agregarObservador(notificacion);

        boolean ejecucion = true;

        while (ejecucion) {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Registrar una nueva emergencia");
            System.out.println("2. Ver el estado de los recursos disponibles");
            System.out.println("3. Atender una emergencia");
            System.out.println("4. Cambiar estrategia de prioridad");
            System.out.println("5. Mostrar estadísticas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entry.nextInt();
            entry.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tipo de emergencia: Incendio, Accidente Vehicular o Robo");
                    String tipo = entry.nextLine();
                    
                    System.out.println("Ingrese la ubicación de la emergencia: ");
                    String ubicacion = entry.nextLine();
                    System.out.println("Ingrese el nivel de gravedad de la emergencia de 1 a 10: ");
                    int nivelGravedad = entry.nextInt();
                    System.out.println("Ingrese el tiempo de respuesta de la emergencia en minutos: ");
                    int tiempoRespuesta = entry.nextInt();

                    Emergencia nuevEmergencia = EmergenciaFactory.crearEmergencia(tipo, ubicacion, nivelGravedad, tiempoRespuesta);
                    controlador.registrarNuevaEmergencia(nuevEmergencia);
                    break;

                case 2:
                    controlador.mostrarRecursosDisponibles();
                    break;

                case 3:
                    controlador.atenderEmergencia();
                    break;

                case 4:
                System.out.println("Seleccione la nueva estrategia de prioridad:");
                System.out.println("1. Prioridad por Gravedad");
                System.out.println("2. Prioridad por Cercanía");
                int estrategiaSeleccionada = entry.nextInt();
                entry.nextLine();

                if (estrategiaSeleccionada == 1) {
                    controlador.cambiarEstrategia(new PrioridadPorGravedad());
                    System.out.println("Estrategia de prioridad cambiada a Prioridad por Gravedad.");
                } else if (estrategiaSeleccionada == 2) {
                    controlador.cambiarEstrategia(new PrioridadPorCercania());
                    System.out.println("Estrategia de prioridad cambiada a Prioridad por Cercanía.");
                } else {
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }

                break;

                case 5:
                    controlador.mostrarEstadisticas();
                    break;

                case 6: 
                    System.out.println("Saliendo del sistema de emergencias...");
                    ejecucion = false;
                    break;
                default: System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;         
            }
        }
        entry.close();
    }
}
