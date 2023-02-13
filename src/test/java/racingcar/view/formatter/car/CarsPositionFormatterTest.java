package racingcar.view.formatter.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;
import racingcar.model.car.Cars;

class CarsPositionFormatterTest {
    @DisplayName("여러대의 자동차 위치 출력 형식 테스트")
    @Test
    void formatCarPositionTest() {
        //given
        Cars cars = TestDataManager.getCarsTestData();
        CarPositionFormatter carPositionFormatter = new CarPositionFormatter();
        CarsPositionFormatter carsPositionFormatter = new CarsPositionFormatter(carPositionFormatter);
        String expectedFormat = "pobi : ---\n"
                + "crong : -\n"
                + "eddy : ---\n";

        //when
        cars.moveCars();
        cars.moveCars();
        String actual = carsPositionFormatter.formatCarsPosition(cars);

        //then
        assertThat(actual).isEqualTo(expectedFormat);
    }

}
