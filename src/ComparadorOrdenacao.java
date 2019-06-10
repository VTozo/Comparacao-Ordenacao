
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class ComparadorOrdenacao {
    public static void main(String[] args) {

        int n = 10000;
        long start;

        int[] quaseOrdenado, aleatorio, decrescente = new int[n], copia = new int[n];

        aleatorio = randomizeArray(IntStream.rangeClosed(1, n).toArray());

        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Arrays.sort(copia);
        reverseArray(copia);
        System.arraycopy(copia, 0, decrescente, 0, copia.length);

        // HEAP SORT

        start = System.currentTimeMillis();
        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Ordenador.heapSort(copia);
        System.out.printf("Heap Sort Aleatório    %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

        start = System.currentTimeMillis();
        System.arraycopy(decrescente, 0, copia, 0, copia.length);
        Ordenador.heapSort(copia);
        System.out.printf("Heap Sort Decrescente  %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

        // QUICK SORT

        start = System.currentTimeMillis();
        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Ordenador.quickSort(copia, 0, copia.length - 1);
        System.out.printf("Quick Sort Aleatório   %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

        start = System.currentTimeMillis();
        System.arraycopy(decrescente, 0, copia, 0, copia.length);
        Ordenador.quickSort(copia, 0, copia.length - 1);
        System.out.printf("Quick Sort Decrescente %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

        // SHELL SORT
        start = System.currentTimeMillis();
        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Ordenador.shellSort(copia);
        System.out.printf("Shell Sort Aleatório   %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

        start = System.currentTimeMillis();
        System.arraycopy(decrescente, 0, copia, 0, copia.length);
        Ordenador.shellSort(copia);
        System.out.printf("Shell Sort Decrescente %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

        // MERGE SORT
        start = System.currentTimeMillis();
        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Ordenador.mergeSort(copia, copia.length);
        System.out.printf("Merge Sort Aleatório   %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

        start = System.currentTimeMillis();
        System.arraycopy(decrescente, 0, copia, 0, copia.length);
        Ordenador.mergeSort(copia, copia.length);
        System.out.printf("Merge Sort Decrescente %.3f s%n", (float) (System.currentTimeMillis() - start) / 1000);

    }

    private static int[] randomizeArray(int[] array) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomPosition = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    private static int[] reverseArray(int[] arr){
        int temp;
        for( int i = 0; i < arr.length/2; ++i )
        {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

}
