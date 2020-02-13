package racingCar.view;

import racingCar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    void printRacingCar(RacingCar racingCar) {
        System.out.print(racingCar);
    }

    void printStartingComment() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
    }

    void printStateOfRacingCars(RacingCar[] racingCars, int numberToMove) {
        System.out.println("실행 결과");

        for (int i = 0; i < numberToMove; i++) {
            for (RacingCar racingCar : racingCars) {
                printRacingCar(racingCar);
                printRacingPosition(racingCar);
            }
            System.out.println();
        }
    }

    void printResult(RacingCar[] racingCars) {
        List<String> namesOfWinners = Arrays.asList(racingCars).stream().map(RacingCar::toString).collect(Collectors.toList());
        System.out.println(String.join(",", namesOfWinners) + "가 최종 우승했습니다.");
    }

    private void printRacingPosition(RacingCar racingCar) {
        String position = RacingCarPositionTranslator.translate(racingCar.getPostion());
        System.out.println(" : " + position);
    }
}
