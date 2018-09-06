public class Multithreading {

    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        for (float i : arr) {
            i = 1f;
        }
        long a = System.currentTimeMillis();

        calculate(arr);
        long b = System.currentTimeMillis();
        System.out.println("In 1 thread: " + (b - a));

        calculateInThreads(arr);
        long c = System.currentTimeMillis();
        System.out.println("In 2 threads: " + (c - b));
    }

    private static void calculate(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void calculateInThreads(float[] arr) {

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread thread1 = new Thread(() -> calculate(a1));
        thread1.start();

        Thread thread2 = new Thread(() -> calculate(a2));
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

    }
}
