public class TicketRedesign {
    public static void main(String[] args) {

        int tickets = 10000;

        long start = System.nanoTime();

        String ticket = "";

        for (int i = 1; i <= tickets; i++) {
            ticket = ticket + "Ticket " + i + "\n";
        }

        long end = System.nanoTime();

        System.out.println("String Time: " + (end - start) + " ns");

        start = System.nanoTime();

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= tickets; i++) {
            builder.append("Ticket ").append(i).append("\n");
        }

        end = System.nanoTime();

        System.out.println("StringBuilder Time: " + (end - start) + " ns");

        System.out.println("Total Tickets: " + tickets);
    }
}