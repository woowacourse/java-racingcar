package racing.view;

import racing.model.TrialTime;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static String[] inputCarNames(){
        String carNames = scanner.nextLine();
        if (carNames == null || carNames.isEmpty()){
            throw new NullPointerException("차 이름이 입력되지 않았습니다.");
        }
        return splitByDelimiter(carNames);
    }

    private static String[] splitByDelimiter(String carNames) {
        return carNames.split(DELIMITER);
    }

    public static TrialTime inputTrialTime() {
        int trialTime = scanner.nextInt();
        return new TrialTime(trialTime);
    }
}


