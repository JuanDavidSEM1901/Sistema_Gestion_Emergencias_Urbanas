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
                    String tipo;

                    while (true) {
                        tipo = entry.nextLine().trim().toUpperCase();
                        if (tipo.equals("INCENDIO") || tipo.equals("ACCIDENTE VEHICULAR") || tipo.equals("ROBO")) {
                            break;
                        }
                        System.out.println(
                                "Tipo de emergencia no válido. Por favor, ingrese 'Incendio', 'Accidente Vehicular' o 'Robo'.");
                    }

                    System.out.println("Ingrese la ubicación de la emergencia: ");

                    String ubicacion;

                    while (true) {

                        ubicacion = entry.nextLine().trim().toUpperCase();
                        // verificar que la ubicacion no este vacia y que sean solo letras
                        if (ubicacion.isEmpty()) {
                            System.out.println(
                                    "La ubicación no puede estar vacía. Por favor, ingrese una ubicación válida.");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Ingrese el nivel de gravedad de la emergencia de 1 a 10: ");
                    int nivelGravedad;
                    while (true) {

                        if (entry.hasNextInt()) {
                            nivelGravedad = entry.nextInt();
                            if (nivelGravedad >= 1 && nivelGravedad <= 10) {
                                break;
                            } else {
                                System.out.println(
                                        "El nivel de gravedad debe estar entre 1 y 10. Por favor, ingrese un nivel de gravedad válido.");
                            }
                        } else {
                            System.out.println("ENTRADA INVALIDA DEBE SER UN NUMERO");
                            entry.next();
                        }
                    }

                    System.out.println("Ingrese el tiempo de respuesta de la emergencia en minutos: ");
                    int tiempoRespuesta;

                    while (true) {
                        if (entry.hasNextInt()) {
                            tiempoRespuesta = entry.nextInt();
                            if (tiempoRespuesta > 0) {
                                break;
                            } else {
                                System.out.println(
                                        "El tiempo de respuesta debe ser mayor a 0. Por favor, ingrese un tiempo de respuesta válido.");
                            }
                        } else {
                            System.out.println("ENTRADA INVALIDA DEBE SER UN NUMERO");
                            entry.next();
                        }
                    }

                    Emergencia nuevEmergencia = EmergenciaFactory.crearEmergencia(tipo, ubicacion, nivelGravedad,
                            tiempoRespuesta);
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

                    int estrategiaSeleccionada;

                    while (true) { // Bucle para validar la entrada
                        if (entry.hasNextInt()) {
                            estrategiaSeleccionada = entry.nextInt();
                            entry.nextLine(); // Limpiar el buffer

                            if (estrategiaSeleccionada == 1) {
                                controlador.cambiarEstrategia(new PrioridadPorGravedad());
                                System.out.println("Estrategia de prioridad cambiada a Prioridad por Gravedad.");
                                break;
                            } else if (estrategiaSeleccionada == 2) {
                                controlador.cambiarEstrategia(new PrioridadPorCercania());
                                System.out.println("Estrategia de prioridad cambiada a Prioridad por Cercanía.");
                                break;
                            } else {
                                System.out.println("Opción inválida. Debe ingresar 1 o 2.");
                            }
                        } else {
                            System.out.println("ENTRADA INVÁLIDA. DEBE SER UN NÚMERO ENTRE 1 Y 2.");
                            entry.next(); // Limpiar la entrada incorrecta
                        }
                    }
                    break;

                case 5:
                    controlador.mostrarEstadisticas();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema de emergencias...");
                    ejecucion = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        entry.close();
    }
}
