package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

  @Test
  public void run_중간_공백_test() throws Exception {
    String[] input = {"name1,,name3", "5"};
    byte[] buf = String.join("\n", input).getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    RacingCar racingCar = new RacingCar();
    assertThatThrownBy(() -> racingCar.run())
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void splitCarNames_처음_공백_test() throws Exception {
    String[] input = {",name1", "5"};
    byte[] buf = String.join("\n", input).getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    RacingCar racingCar = new RacingCar();
    assertThatThrownBy(() -> racingCar.run())
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void splitCarNames_마지막_공백_test() throws Exception {
    String[] input = {"name1,name2,", "5"};
    byte[] buf = String.join("\n", input).getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    RacingCar racingCar = new RacingCar();
    assertThatThrownBy(() -> racingCar.run())
        .isInstanceOf(RuntimeException.class);
  }
}
