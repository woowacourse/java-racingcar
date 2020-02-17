import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Car;

public class CarTest {
    Car car;
    Car pobiCar;
    Car crongCar;
    Car honuxCar;

    @BeforeEach
    void initCar() {
        car = new Car("moveTest");
        pobiCar = new Car("pobi");
        crongCar = new Car("crong");
        honuxCar = new Car("honux");

        pobiCar.move(4);

        crongCar.move(7);
        crongCar.move(7);

        honuxCar.move(1);
        honuxCar.move(2);
        honuxCar.move(3);
        honuxCar.move(4);
        honuxCar.move(5);
        honuxCar.move(6);
        honuxCar.move(7);

    }

    @ParameterizedTest
    @CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
    void moveTest(int random, boolean expected) {
        boolean actual = car.move(random);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true,false,false", "2,false,true,false", "4,false," +
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
