package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingCarGame {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,)를 기준으로 구분합니다.)");
        String inputForNames = InputView.inputValue();
        Cars cars = new Cars(inputForNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputForRound = InputView.inputValue();
        Round round = new Round(inputForRound);

        System.out.println("실행 결과");
        String result;
        while(round.isGoing()) {
            cars.play();
            result = cars.getResult();
            OutputView.printResult(result);
            System.out.println();
        }
    }
}