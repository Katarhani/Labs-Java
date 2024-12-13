import java.util.concurrent.atomic.AtomicInteger;

public class SumArray {
    private static final int[] array = new int[1000000];
    private static final int MID = array.length / 2;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        Thread thread1 = new Thread(new SumTask(0, MID));
        Thread thread2 = new Thread(new SumTask(MID, array.length));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The sum of the array elements: " + SumTask.getResult());
    }

    static class SumTask implements Runnable {
        private final int start;
        private final int end;
        private static AtomicInteger result = new AtomicInteger(0);

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                result.addAndGet(array[i]);
            }
        }

        public static int getResult() {
            return result.get();
        }
    }
}

/*
// Вариант 2

import java.util.*;
import java.util.concurrent.*;

public class SumArray {
    private static final int[] array = new int[1000000];  // Пример большого массива
    private static final int THREAD_COUNT = 4;  // Количество потоков

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Заполняем массив случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;  // Для упрощения, будем суммировать единицы
        }

        // Создаем пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int chunkSize = array.length / THREAD_COUNT;

        // Список задач для каждого потока
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * chunkSize;
            final int end = (i == THREAD_COUNT - 1) ? array.length : (i + 1) * chunkSize;

            futures.add(executor.submit(new SumTask(start, end)));
        }

        // Ожидаем завершения всех потоков и складываем их результаты
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        // Выводим результат
        System.out.println("Сумма элементов массива: " + totalSum);

        // Завершаем работу пула потоков
        executor.shutdown();
    }

    static class SumTask implements Callable<Integer> {
        private final int start;
        private final int end;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }
    }
}
*/