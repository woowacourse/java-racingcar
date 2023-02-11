package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private static final String RESULT_POSTFIX = "가 최종 우승했습니다.";

    public void printPosition(List<Car> cars) {
<<<<<<< HEAD
        cars.forEach(car -> System.out.println(car.getName() + COLON + CAR_POSITION_SIGN.repeat(car.getPosition().getPosition())));
        enterLine();
    }

    public void printWinners(List<String> winners) {
        String winnerString = stringifyWinners(winners);
=======
        cars.forEach(car -> System.out.println(car.getName() + COLON + CAR_POSITION_SIGN.repeat(car.getPosition())));
        enterLine();
    }

    public void printWinners(List<String> winnerNames) {
        String winnerString = stringifyWinners(winnerNames);
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
        System.out.print(winnerString);
        System.out.println(RESULT_POSTFIX);
    }

    private static String stringifyWinners(List<String> winners) {
        int beginIndex = 1;
        int endIndex = winners.toString().length() - 1;
        return winners.toString().substring(beginIndex, endIndex);
    }

    public void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public void enterLine() {
        System.out.println();
    }
<<<<<<< HEAD
=======
public interface OutputView {

    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
>>>>>>> c8f298f (feat: 출력 메시지 상수 추가)
=======
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071

}
