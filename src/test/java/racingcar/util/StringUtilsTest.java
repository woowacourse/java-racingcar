package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class StringUtilsTest {

    @Test
    @DisplayName("구분자로 문자열 자르기")
    void splitByDelimiter() {
        // given
        String str = "a,b,c,d";
        String delimiter = ",";

        // when
        String[] arr = StringUtils.splitByDelimiter(str, delimiter);

        // then
        assertThat(arr.length).isEqualTo(4);
    }

    @Test
    @DisplayName("배열의 각 요소 strip 처리")
    void stripStringArray() {
        // given
        String[] arr = {"  test  "};
        String expectStr = "test";

        // when
        String[] stripArr = StringUtils.stripStringArray(arr);

        // then
        assertThat(stripArr[0]).isEqualTo(expectStr);
    }

    @Test
    @DisplayName("숫자를 게이지 바로 표시")
    void convertNumberToString() {
        // given
        int cnt = 5;
        String expect = "-----";

        // when

        // then
        assertThat(StringUtils.getGaugeBar(cnt)).isEqualTo(expect);
    }

    @Test
    @DisplayName("자동차 실행 결과")
    void generateCarStatus() {
        // given
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("test1");
        car1.goOrStop(6);

        Car car2 = new Car("test2");
        car2.goOrStop(6);
        car2.goOrStop(6);

        cars.add(car1);
        cars.add(car2);

        // when
        String string = StringUtils.generateCarStatus(cars);

        // then
        assertThat(string).contains("test1 : -", "test2 : --");
    }
}