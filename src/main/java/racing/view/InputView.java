package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static String[] inputCarNames(){
        OutputView.printInputCarNamesMessage();
        String carNames = scanner.nextLine();
        try {
            checkCarNamesNullOrEmpty(carNames);
            return splitByDelimiter(carNames);
        } catch (NullPointerException e){
            OutputView.printExceptionMessage(e);
        }
        return inputCarNames();
    }

    private static void checkCarNamesNullOrEmpty(final String carNames) {
        if (carNames == null || carNames.isEmpty()){
            throw new NullPointerException("차 이름이 입력되지 않았습니다.");
        }
    }

    private static String[] splitByDelimiter(final String carNames) {
        return carNames.split(DELIMITER);
    }

    public static int inputTrialTime() {
        OutputView.printInputTrialTimeMessage();
        String trialTime = scanner.nextLine();
        try {
            checkTrialTimeNull(trialTime);
            checkTrialTimeEmpty(trialTime);
            checkTrialTimeNotNumber(trialTime);
            checkTrialTimeNegativeOrZero(trialTime);
            return Integer.parseInt(trialTime);
        } catch(NullPointerException | IllegalArgumentException e){
            OutputView.printExceptionMessage(e);
        }
        return inputTrialTime();
    }

    private static void checkTrialTimeNotNumber(final String trialTime){
        try {
            int trialTimeIntegerValue = Integer.parseInt(trialTime);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("시도횟수는 정수를 입력해주세요.");
        }
    }

    private static void checkTrialTimeNull(final String trialTime) {
        if (trialTime == null){
            throw new NullPointerException("시도 횟수가 입력되지 않았습니다.");
        }
    }

    private static void checkTrialTimeEmpty(final String trialTime) {
        if (trialTime.isEmpty()){
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }
    }

    private static void checkTrialTimeNegativeOrZero(final String trialTime) {
        int trialTimeIntegerValue = Integer.parseInt(trialTime);
        if (trialTimeIntegerValue <= 0) {
            throw new IllegalArgumentException("시도횟수는 음수가 입력될 수 없습니다.");
        }
    }
}


