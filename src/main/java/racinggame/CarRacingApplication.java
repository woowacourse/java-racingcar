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

    public List<Car> getCars() {
        try {
            List<String> carNames = InputView.getCarNames();
            return initializeCars(carNames);
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private List<Car> initializeCars(final List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTotalTrial() {
        try {
            return InputView.getTrial();
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getTotalTrial();
        }
    }

    public void startLeague(LeagueHistory leagueHistory, List<Car> cars, final int totalTrial) {
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
        CarRacingApplication application = new CarRacingApplication();
        final List<Car> cars = application.getCars();
        final int totalTrial = application.getTotalTrial();
        final LeagueHistory leagueHistory = new LeagueHistory();

        application.startLeague(leagueHistory, cars, totalTrial);
        OutputView.showHistory(leagueHistory);
        OutputView.showWinners(leagueHistory.findWinners(totalTrial));
    }


}
