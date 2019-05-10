package view;

import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    @Test
    void 문자열을받아서자동차이름리스트() {
        List<Car> resultList = new ArrayList<>();
        resultList.add(new Car("pobi"));
        resultList.add(new Car("crong"));
        resultList.add(new Car("honux"));

        assertThat(InputView.getCarList("pobi,crong,honux")).isEqualTo(resultList);
    }
}
