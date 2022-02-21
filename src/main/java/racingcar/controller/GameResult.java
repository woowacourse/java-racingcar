package racingcar.controller;

import java.util.List;

import racingcar.model.CarDto;

public class GameResult {
	private final List<CarDto> gameResult;

	public GameResult(List<CarDto> carDtos) {
		this.gameResult = carDtos;
	}

	public List<CarDto> getGameResult() {
		return gameResult;
	}
}
