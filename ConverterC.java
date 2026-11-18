import java.util.Scanner;

// Version C: weight converter with loop and input validation
public class ConverterC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter weight and unit (e.g. 70 kg, 150 lb) or 'exit': ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            String[] p = line.split("\\s+");
            try {
                double v = Double.parseDouble(p[0]);
                String u = p[1].toLowerCase();
                if (u.equals("kg")) System.out.printf("%.2f kg = %.2f lb%n", v, v * 2.20462);
                else if (u.equals("lb")) System.out.printf("%.2f lb = %.2f kg%n", v, v / 2.20462);
                else System.out.println("Unit must be kg or lb.");
            } catch (Exception e) {
                System.out.println("Invalid input. Example: 70 kg");
            }
        }
        sc.close();
    }
}
