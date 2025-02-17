package Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Emergencia;
import Model.Observador;
import Model.PrioridadPorGravedad;
import Model.StrategyPrioridad;

public class ControladorEmergencias {
    private static ControladorEmergencias instance;
    private List<Emergencia> listaEmergencias;
    private Map<String, Integer> recursosDisponibles;
    private int emergenciasAtendidas;
    private int tiempoTotalRespuesta;
    private StrategyPrioridad strategyPrioridad;
    private List<Observador> observadores;

    private ControladorEmergencias() {

        listaEmergencias = new ArrayList<>();
        recursosDisponibles = new HashMap<>();
        recursosDisponibles.put("Vehiculos", 10);
        recursosDisponibles.put("Personal", 20);
        recursosDisponibles.put("Gasolina", 100);

        emergenciasAtendidas = 0;
        tiempoTotalRespuesta = 0;
        strategyPrioridad = new PrioridadPorGravedad();
        observadores = new ArrayList<>();

    }

    public static ControladorEmergencias getInstance() {
        if (instance == null) {
            instance = new ControladorEmergencias();
        }
        return instance;
    }

    public void registrarNuevaEmergencia(Emergencia emergencia) {
        listaEmergencias.add(emergencia);
        System.out.println("Emergencia registrada: " + emergencia.getTipo());
        notificarObservadores(emergencia);
    }

    public void mostrarEmergencias() {
        for (Emergencia emergencia : listaEmergencias) {
            emergencia.mostrarDetalles();
        }
    }

    public void mostrarRecursosDisponibles() {
        for (Map.Entry<String, Integer> recurso : recursosDisponibles.entrySet()) {
            System.out.println(recurso.getKey() + ": " + recurso.getValue());
        }
    }

    public void atenderEmergencia() {
        if (listaEmergencias.isEmpty()) {
            System.out.println("No hay emergencias pendientes.");
            return;
        }

        Emergencia emergenciaPrioritaria = strategyPrioridad.seleccionarEmergencia(listaEmergencias);

        if (emergenciaPrioritaria != null) {
            System.out.println("Atendiendo emergencia prioritaria: ");
            emergenciaPrioritaria.mostrarDetalles();
            listaEmergencias.remove(emergenciaPrioritaria);
            actualizarRecursos();
            emergenciasAtendidas++;
            tiempoTotalRespuesta += emergenciaPrioritaria.getTiempoRespuesta();
        }
    }

    private void actualizarRecursos() {
        recursosDisponibles.put("Vehiculos", recursosDisponibles.get("Vehiculos") - 1);
        recursosDisponibles.put("Personal", recursosDisponibles.get("Personal") - 2);
        recursosDisponibles.put("Gasolina", recursosDisponibles.get("Gasolina") - 10);
    }

    public void mostrarEstadisticas() {
        System.out.println("[ESTADISTICAS DEL SISTEMA]");
        System.out.println("Emergencias atendidas: " + emergenciasAtendidas);
        System.out.println("Tiempo promedio de respuesta: "
                + (emergenciasAtendidas > 0 ? tiempoTotalRespuesta / emergenciasAtendidas : 0) + " minutos");
        System.out.println("Recursos restantes: ");
        mostrarRecursosDisponibles();
    }

    public void cambiarEstrategia(StrategyPrioridad newStrategyPrioridad) {
        this.strategyPrioridad = newStrategyPrioridad;
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    private void notificarObservadores(Emergencia emergencia) {
        for (Observador observador : observadores) {
            observador.notificarEmergencia(emergencia);
        }
    }

}
