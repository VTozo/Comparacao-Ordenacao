import java.util.Random;
import java.util.stream.IntStream;

public class ComparadorOrdenacao {
    public static void main(String[] args) {

        int n = 10000;

        int[] quaseOrdenado, aleatorio, decrescente, copia = new int[n];

        aleatorio = RandomizeArray(IntStream.rangeClosed(1, n).toArray());

        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Ordenador.heapSort(copia);

        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Ordenador.quickSort(copia, 0, copia.length - 1);

        System.arraycopy(aleatorio, 0, copia, 0, copia.length);
        Ordenador.shellSort(copia);

    }

    private static int[] RandomizeArray(int[] array) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomPosition = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

}
