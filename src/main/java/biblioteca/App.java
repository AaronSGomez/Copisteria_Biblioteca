package biblioteca;

import java.util.ArrayList;
import java.util.List;


public class App {
   //aqui llamamos a los hilos
    public static void main(String[] args) throws InterruptedException {
        CentroCopias centroCopias = new CentroCopias();
        List<Estudiante> estudiantes = new ArrayList<>();


        for (int i = 1; i <= 5; i++) {
            Estudiante estudiante = new Estudiante(i, centroCopias);
            Thread thread = new Thread(estudiante);
            thread.start();
            estudiantes.add(estudiante);
        }

        Fotocopiadora c1 = new Fotocopiadora(1, centroCopias);
        Fotocopiadora c2 = new Fotocopiadora(2, centroCopias);
        Thread tk1 = new Thread(c1);
        Thread tk2 = new Thread(c2);
        tk1.start();
        tk2.start();

        Thread.sleep(20000);

        //se acaba el tiempo
        System.out.println("\n\nCENTRO COPIAS CERRADO\n");
        centroCopias.centroCopiasCerrado();

        //cerrado ya y damos tiempo a que los estudiantes terminen
        Thread.sleep(3000);
        System.out.println("\n\n--------------- RESULTADOS ---------------\n");
        for (Estudiante e : estudiantes) {
            e.getContadorCopias();
            System.out.println("Estudiante "+e.getId()+" hizo "+ e.getContadorCopias()+ " fotocopias");
        }
    }
}
