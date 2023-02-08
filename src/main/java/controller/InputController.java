package controller;

import service.GamePlay;
import view.InputView;
import view.OutputView;

public class InputController {

    public static void startProgram() {
        OutputView.printInputCarNamesNotice();
        GamePlay.gameStart(InputView.inputCarNames());
    }

}
