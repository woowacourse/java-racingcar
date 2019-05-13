package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.LeagueHistory;
import racinggame.util.InputView;
import racinggame.util.OutputView;

import java.util.List;

public class CarRacingApplication {
    public static void main(String[] args) {
        CarRacingApplication application = new CarRacingApplication();
        Cars cars = application.getCars();
        int totalTrial = application.getTotalTrial();

        League woowahanLeague = new League(totalTrial);
        LeagueHistory woowahanLeagueHistory = woowahanLeague.startRaceOf(cars);

        OutputView.showHistoryOf(woowahanLeagueHistory);
        OutputView.showWinnersOf(woowahanLeagueHistory, totalTrial);
    }

    public Cars getCars() {
        try {
            List<String> carNames = InputView.getCarNames();
            return new Cars(carNames);
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getCars();
        }
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
