package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {
	private final List<String> winners;

	public Winners(List<String> winnersWithNull) {
		this.winners = winnersWithNull.stream().filter(Objects::nonNull).collect(Collectors.toList());
	}

	public boolean contains(String name) {
		return winners.contains(name);
	}

	@Override
	public String toString() {
		return String.join(", ", winners);
	}
}
