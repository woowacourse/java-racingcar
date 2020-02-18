package racingcargame.view;

import racingcargame.domain.Car;
import racingcargame.domain.RacingGameResult;
import racingcargame.domain.Winners;
import racingcargame.exception.CarNameInputExceptionType;
import racingcargame.exception.CarsNameInputExceptionType;

import java.util.List;

public class OutputView {
    private static final String MOVE_DISTANCE = "-";

    private OutputView() { /* prevent creating OutputView instance */ }

    public static void printHead() {
        System.out.println("실행 결과");
    }

    public static void printErrorMessage(CarsNameInputExceptionType type) {
        if (type == CarsNameInputExceptionType.NO_CAR) {
            System.out.println("※자동차 이름이 입력되지 않았습니다. 다시 입력해 주세요.");
        }
        if (type == CarsNameInputExceptionType.ONLY_ONE_CAR) {
            System.out.println("※자동차 이름이 한 개만 입력되었습니다. 경주이므로 최소 두 개 이상의 자동차 이름을 입력해 주세요. (ex) pobi, crong");
        }
        if (type == CarsNameInputExceptionType.DUPLICATED_NAMES) {
            System.out.println("※중복되는 자동차 이름이 존재합니다. 각각 고유한 자동차 이름을 입력해 주세요.");
        }
    }

    public static void printErrorMessage(CarNameInputExceptionType type) {
        if (type == CarNameInputExceptionType.OVER_MAX_NAME_LENGTH) {
            System.out.println("※허용된 길이(5자)를 초과하는 자동차 이름이 존재합니다. 자동차 이름은 모두 5자 이하로 입력해 주세요.");
        }
        if (type == CarNameInputExceptionType.BLANK_NAME) {
            System.out.println("※이름이 없는 자동차가 존재합니다. 쉼표(,)가 연속으로 입력(,,)되지 않았는지 확인 주세요.");
        }
    }

    public static void printNotNumberFormatErrorMessage() {
        System.out.println("※시도 회수는 숫자(정수)만 입력해 주세요.");
    }

    public static void printInvalidTryNumberErrorMessage() {
        System.out.println("※시도 회수는 1 이상의 숫자만 입력해 주세요.");
    }

    private static void printPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName())
                .append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(MOVE_DISTANCE);
        }
        System.out.println(sb.toString());
    }

    public static void printPositions(RacingGameResult result) {
        List<Car> cars = result.getCars();
        for (Car car : cars) {
            OutputView.printPosition(car);
        }
        System.out.println();
    }

    public static void printAllPositions(List<RacingGameResult> results) {
        printHead();
        for (RacingGameResult result : results) {
            OutputView.printPositions(result);
        }
    }

    public static void printWinners(Winners winners) {
        String winnersMessage = String.join(",", winners.getNames()) + "이(가) 최종 우승했습니다.";
        System.out.println(winnersMessage);
    }
}
