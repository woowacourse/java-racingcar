package racingcar.dummy;

import java.util.List;

import racingcar.domain.car.CarMovement;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Position;
import racingcar.domain.number.NumberGenerator;

public class TestDataDummy {
	public static final NumberGenerator MOVE_STOP_NUMBER_GENERATOR = () -> 0;
	public static final NumberGenerator MOVE_FORWARD_NUMBER_GENERATOR = () -> 4;
	public static final Position MOVE_ZERO_POSITION = new Position(0);
	public static final Position MOVE_FORWARD_ONCE_POSITION = new Position(1);
	public static final CarMovement CAR_MOVEMENT_STOP = new CarMovement(MOVE_STOP_NUMBER_GENERATOR);
	public static final CarMovement CAR_MOVEMENT_FORWARD = new CarMovement(MOVE_FORWARD_NUMBER_GENERATOR);
	public static final CarName CAR_NAME = new CarName("헤나");
	public static final List<String> CAR_NAMES = List.of("헤나", "소니");
	public static final int TOTAL_ROUND = 4;
}
