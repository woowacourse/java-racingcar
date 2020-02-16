package racing.view;

import racing.model.TrialTime;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static String[] inputCarNames(){
        OutputView.printInputCarNamesMessage();
        String carNames = scanner.nextLine();
        try {
            checkCarNamesNullOrEmpty(carNames);
            return splitByDelimiter(carNames);
        } catch (Exception e){
            OutputView.printExceptionMessage(e);
        }
        return inputCarNames();
    }

    private static void checkCarNamesNullOrEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()){
            throw new NullPointerException("차 이름이 입력되지 않았습니다.");
        }
    }

    private static String[] splitByDelimiter(String carNames) {
        return carNames.split(DELIMITER);
    }

    public static TrialTime inputTrialTime() {
        OutputView.printInputTrialTimeMessage();
        String trialTime = scanner.nextLine();
        try {
            checkTrialTimeNullOrEmpty(trialTime);
            checkTrialTimeNotNumber(trialTime);
            return new TrialTime(Integer.parseInt(trialTime));
        } catch(Exception e){
            OutputView.printExceptionMessage(e);
        }
        return inputTrialTime();
    }

    private static void checkTrialTimeNotNumber(String trialTime){
        try {
            int trialTimeIntegerValue = Integer.parseInt(trialTime);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("시도횟수는 정수를 입력해주세요.");
        }
    }

    private static void checkTrialTimeNullOrEmpty(String trialTime) {
        if (trialTime == null || trialTime.isEmpty()){
            throw new NullPointerException("시도 횟수가 입력되지 않았습니다.");
        }
    }
}


