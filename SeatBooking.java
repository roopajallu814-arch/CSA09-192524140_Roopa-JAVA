class SeatBooking {

    private boolean booked = false;

    public synchronized void bookSeat() {
        if (!booked) {
            booked = true;
            System.out.println("Seat booked successfully");
        } else {
            System.out.println("Seat already booked");
        }
    }

    public void bookBlock() {
        synchronized (this) {
            if (!booked) {
                booked = true;
                System.out.println("Seat booked using block");
            } else {
                System.out.println("Seat already booked");
            }
        }
    }

    public void bookUnsafe() {
        if (!booked) {
            booked = true;
            System.out.println("Seat booked without synchronization");
        } else {
            System.out.println("Seat already booked");
        }
    }

    public static void main(String[] args) {

        SeatBooking seat = new SeatBooking();

        Thread t1 = new Thread(() -> seat.bookSeat());
        Thread t2 = new Thread(() -> seat.bookSeat());

        t1.start();
        t2.start();
    }
}