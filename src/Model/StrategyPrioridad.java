package Model;
import java.util.List;

public interface StrategyPrioridad {
    
    Emergencia seleccionarEmergencia(List<Emergencia> emergencias);
}
