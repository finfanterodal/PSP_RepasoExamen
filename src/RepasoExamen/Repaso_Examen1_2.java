package RepasoExamen;/*
1.B. Modifica el programa del apartado A para que los hilos se comporten de forma secuencial, (espera a
        que el tercer hilo acabe para que se ejecute el segundo y a su vez, que el segundo acabe para que se
        ejecute el primero) y termina por último el programa principal. (1 punto)
*/

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author finfantefran
 */
public class Repaso_Examen1_2 extends Thread {

    String nome;
    boolean ocupado1 = true;
    boolean ocupado2 = false;
    boolean ocupado3 = false;

    public Repaso_Examen1_2(String nome) {
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


        // ABARTADO B)
        h3.start();
        h3.join();
        h2.start();
        h2.join();
        h1.start();
        h1.join();


        System.out.println("Thread main terminated");
    }

}