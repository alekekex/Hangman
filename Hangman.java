import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final int MAX_LIVES = 6;
    private ArrayList<String> words;
    private ArrayList<Character> guessed;
    private String word;
    private char[] letters;
    private char[] placeholder;
    private int wrong;
    private boolean isWinner;

    public Hangman(ArrayList<String> words) {
        this.words = words;
        this.guessed = new ArrayList<>();
        this.word = randomWord();
        this.letters = word.toCharArray();
        this.placeholder = new char[letters.length];
        this.wrong = 0;
        this.isWinner = false;
    }

    public void playGame(Scanner sc) {
        fillWithBlanks(letters.length);
        Display.drawHangman(wrong);

        while(!isWinner && wrong < MAX_LIVES) {
            displayWord();
            char guess = readGuess(sc);
            processGuess(guess);

            if(isGuessed())
                isWinner = true;
        }

        if(isWinner)
            System.out.println("Game Over! You correctly guessed the word " + word + "!\n");
        else System.out.println("Game Over! The correct word is: " + word + "\n");
    }

    public String randomWord() {
        Random rnd = new Random();
        int idx = rnd.nextInt(words.size());
        return words.get(idx).toUpperCase();//DEBUG: "angela".toUpperCase();
    }

    public void fillWithBlanks(int n) {
        int i;

        for(i = 0; i < n; i++)
            placeholder[i] = '_';
    }

    public void displayWord() {
        int i;
        System.out.print("GUESS THE WORD: ");

        for(i = 0; i < placeholder.length; i++)
            System.out.print(placeholder[i]);
        System.out.print("\n");
    }

    public char readGuess(Scanner sc) {
        char c;

        do {
            System.out.print("Enter a letter from A-Z: ");
            c = Character.toUpperCase(sc.nextLine().charAt(0));

            if(!(c >= 'A' && c <= 'Z'))
                System.out.println("Invalid input! Please try again.");
        } while(!(c >= 'A' && c <= 'Z'));

        return c;
    }

    public boolean checkIfExist(char c) {
        boolean result = false;
        int i;

        for(i = 0; i < letters.length; i++) {
            if(c == letters[i]) {
                result = true;
                i = letters.length;
            }
        }

        return result;
    }

    public void processGuess(char c) {
        if(guessed.contains(c))
            System.out.println("You already guessed this letter! Please try again.\n");
        else {
            guessed.add(c);

            if(checkIfExist(c)) {
                System.out.println("You guessed correctly!\n");
                int i;

                for(i = 0; i < letters.length; i++) {
                    if(letters[i] == c)
                        placeholder[i] = c;
                }
            }
            else {
                System.out.println("You guessed incorrectly...\n");
                wrong++;
                Display.drawHangman(wrong);
            }
        }
    }

    public boolean isGuessed() {
        boolean result = true;
        int i;

        for(i = 0; i < placeholder.length; i++) {
            if(placeholder[i] == '_') {
                result = false;
                i = placeholder.length;
            }
        }

        return result;
    }
}
