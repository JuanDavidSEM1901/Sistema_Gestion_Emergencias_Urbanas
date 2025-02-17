public class EmergenciaFactory {
    public static Emergencia crearEmergencia(String tipo, String ubicacion, int nivelGravedad, int tiempoRespuesta) {

        String tipoEmergencia = tipo.trim().toUpperCase();

        switch (tipoEmergencia) {
            case "INCENDIO":
                return new Incendio(ubicacion, nivelGravedad, tiempoRespuesta);
            case "ACCIDENTE VEHICULAR":
                return new accidenteVehicular(ubicacion, nivelGravedad, tiempoRespuesta);
            case "ROBO":
                return new Robo(ubicacion, nivelGravedad, tiempoRespuesta);
            default:
                throw new IllegalArgumentException("Tipo de emergencia no válido");
        }
    }
}
