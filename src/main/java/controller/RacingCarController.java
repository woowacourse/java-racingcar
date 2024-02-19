
package controller;

import java.io.IOException;
import java.util.List;
import model.Car;
import model.Cars;
import model.Game;
import model.TrialCount;
import view.InputView;
import view.OutputView;

public class RacingCarController {
  private final OutputView outputView;
  private final InputView inputView;

  public RacingCarController(InputView inputView, OutputView outputView) {
    this.outputView = outputView;
    this.inputView = inputView;
  }

  public void run() throws IOException {
    Game game =
            new Game(
                    new Cars(convertToCar(inputView.inputCarsName())),
                    new TrialCount(inputView.inputTrialCount()));
    outputView.printResultComment();
    while (!game.over()) {
      outputView.printResult(game.play());
    }
    outputView.printWinner(game.winners());
  }

  private List<Car> convertToCar(List<String> carNames) {
    return carNames.stream().map(Car::new).toList();
  }
}

