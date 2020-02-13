package racingCar.view;

import racingCar.domain.RacingCar;

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

    private void printRacingPosition(RacingCar racingCar) {
        String position = RacingCarPositionTranslator.translate(racingCar.getPostion());
        System.out.println(" : " + position);
    }
}
