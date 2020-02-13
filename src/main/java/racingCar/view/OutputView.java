package racingCar.view;

import racingCar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printRacingCar(RacingCar racingCar) {
        System.out.print(racingCar);
    }

    public static void printStartingComment() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
    }

    public static void printAskingSentenceOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGuideOfResult() {
        System.out.println("실행 결과");
    }

    public static void printStateOfRacingCars(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            printRacingCar(racingCar);
            printRacingPosition(racingCar);
        }

        System.out.println();
    }

    public static void printResult(List<RacingCar> racingCars) {
        List<String> namesOfWinners = racingCars.stream().map(RacingCar::toString).collect(Collectors.toList());
        System.out.println(String.join(",", namesOfWinners) + "가 최종 우승했습니다.");
    }

    static private void printRacingPosition(RacingCar racingCar) {
        String position = RacingCarPositionTranslator.translate(racingCar.getPostion());
        System.out.println(" : " + position);
    }
}
