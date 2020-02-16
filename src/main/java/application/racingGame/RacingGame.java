package application.racingGame;

import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        List<String> winners;
        while(true) {
            try {
                RacingCarConsoleInput racingCarConsoleInput = new RacingCarConsoleInput();
                RacingLabConsoleInput racingLabConsoleInput = new RacingLabConsoleInput();
                RaceParticipants raceParticipants = new RaceParticipants(racingCarConsoleInput);
                Race race = new Race();
                winners = race.run(raceParticipants, racingLabConsoleInput);
                break;
            } catch (Exception e) {
                OutputRacingView.printErrorMessage(e.getMessage());
            }
        }
        OutputRacingView.printWinner(winners);
    }
}