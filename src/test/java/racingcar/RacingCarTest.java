package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

  @DisplayName("play() 입력 값에 중간에 공백이 있는 경우 예외 테스트")
  @Test
  public void play_middle_empty_input_exception_test() throws Exception {
    String[] input = {"name1,,name3", "5"};
    byte[] buf = String.join("\n", input).getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    RacingCar racingCar = new RacingCar();
    assertThatThrownBy(() -> racingCar.play())
        .isInstanceOf(RuntimeException.class);
  }

  @DisplayName("play() 입력 값에 처음에 공백이 있는 경우 예외 테스트")
  @Test
  public void play_first_empty_input_exception_test() throws Exception {
    String[] input = {",name1", "5"};
    byte[] buf = String.join("\n", input).getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    RacingCar racingCar = new RacingCar();
    assertThatThrownBy(() -> racingCar.play())
        .isInstanceOf(RuntimeException.class);
  }

  @DisplayName("play() 입력 값에 마지막에 공백이 있는 경우 예외 테스트")
  @Test
  public void play_last_empty_input_exception_test() throws Exception {
    String[] input = {"name1,name2,", "5"};
    byte[] buf = String.join("\n", input).getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    RacingCar racingCar = new RacingCar();
    assertThatThrownBy(() -> racingCar.play())
        .isInstanceOf(RuntimeException.class);
  }
}
