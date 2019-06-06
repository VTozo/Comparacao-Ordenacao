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

}