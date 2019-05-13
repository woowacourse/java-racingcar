package racinggame;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Cars implements Iterable<Car> {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public int size() {
		return cars.size();
	}

	public int getMaxPosition() {
		return cars.stream().max(Comparator.comparing(Car::getPosition)).get().getPosition();
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}

	public Stream<Car> stream() {
		return cars.stream();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
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
		Cars other = (Cars) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		return true;
	}
}
