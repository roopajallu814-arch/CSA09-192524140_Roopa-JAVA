public class StringComparison {
    public static void main(String[] args) {
        String s = "";
        long start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            s = s + "A";
        }

        long end = System.nanoTime();

        System.out.println("String time: " + (end - start) + " ns");

        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            sb.append("A");
        }

        end = System.nanoTime();

        System.out.println("StringBuilder time: " + (end - start) + " ns");

        StringBuffer sf = new StringBuffer();
        start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            sf.append("A");
        }

        end = System.nanoTime();

        System.out.println("StringBuffer time: " + (end - start) + " ns");
    }
}