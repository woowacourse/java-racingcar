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

	public HashMap<String, String> getCarInfo() {
		HashMap<String, String> carInfo = new HashMap<>();
		for (Car car : this.carList) {
			carInfo.put(car.getName(), StringConst.POSITION_DELEIMIER.getValue().repeat(car.getPosition()));
		}
		return carInfo;
	}

	public ArrayList<String> getWinner() {
		List<String> winnerNames = this.carList.stream()
			.filter(car -> car.isMaxPosition(getMaxPosition()))
			.map(Car::getName)
			.collect(Collectors.toList());
		ArrayList<String> winners = new ArrayList<>();
		for (String names : winnerNames) {
			winners.add(names);
		}
		return winners;
	}
}
