package view;

import exception.CarNameLengthException;
import exception.TryCountException;

import java.util.Scanner;

public class InputView {
    private static final int MIN_COUNT_SIZE = 0;
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DIVISION_CHAR = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;


    public String[] inputCarName() {
        String[] inputCars = scanner.nextLine().split(DIVISION_CHAR);
        validateInputCarNames(inputCars);
        return inputCars;
    }

    public int inputCount() {
        int inputCount = scanner.nextInt();
        validateInputCount(inputCount);
        return inputCount;
    }

    private void validateInputCarNames(String[] inputCarNames) {
        for (String carName : inputCarNames) {
            validateInputCarName(carName);
        }
    }

    private void validateInputCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
            throw new CarNameLengthException();
        }
    }

    private void validateInputCount(int count) {
        if (count < MIN_COUNT_SIZE) {
            throw new TryCountException();
        }
    }
}
