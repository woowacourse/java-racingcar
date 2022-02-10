package racingcar.model;

import java.util.ArrayList;

public class CarList {
	private ArrayList<Car> carList;

	public CarList(String[] nameList) {
		for (String name : nameList) {
			this.carList.add(new Car(name));
		}
	}

	public int getMaxPosition() {
		int maxPos = 0;
		for (Car car : this.carList) {
			maxPos = Math.max(maxPos, car.getPosition());
		}
		return maxPos;
	}
}
