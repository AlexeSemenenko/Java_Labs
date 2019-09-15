import java.util.Scanner;

public class Functional{

    public static void showMenu() {
        System.out.println("1. Factorial !");
        System.out.println("2. Reverse string");
        System.out.println("3. Find substring");
        System.out.println("0. Exit");
        System.out.print("Choose one point of menu: ");
    }

    public static void firstPoint(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Input number(<= 20) : ");
        int n = scn.nextInt();
        if (n <= 20){
            System.out.println(n + "! = " + factorial(n));
        }
        else {
            System.out.println("Please, input a number less.");
            firstPoint();
        }
    }

    public static void secondPoint(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Input your string: ");
        String str = scn.nextLine();
        String rstr = new StringBuilder(str).reverse().toString();
        System.out.println("Your reversed string: " + rstr);
    }

    public static void thirdPoint(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Input your string: ");
        String str = scn.nextLine();
        System.out.println("Input your substring: ");
        String substr = scn.nextLine();
        boolean result = str.contains(substr);
        if (result == true){
            System.out.println("Your string " + str + " contains substring " + substr);
        }
        else{
            System.out.println("Your string " + str + " doesn't contain substring " + substr);
        }
    }

    private static long factorial(int n){
        long res = 1;

        while (n > 0)
        {
            res *= n;
            n--;
        }
        return res;
    }
}
