package racingcar.model;

import racingcar.model.movegenerator.MoveGenerator;
import racingcar.model.movegenerator.RandomMoveGenerator;

public class RacingCar {

	private static final int INITIAL_POSITION_VALUE = 0;

	private final Name name;
	private int position = INITIAL_POSITION_VALUE;
	private final MoveGenerator moveGenerator;

	public RacingCar(final String name, final MoveGenerator moveGenerator) {
		this.name = new Name(name);
		this.moveGenerator = moveGenerator;
	}

	public static RacingCar createRandomMoveCar(final String name) {
		return new RacingCar(name, new RandomMoveGenerator());
	}

	public void decideMove() {
		if (moveGenerator.isMovable()) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position;
	}

	public boolean matchPosition(final RacingCar car) {
		return this.position == car.position;
	}

	public RacingCar findWinner(RacingCar car) {
		if (position > car.position) {
			return this;
		}
		return car;
	}
}
