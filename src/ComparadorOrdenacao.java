
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ComparadorOrdenacao {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTamanho do conjunto: ");
        int n = scanner.nextInt();

        while(n > 2) {
            long start;
            float tempoOrdenado, tempoDesordenado, tempoDecrescente;
            int[] aleatorio, ordenado = new int[n], decrescente = new int[n], copia = new int[n], almost = new int[n];
            //alterar ordenado para quaseOrdenado

            aleatorio = randomizeArray(IntStream.rangeClosed(1, n).toArray());
            System.arraycopy(aleatorio, 0, copia, 0, copia.length);
            Arrays.sort(copia);
            System.arraycopy(copia, 0, ordenado, 0, copia.length);
            System.arraycopy(copia, 0, almost, 0, almost.length);
            almostArray(almost);
            reverseArray(copia);
            System.arraycopy(copia, 0, decrescente, 0, copia.length);

            System.out.printf("%-12s%9s%12s%12s%n", "Algoritmo", "Ordenado", "Desordenado", "Decrescente");


            // HEAPSORT
            start = System.currentTimeMillis();
            System.arraycopy(aleatorio, 0, copia, 0, copia.length);
            Ordenador.heapSort(copia);
            tempoDesordenado = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(decrescente, 0, copia, 0, copia.length);
            Ordenador.heapSort(copia);
            tempoDecrescente = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(ordenado, 0, copia, 0, copia.length);
            Ordenador.heapSort(copia);
            tempoOrdenado = (float) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("%-12s%7.3f s%10.3f s%10.3f s%n", "Heapsort", tempoOrdenado, tempoDesordenado, tempoDecrescente);


            // QUICKSORT
            start = System.currentTimeMillis();
            System.arraycopy(aleatorio, 0, copia, 0, copia.length);
            Ordenador.quickSort(copia, 0, copia.length - 1);
            tempoDesordenado = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(decrescente, 0, copia, 0, copia.length);
            Ordenador.quickSort(copia, 0, copia.length - 1);
            tempoDecrescente = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(ordenado, 0, copia, 0, copia.length);
            Ordenador.quickSort(copia, 0, copia.length - 1);
            tempoOrdenado = (float) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("%-12s%7.3f s%10.3f s%10.3f s%n", "Quicksort", tempoOrdenado, tempoDesordenado, tempoDecrescente);


            // SHELLSORT
            start = System.currentTimeMillis();
            System.arraycopy(aleatorio, 0, copia, 0, copia.length);
            Ordenador.shellSort(copia);
            tempoDesordenado = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(decrescente, 0, copia, 0, copia.length);
            Ordenador.shellSort(copia);
            tempoDecrescente = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(ordenado, 0, copia, 0, copia.length);
            Ordenador.shellSort(copia);
            tempoOrdenado = (float) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("%-12s%7.3f s%10.3f s%10.3f s%n", "Shellsort", tempoOrdenado, tempoDesordenado, tempoDecrescente);


            // MERGESORT
            start = System.currentTimeMillis();
            System.arraycopy(aleatorio, 0, copia, 0, copia.length);
            Ordenador.mergeSort(copia, copia.length);
            tempoDesordenado = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(decrescente, 0, copia, 0, copia.length);
            Ordenador.mergeSort(copia, copia.length);
            tempoDecrescente = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(ordenado, 0, copia, 0, copia.length);
            Ordenador.mergeSort(copia, copia.length);
            tempoOrdenado = (float) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("%-12s%7.3f s%10.3f s%10.3f s%n", "Mergesort", tempoOrdenado, tempoDesordenado, tempoDecrescente);


            // RADIXSORT
            start = System.currentTimeMillis();
            System.arraycopy(aleatorio, 0, copia, 0, copia.length);
            Ordenador.radixSort(copia);
            tempoDesordenado = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(decrescente, 0, copia, 0, copia.length);
            Ordenador.radixSort(copia);
            tempoDecrescente = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(ordenado, 0, copia, 0, copia.length);
            Ordenador.radixSort(copia);
            tempoOrdenado = (float) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("%-12s%7.3f s%10.3f s%10.3f s%n", "Radixsort", tempoOrdenado, tempoDesordenado, tempoDecrescente);


            // AFAZERSORT
            start = System.currentTimeMillis();
            System.arraycopy(aleatorio, 0, copia, 0, copia.length);
            Ordenador.aFazerSort6(copia);
            tempoDesordenado = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(decrescente, 0, copia, 0, copia.length);
            Ordenador.aFazerSort6(copia);
            tempoDecrescente = (float) (System.currentTimeMillis() - start) / 1000;

            start = System.currentTimeMillis();
            System.arraycopy(ordenado, 0, copia, 0, copia.length);
            Ordenador.aFazerSort6(copia);
            tempoOrdenado = (float) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("%-12s%7.3f s%10.3f s%10.3f s%n", "Afazersort", tempoOrdenado, tempoDesordenado, tempoDecrescente);

            System.out.print("\nTamanho do conjunto: ");
            n = scanner.nextInt();
        }

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

    private static int[] reverseArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; ++i) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    private static int[] almostArray(int[] a) {
        Random r = new Random();

        int s1, s2, s3, s4, aux;
        s1 = r.nextInt(a.length - 1 - 0);
        s2 = r.nextInt(a.length - 1 - 0);
        s3 = r.nextInt(a.length - 1 - 0);
        s4 = r.nextInt(a.length - 1 - 0);

        while (true) {
            if (s1 != s2) {
                if (s3 != s4) {
                    aux = a[s1];
                    a[s1] = a[s2];
                    a[s2] = aux;
                    aux = a[s3];
                    a[s3] = a[s4];
                    a[s4] = aux;
                    return a;
                } else {
                    s4 = r.nextInt(a.length - 1 - 0);
                }
            } else {
                s2 = r.nextInt(a.length - 1 - 0);
            }
        }
    }
}
