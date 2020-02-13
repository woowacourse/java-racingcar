package application.racingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private List<Car> cars;
    private Race race;
    private RacingInformationValidator racingInformationValidator;
    private List<String> winners;
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        race = new Race();
        racingInformationValidator = new RacingInformationValidator();
        winners = new ArrayList<>();
        pobi = new Car("pobi");
        lavin = new Car("lavin");
        ramen = new Car("ramen");
        race.checkCarConditionByRandomNumber(pobi,4);
        race.checkCarConditionByRandomNumber(pobi,4);
        race.checkCarConditionByRandomNumber(lavin,4);
        race.checkCarConditionByRandomNumber(lavin,4);
        race.checkCarConditionByRandomNumber(ramen,4);
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @Test
    void splitTest() {
        String input = ",abc";
        String[] expected = {"", "abc"};
        assertThat(input.split(",")).isEqualTo(expected);
    }

    @Test
    void validateInputCarNameTest() {
        String[] inputs = {"", ",asd", "asdfrq,pobi", "pobi,pobi", "pobi,,crong", "pobi, ,crong", "  ,pobi"};
        List<String> carNames = Arrays.asList(inputs);
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.validateCarName(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1", "a,sd,fd"})
    void validateInputRacingLab(String input) {
        Assertions.assertThatThrownBy(() -> {
            RacingInformationValidator.validateRacingLab(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveCarWhenNumberOverFour() {
        Car car = new Car("test");
        Race race = new Race();
        int overFourCase = 4;
        int lessFourCase = 0;
        race.checkCarConditionByRandomNumber(car,overFourCase);
        assertThat(car.getPosition()).isEqualTo(1);
        race.checkCarConditionByRandomNumber(car,lessFourCase);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void generateRandomNumberTest() {
        Race race = new Race();
        int randomNumber = race.generateRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void findWinnerTest() {
        assertThat(race.getNamesOfWinners(cars).size()).isEqualTo(2);
    }

    @Test
    void isWinnerCarTest() {
        assertThat(race.isWinnerCar(2,lavin)).isEqualTo(true);
        assertThat(race.isWinnerCar(2,ramen)).isEqualTo(false);
    }

    @Test
    void isCarPositionOverBeforeMaxPositionTest() {
        assertThat(race.isCarPositionOverBeforeMaxPosition(2,ramen)).isEqualTo(false);
        assertThat(race.isCarPositionOverBeforeMaxPosition(1,lavin)).isEqualTo(true);
    }

    @Test
    void validateRacingLabTest() {
        assertThat(racingInformationValidator.validateRacingLab("1")).isEqualTo(1);
        assertThatThrownBy(() -> {
            racingInformationValidator.validateRacingLab("hello");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkDuplicateCarNameTest() {
        List<String> carNamesCase1 = new ArrayList<>();
        carNamesCase1.add("f");
        carNamesCase1.add("f");
        assertThatThrownBy(() -> {
            racingInformationValidator.checkDuplicateCarName(carNamesCase1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNullOrBlankOrEmptyTest() {
        assertThatThrownBy(() -> {
            racingInformationValidator.checkNullOrBlankOrEmpty("");
        }).isInstanceOf(IllegalArgumentException.class);assertThatThrownBy(() -> {
            racingInformationValidator.checkNullOrBlankOrEmpty(" ");
        }).isInstanceOf(IllegalArgumentException.class);assertThatThrownBy(() -> {
            racingInformationValidator.checkNullOrBlankOrEmpty(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void checkLengthMoreThanFiveTest() {
        assertThatThrownBy(() -> {
            racingInformationValidator.checkLengthMoreThanFive("Exception");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkRacingLabValuetest() {
        assertThat(racingInformationValidator.checkRacingLabValue("1")).isEqualTo(1);
    }

    @Test
    void checkRacingLabValueTest() {
        assertThatThrownBy(() -> {
            racingInformationValidator.checkRacingLabValue("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNegativeNumberTest() {
        assertThatThrownBy(()->{
            racingInformationValidator.checkNegativeNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
