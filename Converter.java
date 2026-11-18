import java.util.Scanner;

// Final version: combines length, temperature and weight in one menu-driven program
public class Converter {
    static double convertLength(double v, boolean kmToMiles) { return kmToMiles ? v * 0.621371 : v / 0.621371; }
    static double convertTemp(double v, boolean cToF) { return cToF ? v * 9 / 5 + 32 : (v - 32) * 5 / 9; }
    static double convertWeight(double v, boolean kgToLb) { return kgToLb ? v * 2.20462 : v / 2.20462; }

    static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a valid number."); }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Unit Converter ===");
            System.out.println("1. Km to Miles   2. Miles to Km");
            System.out.println("3. C to F        4. F to C");
            System.out.println("5. Kg to Lb      6. Lb to Kg");
            System.out.println("0. Exit");
            int ch = (int) readDouble(sc, "Choice: ");
            if (ch == 0) break;
            if (ch < 1 || ch > 6) { System.out.println("Invalid choice."); continue; }
            double v = readDouble(sc, "Value: ");
            double r = switch (ch) {
                case 1 -> convertLength(v, true);
                case 2 -> convertLength(v, false);
                case 3 -> convertTemp(v, true);
                case 4 -> convertTemp(v, false);
                case 5 -> convertWeight(v, true);
                default -> convertWeight(v, false);
            };
            System.out.printf("Result: %.2f%n", r);
        }
        sc.close();
    }
}
