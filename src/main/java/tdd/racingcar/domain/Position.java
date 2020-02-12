package tdd.racingcar.domain;

public class Position {
	private int position;

	public Position(final int position) {
		checkValidationOf(position);
		this.position = position;
	}

	private void checkValidationOf(final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("자동차의 위치는 0 이상이어야 합니다.");
		}
	}
}
