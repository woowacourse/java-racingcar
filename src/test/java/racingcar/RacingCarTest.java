package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

  @Test
  public void input_car_names_test() throws Exception {
    String input = "name1,name2,name3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    String carNames = RacingCar.readCarNames();
    assertThat(carNames).isEqualTo(input);
  }
}
