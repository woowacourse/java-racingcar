package view;

import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    @Test
    void 문자열을받아서_자동차이름리스트_반환() {
        List<Car> resultList = new ArrayList<>();
        resultList.add(new Car("pobi"));
        resultList.add(new Car("crong"));
        resultList.add(new Car("honux"));

        assertThat(InputView.getCarList("pobi,crong,honux")).isEqualTo(resultList);
    }
}
