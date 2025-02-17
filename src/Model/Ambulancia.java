package Model;
public class Ambulancia implements Responder{

    @Override
    public void atenderEmergencia() {
        System.out.println("[AMBULANCIA]");
        System.out.println("Atendiendo emergencia...");
    }

    @Override
    public void evaluarEstado() {
        System.out.println("[AMBULANCIA]");
        System.out.println("Evaluando estado...");
    }

}
