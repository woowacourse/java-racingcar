package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePageTest {

    private static final List<Car> testWinners = new ArrayList<>();

    void set() {
        Car car1 = new Car("java");
        Car car2 = new Car("html");
        Car car3 = new Car("c++");
        car2.tryToMoveForward(9);
        car3.tryToMoveForward(9);
        car3.tryToMoveForward(9);
        testWinners.add(car1);
        testWinners.add(car2);
        testWinners.add(car3);
    }

    @Test
    @DisplayName("한라운드 출력 형태가 조건에 맞게 나오는지 테스트")
    void formatSingleRoundInformation() {
        set();
        List<String> test = new ArrayList<>(3);
        for (int i = 0; i < testWinners.size(); i++) {
            test.add(i, GamePage.formatSingleRoundInformation(testWinners.get(i)));
        }
        assertEquals(test.get(0), "java : ");
        assertEquals(test.get(1), "html : -");
        assertEquals(test.get(2), "c++ : --");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "python"})
    @DisplayName("조건에 맞지 않는 데이터 받았을 때 예외 처리 테스트")
    void testWrongData(String wrongName) {
        List<Car> wrongCars = new ArrayList<>();
        wrongCars.add(new Car(wrongName));
        assertThatIllegalArgumentException().isThrownBy(() ->
                ValidateUtils.validateData(wrongCars)).withMessageContaining(ErrorMessages.ERROR_DATA);
    }
}
