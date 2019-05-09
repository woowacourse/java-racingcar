package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    ResultView resultView;
    @BeforeEach
    void setUp() {
        resultView = new ResultView();
    }

    @Test
    void 자동차_위_출력_테스트() {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));

        carList.get(0).setPosition(4);
        carList.get(1).setPosition(2);

        assertThat(resultView.printResult(carList)).isEqualTo("pobi : ----crong : --");
    }

    @AfterEach
    void tearDown() {
        resultView = null;
    }
}
