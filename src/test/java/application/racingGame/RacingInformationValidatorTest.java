package application.racingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class RacingInformationValidatorTest {
    private List<Car> cars;
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        pobi = new Car("pobi",0);
        lavin = new Car("lavin",0);
        ramen = new Car("ramen",0);
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1", "a,sd,fd"})
    void validateRacingLab_시도_횟수값이_잘못입력될경우_익셉션을_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.checkRacingLab(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkDuplicateCarName_중복된_이름일경우_익셉션을_발생한다() {
        String input = "a,a";
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.checkCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNullOrBlankOrEmpty_null_일경우_익셉션을_발생한다() {
        String input = null;
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.checkCarNames(input);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void checkNullOrBlankOrEmpty_Blank_일경우_익셉션을_발생한다() {
        String input = " ";
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.checkCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNullOrBlankOrEmpty_Empty_일경우_익셉션을_발생한다() {
        String input = "";
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.checkCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkLengthMoreThanFive_길이가_5를_초과할경우_익셉션을_발생한다() {
        String input = "moreThanFive";
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.checkCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
