package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.numbergenerator.MovableNumberGenerator;
import racingcar.domain.numbergenerator.NonMovableNumberGenerator;
import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";
    private static final String EMPTY_NAME_ERROR = "[ERROR] 이름은 공백일 수 없습니다.";

    @Test
    public void 이름_4글자_일때_차_생성() {
        String name = "four";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    public void 이름_5글자_일때_차_생성() {
        String name = "forky";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    public void 이름_6글자_일때_차_생성() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_LENGTH_ERROR);
    }

    @Test
    public void 차_1대_생성() {
        List<Car> cars = CarFactory.from("kun");
        assertThat(cars.size()).isEqualTo(1);
    }

    @Test
    public void 차_여러대_생성() {
        String names = "forky,kun";
        List<Car> cars = CarFactory.from(names);
        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    public void 공백_이름() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_ERROR);
    }

    @Test
    public void 랜덤값이_3일때_차_전진_못하고_position_유지() {
        Car car = new Car("kun");
        NumberGenerator numberGenerator = new NonMovableNumberGenerator();

        car.move(numberGenerator);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 랜덤값이_4일때_차_전진_position_1증가() {
        Car car = new Car("kun");
        NumberGenerator numberGenerator = new MovableNumberGenerator();

        car.move(numberGenerator);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
