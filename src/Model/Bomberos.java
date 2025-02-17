package Model;
public class Bomberos implements Responder {

    @Override
    public void atenderEmergencia() {
        System.out.println("[BOMBEROS]");
        System.out.println("Atendiendo emergencia...");
    }

    @Override
    public void evaluarEstado() {
        System.out.println("[BOMBEROS]");
        System.out.println("Evaluando estado...");
    }

}
