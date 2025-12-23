package biblioteca;

public class Estudiante implements Runnable {

    private  CentroCopias centroCopias;
    private int id;
    private int contadorCopias;

    public Estudiante(int id, CentroCopias centroCopias) {
        this.id = id;
        this.centroCopias = centroCopias;
    }

    @Override
    public void run() {
        contadorCopias = 0;

        while (centroCopias.centroCopiasAbierto()) {
            String fotocopia = "Estudiante " + id;
            System.out.println("Estudiante " + id + " solicitando maquina");
            centroCopias.usarFotocopiadora(fotocopia);
            contadorCopias++;

            try {
                Thread.sleep((int)(Math.random()*3000));
                System.out.println("Estudiante "+id+" esta estudiando");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public int getId() {
        return id;
    }

    public int getContadorCopias() {
        return contadorCopias;
    }
}