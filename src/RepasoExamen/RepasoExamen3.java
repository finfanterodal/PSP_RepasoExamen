package RepasoExamen;

/*
* PROBLEMA 3
Crea una clase Java que utilice 3 hilos para contar el número de mayúsculas, minúsculas o números que
hay en un determinado texto (que puede ser introducido por teclado o estar en un fichero). Cada hilo se
encargará de contar una condición diferente, actualizando todos los hilos una misma variable común que
representa el número de ocurrencias totales encontradas. (3 puntos)
* */
public class RepasoExamen3 extends Thread {

    static int conMayus = 0;
    static int conMinus = 0;
    static int num = 0;
    static Integer total = 0;
    final static String cadena = "eESFA es u32n exa4324FAF2men de pspAF 23";

    public RepasoExamen3(String nombre) {
        super(nombre);
    }


    @Override
    public void run() {
        System.out.println(getName());
        String[] cadena2 = cadena.split("");
        for (int i = 0; i < cadena2.length; i++) {
            char valChar = cadena2[i].charAt(0);
            int asciiValue = valChar;

            if ("HiloMayus".equals(getName()) && (asciiValue >= 65 && asciiValue <= 90)) {
                System.out.println(getName() + " " + cadena2[i]);
                conMayus++;
                total++;
            }
            if ("HiloMinus".equals(getName()) && (asciiValue >= 97 && asciiValue <= 122)) {
                System.out.println(getName() + " " + cadena2[i]);
                total++;
            }
            if ("HiloNumeros".equals(getName()) && (asciiValue >= 48 && asciiValue <= 57)) {
                System.out.println(getName() + " " + cadena2[i]);
                total++;
            }

        }

        if ("HiloNumeros".equals(getName())) {
            System.out.println("TOTAL: " + total);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RepasoExamen3 h1 = new RepasoExamen3("HiloMayus");
        RepasoExamen3 h2 = new RepasoExamen3("HiloMinus");
        RepasoExamen3 h3 = new RepasoExamen3("HiloNumeros");
        h1.start();
        h1.join();
        h2.start();
        h2.join();
        h3.start();
        System.out.println("Thread main terminated.");
    }
}
