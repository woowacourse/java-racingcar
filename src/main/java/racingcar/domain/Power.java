package racingcar.domain;

public class Power {
    private static final int NUMBER_POSSIBLE_TO_GO = 4;

    public static boolean canMove(int number) {
        return number >= NUMBER_POSSIBLE_TO_GO;
    }
}
