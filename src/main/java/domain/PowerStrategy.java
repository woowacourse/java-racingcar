package domain;

public class PowerStrategy {

    private final PowerManager powerManager;

    private PowerStrategy() {
        this.powerManager = new PowerManager();
    }

    public static PowerStrategy from() {
        return new PowerStrategy();
    }

    public boolean checkPowerRange() {
        Integer randomNumber = powerManager.generatePower();
        return powerManager.isSufficientPower(randomNumber);
    }
}