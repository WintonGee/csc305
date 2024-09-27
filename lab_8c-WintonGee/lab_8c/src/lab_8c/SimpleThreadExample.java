package lab_8c;

public class SimpleThreadExample {
    private static final int MAX_TIMES = 5;

    /**
     * Demonstration of the use of Threads.
     *
     * @param args command-line arguments, not used
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(new WordPrinter("first", MAX_TIMES)).start();
        Thread.sleep(10); // This isn't really needed, but it helps separate the printing
        new Thread(new WordPrinter("second", MAX_TIMES)).start();
    }
}