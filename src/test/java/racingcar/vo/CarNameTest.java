package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

  @DisplayName("new CarName() 테스트")
  @Test
  public void constructor_test() throws Exception {
    String carName = "name1";
    CarName name = new CarName(carName);
    assertThat(name.get()).isEqualTo(carName);
  }

  @DisplayName("new CarName() 공백이 입력되었을 때 예외 테스트")
  @Test
  public void empty_input_test() throws Exception {
    String carName = "";
    assertThatThrownBy(() -> new CarName(carName))
        .isInstanceOf(RuntimeException.class);
  }

  @DisplayName("new CarName() 글자 수 초과 값이 입력되었을 때 예외 테스트")
  @Test
  public void over_length_input_test() throws Exception {
    String carName = "abcdef";
    assertThatThrownBy(() -> new CarName(carName))
        .isInstanceOf(RuntimeException.class);
  }
}
