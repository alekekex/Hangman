public class Display {
    public static void displayIntro() {
        System.out.println("+-------------------------+");
        System.out.println("|   Welcome to Hangman!   |");
        System.out.println("+-------------------------+");
    }

    public static void drawHangman(int n) {
        switch(n) {
            case 0:
                System.out.println("""
                 +---+
                 |   |
                     |
                     |
                     |
                =====
                """);
                break;
            case 1:
                System.out.println("""
                 +---+
                 |   |
                 O   |
                     |
                     |
                =====
                """);
                break;
            case 2:
                System.out.println("""
                 +---+
                 |   |
                 O   |
                 |   |
                     |
                =====
                """);
                break;
            case 3:
                System.out.println("""
                 +---+
                 |   |
                 O   |
                /|   |
                     |
                =====
                """);
                break;
            case 4:
                System.out.println("""
                 +---+
                 |   |
                 O   |
                /|\\  |
                     |
                =====
                """);
                break;
            case 5:
                System.out.println("""
                 +---+
                 |   |
                 O   |
                /|\\  |
                /    |
                =====
                """);
                break;
            case 6:
                System.out.println("""
                 +---+
                 |   |
                 O   |
                /|\\  |
                / \\  |
                =====
                """);
                break;
        }
    }

    public static void displayOutro() {
        System.out.println("+---------------------------------------------+");
        System.out.println("|   Thanks for playing! See you again soon!   |");
        System.out.println("+---------------------------------------------+");
    }
}
