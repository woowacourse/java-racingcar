package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    private ResultView resultView;

    @BeforeEach
    void setUp() {
        resultView = new ResultView();
    }

    @Test
    void 자동차_위치_출력_테스트() {
        Car car = new Car("pobi", 5);
        assertThat(resultView.printHypen(car)).isEqualTo("pobi : -----");
    }

    @AfterEach
    void tearDown() {
        resultView = null;
    }
}
