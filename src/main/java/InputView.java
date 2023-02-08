import java.util.Scanner;

public class InputView {
    InputException inputException = new InputException();
    private static final Scanner scanner = new Scanner(System.in);

    public String[] inputCarName() {
        String[] inputCars = scanner.nextLine().split(",");
        validateInputCarName(inputCars);
        return inputCars;
    }

    public int inputCount() {
        return validateInputCount(scanner.nextInt());
    }

    private void validateInputCarName(String[] inputCars) {
        for (String car : inputCars) {
            inputException.checkCarNameLength(car);
        }
    }

    private int validateInputCount(int count) {
        inputException.checkInputCountLength(count);
        return count;
    }
}
