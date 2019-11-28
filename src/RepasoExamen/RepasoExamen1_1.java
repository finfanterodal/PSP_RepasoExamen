package RepasoExamen;/*
PROBLEMA 1
1.A. Programa en java que crea tres hilos y los ejecuta. Los hilos escriben 8 veces el número de iteración
del bucle y su nombre. En cada iteración, después de escribir su nombre, se bloquean durante un tiempo
aleatorio de segundos y después vuelven a estar disponibles para su ejecución. El programa principal no
terminará hasta que hayan terminado los tres hilos. (1,5 puntos)
*/

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author finfantefran
 */
public class RepasoExamen1_1 extends Thread {

    String nome;
    boolean ocupado1 = true;
    boolean ocupado2 = false;
    boolean ocupado3 = false;

    public RepasoExamen1_1(String nome) {
        super(nome);
    }

    @Override
    public void run() {
        //APARTADO A) y B)
        for (int i = 1; i <= 8; i++) {
            System.out.println(i + ": " + getName());
            int tiempo = (int) (Math.random() * 100 + 1);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Repaso_Examen1_2.class.getName()).log(Level.SEVERE, null, ex);
            }
            yield();
        }


    }

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Repaso_Examen1_2 h1 = new Repaso_Examen1_2("hilo1");
        Repaso_Examen1_2 h2 = new Repaso_Examen1_2("hilo2");
        Repaso_Examen1_2 h3 = new Repaso_Examen1_2("hilo3");

        // APARTADO A)
        h1.start();
        h2.start();
        h3.start();
        h1.join();
        h2.join();
        h3.join();


        System.out.println("Thread main terminated");
    }

}
