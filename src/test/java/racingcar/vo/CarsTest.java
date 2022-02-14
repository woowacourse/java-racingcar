package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("add() 테스트")
    @Test
    public void add_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        Cars cars = new Cars();
        cars.add(car);
        assertThat(cars.isSize(1)).isTrue();
    }

    @DisplayName("repeatRaceBy() 테스트")
    @Test
    public void repeatRaceBy_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        Cars cars = new Cars();
        cars.add(car);
        Attempt attempt = new Attempt("5");
        String result = cars.repeatRaceBy(attempt);
        Matcher matcher = Pattern.compile(name).matcher(result);
        int nameCount = 0;
        while (matcher.find()) {
            nameCount++;
        }
        assertThat(attempt.isLeft()).isFalse();
        assertThat(result).contains("실행 결과", name);
        assertThat(nameCount).isEqualTo(5);
    }

    @DisplayName("judgeWinners() 단독우승 테스트")
    @Test
    public void judgeWinners_단독우승_test() throws Exception {
        String winnerName = "name1";
        String looserName = "name2";
        CarName winnerCarName = new CarName(winnerName);
        CarName looserCarName = new CarName(looserName);
        Car winnerCar = new Car(winnerCarName);
        Car looserCar = new Car(looserCarName);
        while (!winnerCar.move()) {
        }
        Cars cars = new Cars();
        cars.add(winnerCar);
        cars.add(looserCar);
        Winners winners = cars.judgeWinners();
        assertThat(winners.toString().contains(winnerName)).isTrue();
    }

    @DisplayName("judgeWinners() 공동우승 테스트")
    @Test
    public void judgeWinners_공동우승_test() throws Exception {
        String firstName = "name1";
        String secondName = "name2";
        CarName firstCarName = new CarName(firstName);
        CarName secondCarName = new CarName(secondName);
        Car firstCar = new Car(firstCarName);
        Car secondCar = new Car(secondCarName);
        Cars cars = new Cars();
        cars.add(firstCar);
        cars.add(secondCar);
        Winners winners = cars.judgeWinners();
        assertThat(winners.toString().contains(firstName)).isTrue();
        assertThat(winners.toString().contains(secondName)).isTrue();
    }

    @DisplayName("add() 중복된 이름이 입력되었을 때 예외 테스트")
    @Test
    public void add_같은_이름이_있는_경우_예외_test() throws Exception {
        String name = "name1";
        CarName firstCarName = new CarName(name);
        CarName secondCarName = new CarName(name);
        Car firstCar = new Car(firstCarName);
        Car secondCar = new Car(secondCarName);
        Cars cars = new Cars();
        cars.add(firstCar);
        assertThatThrownBy(() -> cars.add(secondCar))
                .isInstanceOf(RuntimeException.class);
    }
}
