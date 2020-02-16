package racingcargame.domain;

public interface MoveStrategy {
	boolean isMovable();

	int getMoveNumber();

	int getStopNumber();
}
