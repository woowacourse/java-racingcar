package controller;

import racinggame.RacingGame;
import view.InputView;
import view.OutputView;

public class MainController {
	private static final int MIN_ROUND = 1;
	
	public static void main(String[] args) {
		RacingGame racingGame = getRacingGame();
		int totalRound = getTotalRound();
		
		OutputView.printStartMessage();
		
		for(int i = 0; i < totalRound; i++) {
			racingGame.playOneRound();
			OutputView.printCars(racingGame.getCars());
		}
		
        OutputView.printFinalWinner(racingGame.getWinners());	     
	}
	
	public static RacingGame getRacingGame() {
		try {
			String[] carNames = InputView.inputCarNames().replaceAll(" ", "").split(",");			
			return new RacingGame(carNames);
		} catch(IllegalArgumentException e) {
			OutputView.printIllegalArgumentMessage(e.getMessage());
			return getRacingGame();
		}
	}
	
	public static int getTotalRound() {
		try {
			int totalRound = InputView.inputTotalRound();
			
			if(totalRound < MIN_ROUND) {
				OutputView.printIllegalRound();
				return getTotalRound();
			}
			
			return totalRound;
		} catch(NumberFormatException e) {
			OutputView.printIllegalNumber();
			return getTotalRound();
		}
	}
}
