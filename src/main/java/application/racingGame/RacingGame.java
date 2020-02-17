package application.racingGame;

import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        List<String> winners;
        while(true) {
            try {
                List<String> carNames = InputRacingInformation.getCarNames();
                int racingLabs = InputRacingInformation.getRacingLab();
                RaceParticipants raceParticipants = new RaceParticipants(carNames);
                RaceResult raceResult = new RaceResult();
                winners = raceResult.run(raceParticipants, racingLabs);
                break;
            } catch (Exception e) {
                OutputRacingView.printErrorMessage(e.getMessage());
            }
        }
        OutputRacingView.printWinner(winners);
    }
}