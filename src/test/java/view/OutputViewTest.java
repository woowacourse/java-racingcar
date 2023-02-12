package view;

import domain.Car;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

  private List<Car> cars;
  private OutputView outputView;
  private OutputStream out;

  @BeforeEach
  void init() {
    Car car1 = new Car("car1");
    Car car2 = new Car("car2");
    Car car3 = new Car("car3");
    cars = Arrays.asList(car1, car2, car3);
    outputView = new OutputView();
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  @Test
  void 에러_메세지_출력() {
    String errMsg = "에러메세지입니다.";
    outputView.printErrorMessage(new Exception(errMsg));

    Assertions.assertThat(out.toString()).isEqualTo(errMsg + "\r\n");
  }

  @Test
  void 자동차_초기상태_출력() {
    String result =
        "car1 : -\n"
            + "car2 : -\n"
            + "car3 : -\n"
            + "\r\n";
    outputView.printCarsStatus(cars);

    Assertions.assertThat(out.toString()).isEqualTo(result);
  }

  @Test
  void 자동차_이동후_출력() {
    String result =
        "car1 : --\n"
            + "car2 : -\n"
            + "car3 : --\n"
            + "\r\n";

    int go = 4;
    cars.get(0).move(go);
    cars.get(2).move(go);

    outputView.printCarsStatus(cars);
    Assertions.assertThat(out.toString()).isEqualTo(result);
  }

  @Test
  void 우승자_출력() {
    String result = "호이가 최종 우승했습니다.";
    outputView.printWinners(List.of("호이"));
    Assertions.assertThat(out.toString()).isEqualTo(result);
  }

  @Test
  void 우승자들_출력() {
    String result = "호이, 호호이, 호호호이가 최종 우승했습니다.";
    outputView.printWinners(List.of("호이", "호호이", "호호호이"));
    Assertions.assertThat(out.toString()).isEqualTo(result);
  }
}
