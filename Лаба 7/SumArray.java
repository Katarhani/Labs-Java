public class SumArray {
    private static final int[] array = new int[1000000];  // Пример большого массива
    private static final int MID = array.length / 2;

    public static void main(String[] args) throws InterruptedException {
        // Заполняем массив случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;  // Для упрощения, будем суммировать единицы
        }

        // Создаем два потока для подсчета суммы
        Thread thread1 = new Thread(new SumTask(0, MID));
        Thread thread2 = new Thread(new SumTask(MID, array.length));

        // Запускаем потоки
        thread1.start();
        thread2.start();

        // Ожидаем завершения работы потоков
        thread1.join();
        thread2.join();

        // Выводим результат
        System.out.println("The sum of the array elements: " + SumTask.getResult());
    }

    static class SumTask implements Runnable {
        private final int start;
        private final int end;
        private static int result = 0;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            // Логика суммирования в заданном диапазоне
            for (int i = start; i < end; i++) {
                synchronized (SumTask.class) {
                    result += array[i];
                }
            }
        }

        public static int getResult() {
            return result;
        }
    }
}

