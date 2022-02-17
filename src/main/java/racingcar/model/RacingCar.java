package racingcar.model;

import static racingcar.utlis.RandomNumberGenerator.*;

public class RacingCar extends Car {

	private static final int MOVE = 4;
	private static final int STOP = 3;
	private static final String JUDY = "judy";
	private static final String POBI = "pobi";

	public RacingCar(String name, int position) {
		super(name, position);
	}

	@Override
	public void decideMove(int number) {
		switch (super.getName().getName()) {
			case JUDY:
				super.decideMove(MOVE);
				break;
			case POBI:
				super.decideMove(STOP);
				break;
			default:
				super.decideMove(getRandomInt());
		}
	}

}
