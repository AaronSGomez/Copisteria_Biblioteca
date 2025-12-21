package biblioteca;

public class Estudiante implements Runnable {

    private  CentroCopias centroCopias;
    private int id;

    public Estudiante(int id, CentroCopias centroCopias) {
        this.id = id;
        this.centroCopias = centroCopias;
    }

    @Override
    public void run() {
        int contadorCopias = 1;

        while (true) {
            String fotocopia = "Estudiante " + id;
            System.out.println("Estudiante " + id + " solicitando maquina");
            centroCopias.usarFotocopiadora(fotocopia);
            contadorCopias++;

            try {
                Thread.sleep((int)(Math.random()*4000));
                System.out.println("Estudiante "+id+" esta estudiando");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}