package racingcargame;

import racingcargame.game.CarRace;
import racingcargame.model.GameModel;
import racingcargame.view.intput.InputView;

public class Application {
    public static void main(String[] args) {
        CarRace carRace = GameModel.generateCarRace(InputView.askCarNames());
        int round = Integer.parseInt(InputView.askRound());
        carRace.run(round);
    }
}
