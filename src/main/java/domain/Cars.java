package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars(List<Car> input) {
		cars = new ArrayList<>(input);
	}

	public int getCarsSize() {
		return cars.size();
	}

	public void addDistance(int randomNumber, int index) {
		getCar(index).addDistance(randomNumber);
	}

	public Car getCar(int index) {
		return this.cars.get(index);
	}

	public List<Car> getCars() {
		return cars;
	}
}
