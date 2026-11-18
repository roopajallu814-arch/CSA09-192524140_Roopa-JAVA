import java.util.Scanner;

// Version A: length converter (basic, single conversion)
public class ConverterA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();
        System.out.println(km + " km = " + km * 0.621371 + " miles");
        System.out.println(km + " km = " + km * 1000 + " meters");
        sc.close();
    }
}
