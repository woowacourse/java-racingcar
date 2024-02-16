package domain;

public class PowerStrategy {

    private static final Integer THRESHOLD = 4;

    private final PowerGenerator powerGenerator;

    private PowerStrategy() {
        this.powerGenerator = new PowerGenerator();
    }

    public static PowerStrategy from() {
        return new PowerStrategy();
    }

    public boolean canMove() {
        Integer randomNumber = powerGenerator.makeRandomNumber();
        return THRESHOLD <= randomNumber;
    }
}