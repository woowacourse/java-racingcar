package racingcar;

import java.util.List;

public class Output {

    private static final String POSITION_FLAG = "-";
    private static final String JOIN_REGEX = ", ";

    private static final String PRINT_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINT_INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PRINT_RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public void inputCarNameMessage() {
        System.out.println(PRINT_INPUT_CAR_NAME_MESSAGE);
    }

    public void inputAttemptCountMessage() {
        System.out.println(PRINT_INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(PRINT_RESULT_MESSAGE);
    }

    public void printPosition(List<Car> cars) {
        for (Car car : cars) {
            String position = makePositionString(car.getPosition());
            System.out.printf("%-5s : %s\n", car.getName(), position);
        }
        System.out.println();
    }

    private String makePositionString(int position) {
        String positionFlag = POSITION_FLAG;
        return positionFlag.repeat(position);
    }

    public void printWinner(List<String> winnerNames) {
        System.out.print(String.join(JOIN_REGEX, winnerNames));
        System.out.println(PRINT_WINNER_MESSAGE);
    }
}