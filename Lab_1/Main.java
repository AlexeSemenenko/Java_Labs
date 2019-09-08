import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int k;
        double x;
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Input x: ");
            x = in.nextDouble();
            System.out.println("Input k: ");
            k = in.nextInt();
        } catch (Throwable except)
        {
            System.out.println("Something went wrong");
            return;
        }
        System.out.printf("My calculation: %.3f ", Teylor_Calc.calculate(x, k));
        System.out.printf("Java sin: %.3f", Math.sin(x));
    }
}