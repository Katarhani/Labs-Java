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

