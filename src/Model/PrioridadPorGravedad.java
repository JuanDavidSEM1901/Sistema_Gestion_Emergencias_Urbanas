package Model;
import java.util.Comparator;
import java.util.List;

public class PrioridadPorGravedad implements StrategyPrioridad {

    @Override
    public Emergencia seleccionarEmergencia(List<Emergencia> emergencias) {
        if (emergencias.isEmpty()) {
            return null;
        }

        // USAREMOS UN BUCLE FOR PARA RECORRER LA LISTA Y ENCONTRAR LA EMERGENCIA DE
        // MAYOR GRAVEDAD
        Emergencia emergenciaPrioritaria = emergencias.get(0);
        for (Emergencia emergencia : emergencias) {
            if (emergencia.getNivelGravedad() > emergenciaPrioritaria.getNivelGravedad()) {
                emergenciaPrioritaria = emergencia;
            }

        }
        return emergenciaPrioritaria;
    }

}
