package application.racingGame;

public class RacingLabConsoleInput implements RacingLabInput{

    @Override
    public String getRacingLabValue() {
        OutputRacingView.getRacingLabMessage();
        return InputRacingInformation.getRacingValue();
    }
}
