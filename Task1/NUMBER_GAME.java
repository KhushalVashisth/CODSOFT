// This is a number guessing game
// user has to enter a number between 1 and 100
// the entered number will be checked with computers number and score will be Generated
// generating feedback whether the number you guessed is higher or lower than Random number
// there would be limited rounds
// user's score would be displayed at the end
//trying multiple attempts

//::Lets Start the Game


import java.util.Scanner;
import java.util.Random;
public class NUMBER_GAME {
    public static void main(String[] args){
            Random r1 = new Random();
            Scanner sc = new Scanner(System.in);
            int Random_number = r1.nextInt(100) + 1;
            int trials = 0;
            int win_count = 0;
            System.out.println("Enter the number of rounds for which you want to play ");
            int rounds = sc.nextInt();
            System.out.println("In this game there would be.." + rounds + "..rounds");
            while (true) {
                if (trials == rounds) {
                    System.out.println("the rounds are finished");
                    break;
                }
                System.out.println("Enter the number between 1 and 100:");
                int User_input = sc.nextInt();
//            System.out.println("Random number is:" + Random_number);
                trials++;   //count the number of trials
                if (User_input == Random_number) {
                    System.out.println("Tah-dah! you win!......The number you guessed is correct");
                    System.out.println("The number of trials taken to win====" + trials);
                    win_count++; //count the number of wins
                    break;

                } else if (Random_number > User_input) {
                    System.out.println("You lose..... The number you guessed is smaller....Guess Again");
                } else {
                    System.out.println("You lose..... The number you guessed is higher....Guess Again");
                }
            }

            System.out.println("the users score is = " + win_count + "  out of  " + trials + "  trials");
        }

    }

