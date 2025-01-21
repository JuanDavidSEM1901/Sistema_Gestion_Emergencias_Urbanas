public class Robo extends Emergencia{

    public Robo(String ubicacion, int nivelGravedad, int tiempoRespuesta){
        super("Robo", ubicacion, nivelGravedad, tiempoRespuesta);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[ROBO]");
        System.out.println("Ubicacion: " + this.getUbicacion());
        System.out.println("Nivel de gravedad: " + this.getNivelGravedad());
        System.out.println("Tiempo de respuesta: " + this.getTiempoRespuesta());
        
    }

}
