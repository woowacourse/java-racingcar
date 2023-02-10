package racingcar.domain.wrapper;

import static racingcar.domain.constant.CarConstant.INIT_POSITION;

public class CarPosition {

    private int position;

    private CarPosition(final int position) {
        this.position = position;
    }

    public static CarPosition of() {
        return new CarPosition(INIT_POSITION.getValue());
    }

    public int getPosition() {
        return position;
    }

    public void addPosition() {
        position++;
    }
}
