package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private static final String[] LONGNAME_SAMPLE = {"pobi", "bada", "whybbb"};
    private static final String LENGTH_MESSAGE = "[ERROR] 이름은 5자 이하로 입력해주세요";
    private static final String SAMPLE_CAR_NAME = "bada";
    private static final int CRITERIA = 4;
    private static final int ONE_PROGRESS_POSITION = 1;

    @Test
    @DisplayName("이름의 글자수 검증 테스트")
    void checkNameLength() {
        List<String> falseList = Arrays.asList(LONGNAME_SAMPLE);
        assertThatThrownBy(() -> {
            new Cars(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_MESSAGE);
    }

    @Test
    void oneTurn() {
        Car advancedCar = new Car(SAMPLE_CAR_NAME);
        advancedCar.oneTurn(CRITERIA);
        assertThat(advancedCar.getPosition()).isEqualTo(ONE_PROGRESS_POSITION);

        Car stayedCar = new Car(SAMPLE_CAR_NAME);
        stayedCar.oneTurn(0);
        assertThat(stayedCar.getPosition()).isEqualTo(0);
    }
}