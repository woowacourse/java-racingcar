package racingcar.domain;

import java.util.Collection;

public interface Cars {
	Collection<Car> getCars();

	Collection<Car> getCarsInPosition(int position);

	int getMaxPosition();
}
