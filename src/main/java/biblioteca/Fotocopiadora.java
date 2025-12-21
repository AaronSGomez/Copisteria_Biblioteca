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

        while (true){
            String pedido = centroCopias.liberarFotocopiadora();
            try {
                System.out.println(pedido + "usa maquina " +id);
                Thread.sleep((int)(Math.random()*4000));

                System.out.println("Estudiante "+id+" ha terminado y libera maquina ");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}