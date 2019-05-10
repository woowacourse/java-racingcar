package racinggame;


import racinggame.domain.Car;
import racinggame.domain.LeagueHistory;
import racinggame.domain.TrialHistory;
import racinggame.util.InputView;
import racinggame.util.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacingApplication {
    private static final int RANDOM_BOUND = 10;

    public List<Car> getCars() {
        try {
            List<String> carNames = InputView.getCarNames();
            return carNames.stream().map(Car::new).collect(Collectors.toList());
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getCars();
        }
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
            cars.forEach(car -> car.run(generateRandomNumber()));
            leagueHistory.record(trial, new TrialHistory(cars));
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
