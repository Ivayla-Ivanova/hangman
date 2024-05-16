import java.util.Scanner;

public class Console {
    private Scanner scanner;
    Console() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
    }

    public String readInput() {
        return scanner.next();
    }

    public void writeOutput(String message) {
        System.out.println(message);
    }

    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
