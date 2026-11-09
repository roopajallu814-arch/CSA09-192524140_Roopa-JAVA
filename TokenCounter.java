class TokenCounter {

    private int count = 0;
    private final int limit = 5;

    public synchronized void produce(int value)
            throws InterruptedException {

        while (count == limit) {
            wait();
        }

        count++;
        System.out.println("Produced: " + value);

        notifyAll();
    }

    public synchronized void consume()
            throws InterruptedException {

        while (count == 0) {
            wait();
        }

        count--;
        System.out.println("Consumed one token");

        notifyAll();
    }

    public static void main(String[] args) {

        TokenCounter counter = new TokenCounter();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    counter.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    counter.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All tokens processed");
    }
}