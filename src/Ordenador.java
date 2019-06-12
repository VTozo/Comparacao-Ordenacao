import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Ordenador {

    static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarQuicksort(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    static private int separarQuicksort(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int aux = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = aux;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    static void shellSort(int[] array) {
        int incremento = array.length / 2;
        while (incremento > 0) {
            for (int i = incremento; i < array.length; i++) {
                int j = i;
                int temp = array[i];
                while (j >= incremento && array[j - incremento] > temp) {
                    array[j] = array[j - incremento];
                    j = j - incremento;
                }
                array[j] = temp;
            }
            if (incremento == 2) {
                incremento = 1;
            } else {
                incremento *= (5.0 / 11);
            }
        }
    }

    static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        if (n - mid >= 0) System.arraycopy(a, mid, r, 0, n - mid);

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    private static void heapify(int[] array, int size) {
        for (int i = 1; i < size; i++) {
            if (array[i] > array[(i - 1) / 2]) {
                int j = i;
                while (array[j] > array[(j - 1) / 2]) {
                    swap(array, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }
            }
        }
    }

    static void heapSort(int[] array) {
        int n = array.length;
        heapify(array, n);

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            int j = 0, index;

            do {
                index = (2 * j + 1);
                if (index < (i - 1) && array[index] < array[index + 1])
                    index++;
                if (index < i && array[j] < array[index])
                    swap(array, j, index);

                j = index;

            } while (index < i);
        }
    }

    static void radixSort(int[] array) {
        int maior = array[0];
        for (int numero : array) if (numero > maior) maior = numero;
        int digitos = 1;
        while (maior / 10 > 0) {
            maior /= 10;
            digitos++;
        }

        for (int i = 0; i < digitos; i++) {
            List<List<Integer>> subarrays = new ArrayList<List<Integer>>();
            for (int j = 0; j < 10; j++) {
                subarrays.add(new ArrayList<Integer>());
            }

            for (int j = 0; j < array.length; j++) {
                subarrays.get((int) (array[j] % Math.pow(10, i + 1) / Math.pow(10, i))).add(array[j]);
            }
            int j = 0;
            for (List<Integer> subarray : subarrays) {
                for (int numero : subarray) {
                    array[j] = numero;
                    j++;
                }
            }
        }
    }

    static void aFazerSort6(int[] array) {
        Arrays.sort(array);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}