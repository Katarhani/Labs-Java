/*
 * В этом варианте создаются несколько потоков, каждый из которых будет обрабатывать свою строку матрицы, и искать максимальный элемент в своей строке.
 */
public class MaxElementInMatrix {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
            {1, 5, 9},
            {3, 7, 8},
            {6, 2, 4}
        };

        // Массив для хранения результатов от каждого потока
        int[] results = new int[matrix.length];
        Thread[] threads = new Thread[matrix.length];

        // Запуск потока для каждой строки
        for (int i = 0; i < matrix.length; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                int maxInRow = matrix[row][0];
                for (int j = 1; j < matrix[row].length; j++) {
                    if (matrix[row][j] > maxInRow) {
                        maxInRow = matrix[row][j];
                    }
                }
                results[row] = maxInRow;
            });
            threads[i].start();
        }

        // Ожидание завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Поиск наибольшего элемента среди результатов
        int globalMax = results[0];
        for (int i = 1; i < results.length; i++) {
            if (results[i] > globalMax) {
                globalMax = results[i];
            }
        }

        System.out.println("The largest element in the matrix: " + globalMax);
    }
}

