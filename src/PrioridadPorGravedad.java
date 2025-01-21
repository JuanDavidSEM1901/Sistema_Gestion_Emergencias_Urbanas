import java.util.Comparator;
import java.util.List;

public class PrioridadPorGravedad implements StrategyPrioridad{

    @Override
    public Emergencia seleccionarEmergencia(List<Emergencia> emergencias) {
        //pendiente por documentar
        return emergencias.stream().sorted(Comparator.comparingInt(Emergencia::getNivelGravedad).reversed()).findFirst().orElse(null);
    }

}
