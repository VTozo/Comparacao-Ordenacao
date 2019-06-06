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

    static void shellSort(int[] incrementos, int[] vetor) {
        int incr, j, k, span, y;
        for (incr = 0; incr < incrementos.length; incr++) {
            span = incrementos[incr];
            for (j = span; j < vetor.length; j++) {
                y = vetor[j];
                for (k = j - span; k >= 0 && y < vetor[k]; k -= span)
                    vetor[k + span] = vetor[k];
                vetor[k + span] = y;
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
            // if child is bigger than parent
            if (array[i] > array[(i - 1) / 2]) {
                int j = i;

                // swap child and parent until
                // parent is smaller
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
            // swap value of first indexed
            // with last indexed
            swap(array, 0, i);

            // maintaining heap property
            // after each swapping
            int j = 0, index;

            do {
                index = (2 * j + 1);

                // if left child is smaller than
                // right child point index variable
                // to right child
                if (index < (i - 1) && array[index] < array[index + 1])
                    index++;

                // if parent is smaller than child
                // then swapping parent with child
                // having higher value
                if (index < i && array[j] < array[index])
                    swap(array, j, index);

                j = index;

            } while (index < i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}