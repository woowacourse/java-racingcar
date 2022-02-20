package racingcar.model;

import java.util.List;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarList {
	private final List<Car> carList;

	public CarList(String[] names) {
		this.carList = new ArrayList<>();
		for (String eachName : names) {
			this.carList.add(new Car(eachName));
		}
	}

	public List<String> getNameList() {
		List<String> nameList = new ArrayList<>();
		for (Car car : this.carList) {
			nameList.add(car.getName());
		}
		return nameList;
	}

	public void moveCarAt(int index, int number) {
		this.carList.get(index).movePosition(number);
	}

	private int getMaxPosition() {
		return this.carList.stream().mapToInt(Car::getPosition).max().getAsInt();
	}

	public List<String> getWinnerNames() {
		int maxPosition = getMaxPosition();
		return this.carList.stream().filter(car -> car.isPositionAt(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public int getTotalCount() {
		return this.carList.size();
	}

	public List<Integer> getEachCarPosition() {
		List<Integer> eachCarPositionList = new ArrayList<>();
		for (Car car : this.carList) {
			eachCarPositionList.add(car.getPosition());
		}
		return eachCarPositionList;
	}
}
