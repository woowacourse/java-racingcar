import java.util.Scanner;

public class InputHandler {
    static Scanner scanner = new Scanner(System.in);

    String getInput() {
        String input = scanner.nextLine();
        return input;
    }

    String[] splitStringToArray(String input) {
        return input.split(" ");
    }


}
