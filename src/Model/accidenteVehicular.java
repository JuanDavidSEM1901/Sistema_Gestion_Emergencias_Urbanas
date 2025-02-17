package Model;
public class accidenteVehicular extends Emergencia{

    public accidenteVehicular(String ubicacion, int nivelGravedad, int tiempoRespuesta) {
        super("Accidente Vehicular", ubicacion, nivelGravedad, tiempoRespuesta);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[ACCIDENTE VEHICULAR]");
        System.out.println("Ubicacion: " + this.getUbicacion());
        System.out.println("Nivel de gravedad: " + this.getNivelGravedad());
        System.out.println("Tiempo de respuesta: " + this.getTiempoRespuesta());
    }

}
