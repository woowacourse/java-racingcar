import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Car;
import racinggame.domain.MoveGenerator;
import racinggame.domain.StopGenerator;

public class CarTest {
    Car car;
    Car pobiCar;
    Car crongCar;
    Car honuxCar;

    @BeforeEach
    void initCar() {
        car = new Car("moveTest");
        pobiCar = new Car("pobi", 4);
        crongCar = new Car("crong", 3);
        honuxCar = new Car("honux", 7);
    }

    @Test
    void 이동_테스트(){
        Assertions.assertThat(car.move(new MoveGenerator())).isTrue();
    }

    @Test
    void 정지_테스트(){
        Assertions.assertThat(car.move(new StopGenerator())).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"4,true,false,false", "3,false,true,false", "7,false," +
            "false,true"})
    void samePositionTest(int random, boolean expected1, boolean expected2,
                          boolean expected3) {
        boolean actual1 = pobiCar.isSamePosition(random);
        boolean actual2 = crongCar.isSamePosition(random);
        boolean actual3 = honuxCar.isSamePosition(random);

        Assertions.assertThat(actual1).isEqualTo(expected1);
        Assertions.assertThat(actual2).isEqualTo(expected2);
        Assertions.assertThat(actual3).isEqualTo(expected3);
    }
}
