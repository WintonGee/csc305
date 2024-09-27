package lab_8c;

class WordPrinter implements Runnable {

    private final String word;
    private final int maxTimes;

    public WordPrinter(String word, int maxTimes) {
        this.word = word;
        this.maxTimes = maxTimes;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxTimes; i++) {
            System.out.println(word);

            // Adding sleep would "pause" the thread, so we can see the other threads working concurrently better
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}