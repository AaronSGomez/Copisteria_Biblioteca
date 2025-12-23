package biblioteca;

public class Fotocopiadora implements Runnable{

    private  CentroCopias centroCopias;
    private int id;

    public Fotocopiadora(int id,CentroCopias centroCopias){
        this.id = id;
        this.centroCopias = centroCopias;
    }

    @Override
    public void run() {

        while (centroCopias.centroCopiasAbierto()){
            String pedido = centroCopias.liberarFotocopiadora();

            if (pedido == null) {
                System.out.println("Fotocopiadora " + id + ": No hay más trabajos, apagando.");
                break;
            }

            try {
                System.out.println(pedido + " usa maquina " +id);
                Thread.sleep((int)(Math.random()*2000));

                System.out.println(pedido+" ha terminado y libera maquina ");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}