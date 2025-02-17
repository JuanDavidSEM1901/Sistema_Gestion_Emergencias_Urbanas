package Model;
public class Incendio extends Emergencia {

    public Incendio(String ubicacion, int nivelGravedad, int tiempoRespuesta) {
        super("Incendio", ubicacion, nivelGravedad, tiempoRespuesta);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[INCENDIO]");
        System.out.println("Ubicacion: " + this.getUbicacion());    
        System.out.println("Nivel de gravedad: " + this.getNivelGravedad());
        System.out.println("Tiempo de respuesta: " + this.getTiempoRespuesta());
    }

}
