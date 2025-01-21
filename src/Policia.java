public class Policia implements Responder{

    @Override
    public void atenderEmergencia() {
        System.out.println("[POLICIA]");
        System.out.println("Atendiendo emergencia...");
    }

    @Override
    public void evaluarEstado() {
        System.out.println("[POLICIA]");
        System.out.println("Evaluando estado...");
    }

}
