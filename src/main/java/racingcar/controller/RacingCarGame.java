package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingCarGame {
    public static void main(String[] args) {
        Cars cars = inputCarNames();

        Round round = inputRoundNumber();

        System.out.println("실행 결과");
        String result;
        while(round.isGoing()) {
            cars.play();
            result = cars.getResult();
            OutputView.printResult(result);
            System.out.println();
        }

        Winners winners = new Winners(cars);
        OutputView.printResult(winners.getWinnerNames());
    }

    private static Cars inputCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,)를 기준으로 구분합니다.)");
            String inputForNames = InputView.inputValue();
            return new Cars(inputForNames);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputCarNames();
        }
    }

    private static Round inputRoundNumber() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String inputForRound = InputView.inputValue();
            return new Round(inputForRound);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputRoundNumber();
        }
    }
}