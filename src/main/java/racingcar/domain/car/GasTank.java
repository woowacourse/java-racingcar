package racingcar.domain.car;

public class GasTank {
    private static final int ENOUGH_GAS = 4;

    private int gas;

    public GasTank() {
        this.gas = 0;
    }

    public void fillUpGas(final int gas) {
        this.gas = gas;
    }

    public boolean isEnoughGas() {
        return this.gas >= ENOUGH_GAS;
    }

}
