package racingcar.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.util.StringConst;

public class OutputViewController {

	public LinkedHashMap<String, String> getCarListInfo(ArrayList<Car> carList, String delimiter) {
		LinkedHashMap<String, String> carListInfo = new LinkedHashMap<>();
		for (Car car : carList) {
			carListInfo.put(car.getName(), delimiter.repeat(car.getPosition()));
		}
		return carListInfo;
	}

	public ArrayList<String> mapWinner(ArrayList<Car> carList) {
		GameController gameController = new GameController();
		int maxPosition = gameController.getMaxPosition(carList);
		return (ArrayList<String>)carList.stream().filter(car -> car.isMaxPosition(maxPosition)).map(car -> car.getName()).collect(Collectors.toList());
	}
}
