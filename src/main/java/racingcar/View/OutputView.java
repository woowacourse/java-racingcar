package racingcar.View;

public class OutputView {

    private static final String CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분";
    private static final String TRIAL_TIME_INPUT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void printInputCarNamesMessage(){
        System.out.println(CAR_NAMES_INPUT_GUIDE_MESSAGE);
    }

    public static void printInputTrialTimeMessage(){
        System.out.println(TRIAL_TIME_INPUT_GUIDE_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
