package racingcar.model;

import racingcar.model.movegenerator.MoveGenerator;
import racingcar.model.movegenerator.RandomMoveGenerator;

public class RacingCar {

	private static final int MOVE_CRITERIA = 4;
	private static final int INITIAL_POSITION_VALUE = 0;

	private final Name name;
	private int position = INITIAL_POSITION_VALUE;
	private final MoveGenerator moveGenerator;

	public RacingCar(String name, MoveGenerator moveGenerator) {
		this.name = new Name(name);
		this.moveGenerator = moveGenerator;
	}

	public static RacingCar createRandomMoveCar(String name) {
		return new RacingCar(name, new RandomMoveGenerator());
	}

	public void decideMove() {
		if (moveGenerator.generate() >= MOVE_CRITERIA) {
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

	public boolean matchPosition(int position) {
		return this.position == position;
	}
}
