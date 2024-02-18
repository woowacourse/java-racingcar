package domain;

public class RandomPowerGenerator {

    private static final Integer MIN = 0;
    private static final Integer MAX = 9;

    public Power generate() {
        Integer randomNumber = makeRandomNumber();
        return Power.from(randomNumber);
    }

    public Integer makeRandomNumber() {
        return (int) (Math.random() * (MAX - MIN + 1) + MIN);
    }
}
