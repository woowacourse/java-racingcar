import java.util.Scanner;

public class Input {
    private Validate validate;
    private Scanner scanner;

    public Input() {
        validate = new Validate();
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public String[] getCarNames(String input) {
        String[] carNames = input.split(",");
        validate.isValidCarNames(carNames);
        return carNames;
    }

    public int getTryCount(String input) {
        validate.checkDigits(input);
        int tryCount = Integer.parseInt(input);
        validate.checkRange(tryCount);
        return tryCount;
    }
}
