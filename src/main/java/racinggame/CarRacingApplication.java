package racinggame;


import racinggame.domain.Car;
import racinggame.domain.LeagueHistory;
import racinggame.domain.TrialHistory;
import racinggame.util.InputView;
import racinggame.util.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingApplication {
    private static final int RANDOM_BOUND = 10;

    public static void main(String[] args) {
        CarRacingApplication application = new CarRacingApplication();
        List<Car> cars = application.getCars();
        int totalTrial = application.getTotalTrial();
        LeagueHistory leagueHistory = new LeagueHistory();

        application.startLeague(leagueHistory, cars, totalTrial);
        OutputView.showHistory(leagueHistory);
        OutputView.showWinners(leagueHistory.findWinnersOf(totalTrial));
    }

    public List<Car> getCars() {
        try {
            List<String> carNames = InputView.getCarNames();
            return initializeCars(carNames);
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getCars();
        }
    }

    public List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTotalTrial() {
        try {
            return InputView.getTotalTrial();
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getTotalTrial();
        }
    }

    public void startLeague(LeagueHistory leagueHistory, List<Car> cars, int totalTrial) {
        for (int trial = 1; trial <= totalTrial; trial++) {
            randomMove(cars);
            leagueHistory.record(trial, new TrialHistory(cars));
        }
    }

    private void randomMove(List<Car> cars) {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND);
    }
}
