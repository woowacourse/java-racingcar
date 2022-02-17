package racingcar.model;

public interface CarMoveCondition {

	default Boolean satisfy(int number) {
		return number >= 4;
	}

}
