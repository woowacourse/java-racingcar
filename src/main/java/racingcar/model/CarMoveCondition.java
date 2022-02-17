package racingcar.model;

public interface CarMoveCondition {

	int CRITERIA = 4;

	default Boolean satisfy(int number) {
		return number >= CRITERIA;
	}

}

