package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

  @Test
  public void input_car_names_test() throws Exception {
    String input = "name1,name2,name3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    RacingCar racingCar = new RacingCar(new Scanner(System.in));
    String carNames = racingCar.readCarNames();
    assertThat(carNames).isEqualTo(input);
  }

  @Test
  public void splitCarNames_test() throws Exception {
    String input = "name1,name2,name3";
    RacingCar racingCar = new RacingCar(new Scanner(System.in));
    String[] carNames = racingCar.splitCarNames(input);
    assertThat(carNames).contains("name1", "name2", "name3");
  }
}
