import java.util.*;

class Patient {
    String name;
    int severity;
    int arrival;

    Patient(String name, int severity, int arrival) {
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    public String toString() {
        return name + " - Severity: " + severity;
    }
}

public class Triage {
    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>(
            Comparator.comparingInt((Patient p) -> p.severity)
                      .thenComparingInt(p -> p.arrival)
        );

        queue.add(new Patient("Roopa", 3, 1));
        queue.add(new Patient("Priya", 1, 2));
        queue.add(new Patient("Anu", 2, 3));
        queue.add(new Patient("Ravi", 1, 4));

        System.out.println("Patient Treatment Order:");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}