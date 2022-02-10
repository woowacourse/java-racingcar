package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;

import racingcar.util.StringConst;

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

	public int getSize() {
		return this.carList.size();
	}

	public void moveCars(ArrayList<Integer> numbers) {
		for (int index = 0; index < numbers.size(); index++) {
			this.carList.get(index).movePosition(numbers.get(index));
		}
	}
}
