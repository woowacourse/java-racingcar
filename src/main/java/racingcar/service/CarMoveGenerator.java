package racingcar.service;

public class CarMoveGenerator implements MovePolicy {
	private static final int DRIVE_FLAG = 3;

	@Override
	public boolean hasNext(int number) {
		return DRIVE_FLAG < number;
	}

}
