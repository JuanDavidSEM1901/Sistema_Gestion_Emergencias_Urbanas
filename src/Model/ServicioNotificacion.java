package Model;

public class ServicioNotificacion implements Observador {

    @Override
    public void notificarEmergencia(Emergencia emergencia) {
        System.out.println("Notificación enviada: Nueva emergencia registrada - " + emergencia.getTipo() + " en " + emergencia.getUbicacion());
    }
    
}
