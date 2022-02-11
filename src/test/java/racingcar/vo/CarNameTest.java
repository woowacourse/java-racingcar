package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {

  @Test
  public void 생성자_test() throws Exception {
    String carName = "name1";
    CarName name = new CarName(carName);
    assertThat(name.get()).isEqualTo(carName);
  }

  @Test
  public void 생성자_공백_test() throws Exception {
    String carName = "";
    assertThatThrownBy(() -> new CarName(carName))
        .isInstanceOf(RuntimeException.class);
  }
}
