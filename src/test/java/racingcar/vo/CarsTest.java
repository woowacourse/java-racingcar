package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

public class CarsTest {

  @DisplayName("생성자 테스트")
  @Test
  public void 생성자_test() throws Exception {
    String[] name = {"name1"};
    Cars cars = new Cars(name);
    assertThat(cars.isSize(1)).isTrue();
  }

  @DisplayName("repeatRaceBy() 테스트")
  @Test
  public void repeatRaceBy_test() throws Exception {
    OutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
    String[] name = {"name1"};
    Cars cars = new Cars(name);
    Attempt attempt = new Attempt("5");
    RoundResults result = cars.repeatRaceBy(attempt);
    OutputView.printRaceResult(result);
    String out = output.toString();
    assertThat(attempt.isLeft()).isFalse();
    assertThat(out).contains("실행 결과", name[0]);
  }

  @DisplayName("생성자 중복된 이름이 입력되었을 때 예외 테스트")
  @Test
  public void 생성자_같은_이름이_있는_경우_예외_test() throws Exception {
    String[] name = {"name1", "name1"};
    assertThatThrownBy(() -> new Cars(name))
        .isInstanceOf(RuntimeException.class);
  }
}
