package racingcar.domain.car;

public class GasTank {
    private static final int ENOUGH_GAS = 4;

    private int gas;

    GasTank() {
        this.gas = 0;
    }

    void fillUpGas(final int gas) {
        this.gas = gas;
    }

    boolean isEnoughGas() {
        return this.gas >= ENOUGH_GAS;
    }

}
