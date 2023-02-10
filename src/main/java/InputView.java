import java.util.Scanner;

public class InputView {
    InputException inputException = new InputException();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DIVISION_CHAR = ",";
    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String START_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public String[] inputCarName() {
        System.out.println(START_INPUT_CAR_NAME_MESSAGE);
        String[] inputCars = scanner.nextLine().split(DIVISION_CHAR);
        validateInputCarName(inputCars);
        return inputCars;
    }

    public int inputCount() {
        System.out.println(COUNT_MESSAGE);
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
