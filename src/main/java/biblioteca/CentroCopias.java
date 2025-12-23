package biblioteca;

import java.util.LinkedList;
import java.util.Queue;

public class CentroCopias {

    // cola de pedidos
    private Queue<String> fotocopias = new LinkedList<String>();
    private final int CAPACIDAD_MAX  = 2;
    private boolean abierto = true;

    public synchronized void usarFotocopiadora(String copia) {

        while(fotocopias.size() == CAPACIDAD_MAX && abierto) {
            System.out.println("Fotocopiadora en uso. Estudiante esperado....");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        fotocopias.add(copia);
        System.out.println(copia +" imprimiendo");
        notifyAll();
    }

    public synchronized String liberarFotocopiadora() {
        while(fotocopias.isEmpty() && abierto) {
            System.out.println("Fotocopiadora libre.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (fotocopias.isEmpty()) {
            return null;
        }
        String copia= fotocopias.poll();
        //System.out.println(copia+ " | fotocopiadoras libres "+fotocopias.size());
        notifyAll();
        return copia;
    }

    public boolean centroCopiasAbierto(){
        return abierto;
    }

    public synchronized void centroCopiasCerrado(){
        this.abierto = false;
        notifyAll();
    }
}
