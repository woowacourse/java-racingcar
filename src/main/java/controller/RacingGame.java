package controller;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void startRacing() {
        // TODO [LTH]: 메서드 분리하기

        // 경주할 자동차 이름 입력
        String carNames = InputView.getCarNames();
        List<Car> cars = parseCarNames(carNames);
        Cars racingCars = new Cars(cars);

        // 시도할 횟수 입력
        String rawRoundCounts = InputView.getRacingRounds();
        int roundCount = InputView.parseRoundCounts(rawRoundCounts);

        //  라운드별 결과 출력
        startRounds(roundCount, racingCars);

        // 최종 우승자 출력
        int maxDistance = racingCars.getMaxDistance();
        OutputView.printResultNotice();
        OutputView.printWinners(racingCars.getWinners(maxDistance));
    }

    private void startRounds(final int roundCounts, final Cars cars) {
        for (int i = 0; i < roundCounts; i++) {
            List<Car> updateRaceRound = cars.updateRaceRound();
            OutputView.printRoundResult(updateRaceRound);
        }
    }

    private List<Car> parseCarNames(final String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
