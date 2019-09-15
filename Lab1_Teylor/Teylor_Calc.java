public class Teylor_Calc{

    public static double calculate(double x, int k){
        double res = 0.0;
        double currentMember = 0.0;
        int step = 1;
        int minus = 1;

        do{
            currentMember = memberCalc(x, step);

            if (minus % 2 == 0){
                res -= currentMember;
            }
            else{
                res += currentMember;
            }

            step += 2;
            minus++;
        }while(Math.abs(currentMember) > Math.pow(10, -k));

        return res;
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

    private static double memberCalc(double x, int step){
        return Math.pow(x, step) / factorial(step);
    }
}
