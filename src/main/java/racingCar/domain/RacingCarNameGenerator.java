package racingCar.domain;

public class RacingCarNameGenerator {
    public static String[] generate(String namesWithComma) {
        return namesWithComma.split(",");
    }
}
