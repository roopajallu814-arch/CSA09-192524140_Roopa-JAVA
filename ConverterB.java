import java.util.Scanner;

// Version B: temperature converter with a menu
public class ConverterB {
    static double cToF(double c) { return c * 9 / 5 + 32; }
    static double fToC(double f) { return (f - 32) * 5 / 9; }
    static double cToK(double c) { return c + 273.15; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius\n3. Celsius to Kelvin");
        System.out.print("Choice: ");
        int ch = sc.nextInt();
        System.out.print("Value: ");
        double v = sc.nextDouble();
        switch (ch) {
            case 1 -> System.out.printf("%.2f C = %.2f F%n", v, cToF(v));
            case 2 -> System.out.printf("%.2f F = %.2f C%n", v, fToC(v));
            case 3 -> System.out.printf("%.2f C = %.2f K%n", v, cToK(v));
            default -> System.out.println("Invalid choice.");
        }
        sc.close();
    }
}
