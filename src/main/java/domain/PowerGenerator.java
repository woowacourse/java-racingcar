package domain;

public class PowerGenerator {

    private static final Integer MIN = 0;
    private static final Integer MAX = 9;

    public Integer makeRandomNumber() {
        return (int) (Math.random() * (MAX - MIN + 1) + MIN);
    }
}
