package application.racingGame;

public class RacingCarConsoleInput implements RacingCarNameInput {

    @Override
    public String getCarNames() {
        OutputRacingView.startRacingGameMessage();
        return InputRacingInformation.getRacingValue();
    }
}
