package racinggame;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Winners implements Iterable<Car> {
	private final List<Car> winners;

	public Winners(Cars cars) {
		int maxPosition = cars.getMaxPosition();
		
		winners = cars
				.stream()
				.filter(car -> car.matchPosition(maxPosition))
				.collect(Collectors.toList());
	}

	public Stream<Car> stream() {
		return winners.stream();
	}

	@Override
	public Iterator<Car> iterator() {
		return winners.iterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((winners == null) ? 0 : winners.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Winners other = (Winners) obj;
		if (winners == null) {
			if (other.winners != null)
				return false;
		} else if (!winners.equals(other.winners))
			return false;
		return true;
	}
}
