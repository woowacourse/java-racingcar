package racingCar.view;

public class RacingCarPositionTranslator {

    static String translate(int position) {
        String positionTranslated = "";
        for (int i = 0; i < position; i++) {
            positionTranslated += "-";
        }

        return positionTranslated;
    }
}
