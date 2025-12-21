package biblioteca;

import java.util.LinkedList;
import java.util.Queue;

public class App {
   //aqui llamamos a los hilos
    public static void main(String[] args) {
        CentroCopias centroCopias = new CentroCopias();

        for (int i = 0; i < 5; i++) {
            Estudiante estudiante = new Estudiante(i, centroCopias);
            Thread thread = new Thread(estudiante);
            thread.start();
        }

        Fotocopiadora c1 = new Fotocopiadora(1, centroCopias);
        Fotocopiadora c2 = new Fotocopiadora(2, centroCopias);

        Thread tk1 = new Thread(c1);
        Thread tk2 = new Thread(c2);

        tk1.start();
        tk2.start();
    }
}
