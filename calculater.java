import java.util.Scanner;

public class calculater {
    public static void main(String[] args) {
        Scanner a=new Scanner(System.in);
        String out=" stop";
        System.out.println(" chose number from 1 to 10 or stop to exite");
        System.out.println(" 1 to add ");
        System.out.println("2 to sbtruct");
        System.out.println("3 to multipul");
        System.out.println("4 to dividion");
        System.out.println("5 to modulus  ");
        System.out.println("6 to find minimum number ");
        System.out.println( "7 to find maximum number");
        System.out.println(" 8 to find the average of numbers");
        System.out.println(" 9 to print the last result in calculator ");
        System.out.println("Enter 10 to print the list of all results in calculator");

        System.out.println(" enter number " );
        int num= a.nextInt();

        System.out.println("entr nunber one ");
        double num1= a.nextDouble();
        System.out.println("enter number two ");
        double num2= a.nextDouble();
        double lastresult=0;

//        while (!out.equals("stop")) {

            switch (num) {
                case 1:
                  lastresult= add(num1,num2);
                    break;

                case 2:
                lastresult=sub(num1,num2);
                break;
                case 3:
                   lastresult= mul(num1,num2);
                    break;
                case 4:
                   lastresult= div(num1,num2);
                    break;
                case 5:
                   lastresult= mood(num1,num2);
                    break;
                case 6:
//                  lastresult=  minnum(num1,num2);
//                    break;
//                case 7:
//                  lastresult=  maxnum(num1,num2);
                case 8:
                    System.out.println(lastresult);


            }}

public static double add(double n, double n2){
    double sum = n+n2;
    System.out.print(n +" + " +n2+" = ");

    return sum;
}

    public static double sub(double n, double n2){
        double sub = n-n2;
        System.out.print(n +" - " +n2+"= ");

        return sub;
    }
    public static double mul(double n, double n2){
        double mul = n*n2;
        System.out.print(n +" * " +n2+"= ");

        return mul;
    }
    public static double div(double n, double n2) {
        double diiv = 0;
        try {
            diiv = n / n2;
            System.out.print(n + " / " + n2 + "= ");
        } catch (Exception f) {
            f.getMessage();
        }
        return diiv;
    }

    public static double mood(double n, double n2){
        double mod = n%n2;
        System.out.println(n +" % " +n2+" = ");

        return mod;
    }
//    public static double minnum(double n, double n2){
//        if (n<=n2){
//            System.out.println(" the minimum number is " +n);
//        } else
//            System.out.println(" the minimum nuber is "+ n2);
//        return n;
//    }

//    public static double maxnum(double n, double n2){
//        if (n>=n2){
//            System.out.println(" the max number is " +n);
//        } else
//            System.out.println(" the max nuber is "+ n2);


//        return n;
    }}


