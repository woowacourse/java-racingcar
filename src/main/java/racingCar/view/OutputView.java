package racingCar.view;

import racingCar.domain.RacingCar;

public class OutputView {
    void printRacingCar(RacingCar racingCar) {
        System.out.println(racingCar);
    }

    void printStartingComment() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
    }
}
