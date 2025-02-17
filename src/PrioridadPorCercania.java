
import java.util.List;

public class PrioridadPorCercania implements StrategyPrioridad {

    @Override
    public Emergencia seleccionarEmergencia(List<Emergencia> emergencias) {
        if (emergencias.isEmpty()) {
            return null;
        }

        // USAREMOS UN BUCLE FOR PARA RECORRER LA LISTA Y ENCONTRAR LA EMERGENCIA MAS
        // CERCANA

        Emergencia emergenciaPrioritaria = emergencias.get(0);
        for (Emergencia emergencia : emergencias) {
            if (emergencia.getTiempoRespuesta() < emergenciaPrioritaria.getTiempoRespuesta()) {
                emergenciaPrioritaria = emergencia;
            }
        }
        return emergenciaPrioritaria;
    }

}
