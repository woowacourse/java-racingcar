package racingcar.domain.numbergenerator;

public class UserNumberGenerator implements NumberGenerator{
    private static final int FORWARD_NUMBER = 9;

    @Override
    public int generateNumber() {
        return FORWARD_NUMBER;
    }
}
