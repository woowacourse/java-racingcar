package contoller;

import domain.Car;
import java.util.InputMismatchException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import util.RandomUtil;
import view.InputView;
import view.OutputView;

public class RaceController {

  private InputView inputView = new InputView();
  private OutputView outputView = new OutputView();

  private <T> T repeat(Supplier<T> inputReader){
    try {
      return inputReader.get();
    } catch (Exception e){
      outputView.printErrorMessage(e);
      return repeat(inputReader);
    }
  }

  public void run() {
//    List<String> carNames =inputView.readCarNames();
//    int roundNum = inputView.readRoundNum();
    List<String> carNames = repeat(inputView::readCarNames);
    int roundNum = repeat(inputView::readRoundNum);

    List<Car> cars = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());

    outputView.printStart(cars);

    for (int i = 0; i < roundNum; i++) {
      for (Car car : cars) {
        car.move(RandomUtil.getZeroToNine());
      }
      outputView.printCarsStatus(cars);
    }

    int maxPosition = cars.stream().max(Car::compareTo).orElseThrow().getPosition();
    List<String> winnerNames = cars.stream().sorted()
        .filter(c -> c.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
    outputView.printWinners(winnerNames);
  }
}
