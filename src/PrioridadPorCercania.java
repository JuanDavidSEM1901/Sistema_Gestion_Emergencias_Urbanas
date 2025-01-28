import java.util.Comparator;
import java.util.List;

public class PrioridadPorCercania implements StrategyPrioridad{

    @Override
    public Emergencia seleccionarEmergencia(List<Emergencia> emergencias) {
        // retornar la emergencia con menor tiempo de respuesta
        return emergencias.stream().min(Comparator.comparingInt(Emergencia::getTiempoRespuesta)).orElse(null);
    }

}
