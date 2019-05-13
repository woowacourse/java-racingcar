package racinggame;


import racinggame.domain.Car;
import racinggame.domain.LeagueHistory;
import racinggame.util.InputView;
import racinggame.util.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingApplication {
    public static void main(String[] args) {
        CarRacingApplication application = new CarRacingApplication();
        List<Car> cars = application.getCars();
        int totalTrial = application.getTotalTrial();

        League woowahanLeague = new League(totalTrial);
        LeagueHistory woowahanLeagueHistory = woowahanLeague.startRaceOf(cars);

        OutputView.showHistoryOf(woowahanLeagueHistory);
        OutputView.showWinnersOf(woowahanLeagueHistory, totalTrial);
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
}
