package Model;
/*1. Se creo un interfaz responder para definir los comportamientos generales de
cualquier servicio de emergencia, como atender una emergencia y evaluar el estado.
 */
public interface Responder {
    void atenderEmergencia();
    void evaluarEstado();
}
