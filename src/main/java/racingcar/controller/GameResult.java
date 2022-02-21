package racingcar.controller;

import java.util.List;

import racingcar.model.CarDto;

public class GameResult {
	private final List<CarDto> gameResult;

	public GameResult(List<CarDto> gameResult) {
		this.gameResult = gameResult;
	}

	public List<CarDto> getGameResult() {
		return gameResult;
	}
}
