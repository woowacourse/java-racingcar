package racingcar.view;

import racingcar.dto.Car;

import java.util.List;

public class OutputView {

    public static void printDuplicatedCarName() {
        System.out.println("중복된 이름은 안됩니다.\n다시 입력해 주세요.");
    }

    public static void printUnderNameLength() {
        System.out.println("글자 수는 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
    }

    public static void printOverNameLength() {
        System.out.println("글자 수는 5글자 이내여야 합니다.\n다시 입력해 주세요.");
    }

    public static void printRacingResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printRacingPosition(car.getPosition());
        }
        System.out.println();
    }

    public static void printRacingPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinner(String result) {
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
