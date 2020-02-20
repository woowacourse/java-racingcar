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
        System.out.println(type.getErrorMessage());
    }

    public static void printErrorMessage(CarNameInputExceptionType type) {
        System.out.println(type.getErrorMessage());
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
