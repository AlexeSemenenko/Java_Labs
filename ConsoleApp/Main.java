import jdk.nashorn.internal.ir.FunctionCall;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String point;
        Scanner scan = new Scanner(System.in);

        do{
            Functional.showMenu();

            point = scan.nextLine();

            switch (point){
                case "1":
                    Functional.firstPoint();
                    break;
                case "2":
                    Functional.secondPoint();
                    break;
                case "3":
                    Functional.thirdPoint();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Incorrect input! Please, try again.");
            }
        }while (!point.equals("0"));
    }
}

