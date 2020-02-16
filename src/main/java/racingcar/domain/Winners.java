package racingcar.domain;

import java.util.List;

public class Winners {
	private final List<Car> winners;

	public Winners(List<Car> winner) {
		this.winners = winner;
	}

	public boolean contains(String name) {
		return winners.contains(name);
	}

	public List<Car> getWinners() {
		return winners;
	}
}
