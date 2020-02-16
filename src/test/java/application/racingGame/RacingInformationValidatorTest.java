package application.racingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class RacingInformationValidatorTest {

    private List<Car> cars;
    private Race race;
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        race = new Race();
        pobi = new Car("pobi");
        lavin = new Car("lavin");
        ramen = new Car("ramen");
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1", "a,sd,fd"})
    void validateRacingLab_시도_횟수값이_잘못입력될경우_익셉션을_발생한(String input) {
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.validateRacingLab(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
