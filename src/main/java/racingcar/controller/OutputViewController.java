package racingcar.controller;

import java.util.ArrayList;
import java.util.HashMap;

import racingcar.model.CarList;

public class OutputViewController {

	public HashMap<String, String> mapCarList(CarList carList) {
		return carList.getCarInfo();
	}

	public ArrayList<String> mapWinner(CarList carList) {
		return carList.getWinner();
	}
}
