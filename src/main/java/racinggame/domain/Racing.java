package racinggame.domain;


import racinggame.util.InputView;
import racinggame.util.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final int RANDOM_BOUND = 10;

    public List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void startLeague(LeagueHistory leagueHistory, List<Car> cars, int totalTrial) {
        for (int trial = 1; trial <= totalTrial; trial++) {
            randomMove(cars);
            leagueHistory.record(trial, new TrialHistory(cars));
        }
    }

    private void randomMove(List<Car> cars) {
        for (Car car : cars) {
            car.run(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND);
    }

    public static void main(String[] args) {
        Racing racing = new Racing();
        List<Car> cars = racing.initializeCars(InputView.getCarNames());
        int totalTrial = InputView.getTrial();
        LeagueHistory leagueHistory = new LeagueHistory();

        racing.startLeague(leagueHistory, cars, totalTrial);
        leagueHistory.showHistory();
        OutputView.showWinners(leagueHistory.findWinners(totalTrial));
    }
}
