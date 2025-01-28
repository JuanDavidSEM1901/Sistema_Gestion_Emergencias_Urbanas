public class EmergenciaFactory {
    public static Emergencia crearEmergencia(String tipo, String ubicacion, int nivelGravedad, int tiempoRespuesta) {
        switch (tipo) {
            case "Incendio", "incendio":
                return new Incendio(ubicacion, nivelGravedad, tiempoRespuesta);
            case "Accidente Vehicular", "accidente vehicular":
                return new accidenteVehicular(ubicacion, nivelGravedad, tiempoRespuesta);
            case "Robo", "robo":
                return new Robo(ubicacion, nivelGravedad, tiempoRespuesta);
            default:
                throw new IllegalArgumentException("Tipo de emergencia no válido");    
        }
    }
}
