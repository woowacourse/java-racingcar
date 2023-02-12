package racingcar.mock;

import racingcar.domain.car.Cars;

import java.util.List;

public class MoveMethodCalledCountStoreCars extends Cars {

    private int count = 0;

    public MoveMethodCalledCountStoreCars(List<String> cars) {
        super(cars);
    }

    @Override
    public void move(int... numbers) {
        count++;
        super.move(numbers);
    }

    public int getCallCount() {
        return count;
    }
}