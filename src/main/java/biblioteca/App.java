package biblioteca;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws InterruptedException {
        CentroCopias centroCopias = new CentroCopias();
        List<Estudiante> estudiantes = new ArrayList<>();

    // INICIO HILOS ESTUDIANTES Y LOS GUARDO EN LIST PARA LUEGO OBTENER DATOS
        for (int i = 1; i <= 5; i++) {
            Estudiante estudiante = new Estudiante(i, centroCopias);
            Thread thread = new Thread(estudiante);
            thread.start();
            estudiantes.add(estudiante);
        }
    // INICIO FOTOCOPIADORAS
        Fotocopiadora c1 = new Fotocopiadora(1, centroCopias);
        Fotocopiadora c2 = new Fotocopiadora(2, centroCopias);
        Thread tk1 = new Thread(c1);
        Thread tk2 = new Thread(c2);
        tk1.start();
        tk2.start();

    // HILO MAIN SE EJECUTA SOLO POR 20 SEGUNDOS
        Thread.sleep(20000);

    // SE ACABA EL TIMPO, CIERRO COPISTERIA
        System.out.println("\n\nCENTRO COPIAS CERRADO\n");
        centroCopias.centroCopiasCerrado();

    // CERRADO, DAMOS TIEMPO A QUE TERMINEN COPIAS Y DE ESTUDIAR ANTES DE MOSTRAR RESULTADOS
        Thread.sleep(3000); // esto garantiza finalizacion antes de mostrar resultados

        System.out.println("\n\n--------------- RESULTADOS ---------------\n");
        for (Estudiante e : estudiantes) {
            e.getContadorCopias();
            System.out.println("Estudiante "+e.getId()+" hizo "+ e.getContadorCopias()+ " fotocopias");
        }
    }
}
