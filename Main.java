import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reader r = new Reader();
        String filePath = "words.txt";//DEBUG: "test.txt";
        ArrayList<String> list = r.readFile(filePath);
        boolean isRunning = true;

        while(isRunning) {
            Display.displayIntro();
            System.out.print("Are you ready to play? (Yes or No): ");
            String choice = sc.nextLine().toLowerCase();
            System.out.println()

            switch(choice) {
                case "yes":
                    Hangman game = new Hangman(list);
                    game.playGame(sc);
                    break;
                case "no":
                    Display.displayOutro();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input! Please try again.\n");
            }
        }

        sc.close();
    }
}
