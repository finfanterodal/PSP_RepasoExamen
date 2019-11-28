package RepasoExamen;

/*
PROBLEMA 2
Programa en java que ejecute 3 hilos de forma concurrente. El primer hilo contará las vocales que hay en
un determinado texto (introducido por teclado), el segundo, las consonantes; el tercero suma el total de
letras a partir de las cantidades obtenidas en el primer y el segundo hilo. El programa principal no
terminará hasta que hayan terminado los cuatro hilos. (2 puntos)
* */
public class RepasoExamen2 extends Thread {

    static int conC=0;
    static int conV=0;
    static int total=0;

    final static String cadena = "este es un examen de psp";

    public RepasoExamen2(String name) {
        super(name);
    }

    @Override
    public void run() {
        String cadena2[] = cadena.split("");
        for (int i = 0; i < cadena2.length; i++) {
            if ((cadena2[i].equals("a") || cadena2[i].equals("e") || cadena2[i].equals("i") || cadena2[i].equals("o") || cadena2[i].equals("u"))&&getName().equals("HiloVocales")) {
                System.out.println("Vocal  " + cadena2[i]);
                conV++;
            } else if (!(cadena2[i].equals("a") || cadena2[i].equals("e") || cadena2[i].equals("i") || cadena2[i].equals("o") || cadena2[i].equals("u"))&& !(cadena2[i].equals(" "))&&getName().equals("HiloConsonantes")) {
                System.out.println("Consonante  " + cadena2[i]);
                conC++;
            }
        }
        if(getName().equals("HiloContador")){
            total=conC+conV;
            System.out.println(getName()+"Numero total: "+ total);
        }


    }

    public static void main(String[] args) throws InterruptedException {
        RepasoExamen2 vocales = new RepasoExamen2("HiloVocales");
        RepasoExamen2 consonantes = new RepasoExamen2("HiloConsonantes");
        RepasoExamen2 contador = new RepasoExamen2("HiloContador");
        vocales.start();
        vocales.join();
        consonantes.start();
        consonantes.join();
        contador.start();
        contador.join();
        System.out.println("Thread main terminated");
    }
}
