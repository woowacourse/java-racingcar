package racingcar;

import racingcar.Controller.Game;
import racingcar.View.OutputView;

/**
 * 클래스 이름 : Main.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class Main {
	public static void main(String[] args) {
		try {
			Game game = new Game();
			game.race();
			game.showWinner();
		} catch (Exception e) {
			OutputView.printExceptionMessage(e.getMessage());
		}
	}
}
