package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DIVISION_CHAR = ",";
    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String START_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COUNT_EXCEPTION_MESSAGE = "[ERROR] 0보다 큰 숫자를 입력해야 합니다.";
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "[ERROR] 자동차 이름의 길이가 1이상 4자 이하여야 합니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MIN_COUNT_SIZE = 1;

    public String[] inputCarsName() {
        System.out.println(START_INPUT_CAR_NAME_MESSAGE);
        String[] inputCarsName = scanner.nextLine().split(DIVISION_CHAR);
        totalValidateInputCarName(inputCarsName);
        return inputCarsName;
    }

    public int inputCount() {
        System.out.println(COUNT_MESSAGE);
        int inputCount = scanner.nextInt();
        validationInputCountLength(inputCount);
        return inputCount;
    }

    private void totalValidateInputCarName(String[] inputCarsName) {
        for (String carName : inputCarsName) {
            validationCarNameLength((carName));
        }
    }

    public void validationInputCountLength(int count) {
        if (count < MIN_COUNT_SIZE) {
            throw new IllegalArgumentException(COUNT_EXCEPTION_MESSAGE);
        }
    }

    public void validationCarNameLength(String carName) throws IllegalArgumentException {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }
}
