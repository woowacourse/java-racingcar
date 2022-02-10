package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class CarsTest {

  @Test
  public void add_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    Cars cars = new Cars();
    cars.add(car);
    assertThat(cars.isSize(1)).isTrue();
  }

  @Test
  public void repeatRace_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    Cars cars = new Cars();
    cars.add(car);
    Attempt attempt = new Attempt("5");
    String result = cars.repeatRace(attempt);
    Matcher matcher = Pattern.compile(name).matcher(result);
    int nameCount = 0;
    while (matcher.find()) {
      nameCount++;
    }
    assertThat(attempt.isLeft()).isFalse();
    assertThat(result).contains("실행 결과", name);
    assertThat(nameCount).isEqualTo(5);
  }
}
