package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.track.Track;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        RacingController racingController = new RacingController(inputView, outputView);
        Track track = racingController.init();

        racingController.startRace(track);
        racingController.concludeWinner(track);
    }
}
