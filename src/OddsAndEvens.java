import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoose = salutation(input);
        game(input, userChoose);
    }

// ---------------------------------- salutation ------------------------------------------------------------------------------------------------------
    public static String salutation(Scanner input) {
        String userChoose;
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String userName = input.nextLine();
        System.out.print("Hi ");
        short rightInput = 0;
        do {
            System.out.print(userName + ", which do you choose? (O)dds or (E)vens? ");
            userChoose = input.nextLine();
            if (userChoose.equals("O")) {
                System.out.println(userName + " has picked odds! The computer will be evens.");
                rightInput = 1;
            }
            else if (userChoose.equals("E")) {
                System.out.println(userName + " has picked evens! The computer will be odds.");
                rightInput = 1;
            }
            else System.out.println("You entered the wrong letter! Please try again! \n");
        } while (rightInput == 0);
        System.out.println("--------------------------------------------------------");
        return userChoose;
    }

// ---------------------------------- game ------------------------------------------------------------------------------------------------------
    public static void game(Scanner input, String userChoose) {
        short userNumber, rightNumberFingers = 0;
        do {
            System.out.print("How many \"fingers\" do you put out? ");
            userNumber = input.nextShort();
            if (userNumber < 6) {
                rightNumberFingers = 1;
            } else {
                System.out.println("The number of fingers cannot be more than 5! Please try again.");
            }
        } while (rightNumberFingers == 0);
        Random rand = new Random();
        int computerNumber = rand.nextInt(6);
        System.out.println("The computer plays " + computerNumber + "\" fingers\"");
        System.out.println("--------------------------------------------------------");
        int sum = userNumber + computerNumber;
        System.out.println(userNumber + " + " + computerNumber + " = " + sum);
        boolean oddOrEven = sum % 2 == 0;
        if (oddOrEven) {
            System.out.println(sum + " is... even!");
            if (userChoose.equals("E")) {
                System.out.println("The user wins!");
            } else {
                System.out.println("The computer wins!");
            }
        } else {
            System.out.println(sum + " is... odd!");
            if (userChoose.equals("O")) {
                System.out.println("The user wins!");
            } else {
                System.out.println("The computer wins");
            }
        }
        System.out.println("--------------------------------------------------------");
    }
}