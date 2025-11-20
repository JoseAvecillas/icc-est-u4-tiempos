import java.util.concurrent.Callable;

import controllers.SortMethods;
import models.Results;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] originalArray = generate(50000);

        int[] array1000 = new int[1000];
        System.arraycopy(originalArray, 0, array1000, 0, 1000);

        int[] array5000 = new int[5000];
        System.arraycopy(originalArray, 0, array5000, 0, 5000);

        int[] array10000 = new int[10000];
        System.arraycopy(originalArray, 0, array10000, 0, 10000);

        // int[] array100000 = new int[100000];
        // System.arraycopy(originalArray, 0, array100000, 0, 100000);

        // int[] array250000 = new int[250000];
        // System.arraycopy(originalArray, 0, array250000, 0, 250000);

        int[][] arrays = {array1000, array5000, array10000 ,originalArray};
        SortMethods sorter = new SortMethods();
        System.out.println("Burbuja");
        for (int[] array : arrays) {
            int size= array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortBubble(array);
                return null;
            };
            Results results = BenchMarking.medir_tiempo(funCallable, size, "Metodo burbuja" );
            System.out.println(results);
        }
        System.out.println("---------------------");
        System.out.println("Burbuja Mejorado");
        for (int[] array : arrays) {
            int size= array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortBubbleMejorado(array);
                return null;
            };
            Results results = BenchMarking.medir_tiempo(funCallable, size, "Metodo burbuja Mejorado" );
            System.out.println(results);
        }
        System.out.println("---------------------------");
        System.out.println("Shell");
        for (int[] array : arrays) {
            int size= array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortShell(array);
                return null;
            };
            Results results = BenchMarking.medir_tiempo(funCallable, size, "Metodo Shell" );
            System.out.println(results);
        }
        System.out.println("---------------------------");
        System.out.println("Merge");
        for (int[] array : arrays) {
            int size= array.length;
            Callable<Void> funCallable = () -> {
                sorter.mergeSort(array);
                return null;
            };
            Results results = BenchMarking.medir_tiempo(funCallable, size, "Metodo Merge Sort" );
            System.out.println(results);
        }
        System.out.println("---------------------------");

    }

    public static void funcion1(){
        for (int i = 0; i < 1000000; i++) {
            String s = "Numeros: " + i;
            System.out.println(s);
        }
    }


    public static int[] generate(int size){
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++) {
            numeros[i]= (int) (Math.random() * 10000);
        }
        return numeros;
    }
}

// long inicio = System.nanoTime();
//         for (int i = 0; i < 100000; i++) {
//             String s = " Numeros: " + i;
//             System.out.println(s);
//         }
//         long fin = System.nanoTime();

//         System.out.println("Tiempo transcurrido: " + (fin - inicio)  + " nanosegundos"  );
//         System.out.println("Tiempo transcurrido: " + (fin - inicio) / 1_000_000_000.0   + " segundos"  );
//         Results result =new Results(1, 
//                                     "Imprimir 100000 numeros", 
//                                     (fin - inicio) / 1_000_000_000.0);
//         System.out.println(result);
// Callable<Void> funCallable = ( ) -> {
//             funcion1();
//             return null;
//         };

//         Results r = BenchMarking.medir_tiempo(funCallable);
//         System.out.println(r);