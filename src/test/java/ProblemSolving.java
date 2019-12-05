import java.util.Scanner;

public class ProblemSolving {
    public static void main(String[] args) {


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a number :");
            int num = sc.nextInt();
            System.out.println(info(num));
        }
    }

    public static String info(int a) {
        if (a % 5 == 0 & a % 3 == 0) {
            return "mytheresa";
        } else if (a % 7 == 0 & a % 3 == 0) {
            return "mycloths";
        } else if (a % 3 == 0) {
            return "my";
        } else if (a % 5 == 0) {
            return "theresa";
        } else if (a % 7 == 0) {
            return "clothes";
        } else {
            System.out.println("Given number is not valid");
        }
        return null;
    }
}
