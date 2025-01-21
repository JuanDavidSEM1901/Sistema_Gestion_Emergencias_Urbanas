import java.util.Comparator;
import java.util.List;

public class PrioridadPorCercania implements StrategyPrioridad{

    @Override
    public Emergencia seleccionarEmergencia(List<Emergencia> emergencias) {
        //pendiente por documentar
        return emergencias.stream().sorted(Comparator.comparingInt(Emergencia::getTiempoRespuesta).reversed()).findFirst().orElse(null);
    }

}
