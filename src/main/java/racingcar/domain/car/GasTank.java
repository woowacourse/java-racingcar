package racingcar.domain.car;

public class GasTank {

    private static final int ENOUGH_GAS = 4;
    private static final int INIT_GAS = 0;

    private final int gas;

    public GasTank() {
        this(INIT_GAS);
    }

    public GasTank(final int gas) {
        this.gas = gas;
    }

    public GasTank fillUp(final int gas) {
        return new GasTank(gas);
    }

    public boolean isEnough() {
        return this.gas >= ENOUGH_GAS;
    }
}
