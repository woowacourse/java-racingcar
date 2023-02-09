package view;

import domain.Car;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

  private List<Car> cars;
  private OutputView outputView;

  @BeforeEach
  void init() {
    Car car1 = new Car("car1");
    Car car2 = new Car("car2");
    Car car3 = new Car("car3");
    cars = Arrays.asList(car1, car2, car3);
    outputView = new OutputView();
  }

  @Test
  void 자동차_초기상태_출력() {
    outputView.printCarsStatus(cars);
  }

  @Test
  void 자동차_이동후_출력() {
    int go = 4;
    cars.get(0).move(go);
    cars.get(2).move(go);

    outputView.printCarsStatus(cars);
  }

  @Test
  void 우승자_출력() {
    outputView.printWinners(List.of("호이"));
  }

  @Test
  void 우승자들_출력() {
    outputView.printWinners(List.of("호이", "호호이", "호호호이"));
  }
}