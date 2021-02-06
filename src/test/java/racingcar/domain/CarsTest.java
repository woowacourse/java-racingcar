package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.InputUtils;
import racingcar.validator.NameValidator;

class CarsTest {

    private Cars cars;

    @DisplayName("Exception test for over duplicated name")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi, pobi"})
    void checkDuplicatedExceptionTest(String nameString) {
        assertThatThrownBy(() -> {
            String[] names = InputUtils.splitNames(nameString);
            NameValidator.isDuplicatedNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

//    @DisplayName("특정 자동차가 우승을 하는 상황을 만들어놓고 그 우승자가 정상적으로 나오는지 확인")
//    @ParameterizedTest
//    @ValueSource(strings = {"pobi, pobi, pobi"})
//    void checkWinner() {
//        setUp();
//    }
//
//    public void setUp() {
//        Car car1 = Car.createByName("jino");
//        car1.movePosition();
//        car1.movePosition();
//        Car car2 = Car.createByName("cogi");
//        car2.movePosition();
//        car2.movePosition();
//        car2.movePosition();
//
//        List<Car> carList = new ArrayList<>();
//
//        carList.add(car1);
//        carList.add(car2);
//
//         cars = Cars.createByNames()
//    }
}
