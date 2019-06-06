import java.util.Random;
import java.util.stream.IntStream;

public class ComparadorOrdenacao {
    public static void main(String[] args) throws InterruptedException {

        int n = 10000;

        int[] quaseOrdenado, aleatorio, decrescente;
        aleatorio = RandomizeArray(IntStream.rangeClosed(1, n).toArray());

        // ordenador.quickSort(aleatorio, 0, n - 1);
        int[] incrementos = new int[]{5, 3, 1};
        Ordenador.shellSort(incrementos, aleatorio);

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
