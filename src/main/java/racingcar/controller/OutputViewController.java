package racingcar.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import racingcar.model.CarList;

public class OutputViewController {

	public LinkedHashMap<String, String> mapCarList(CarList carList) {
		return carList.getCarInfo();
	}

	public ArrayList<String> mapWinner(CarList carList) {
		return carList.getWinner();
	}
}
