package model.manager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ThresholdCarMoveManagerTest {

    @ParameterizedTest
    @DisplayName("주어진 값에 따라 움직일수 있는지, 정지해야 하는지를 정상적으로 판단하는지 검사한다.")
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true", "7:true", "8:true",
            "9:true"}, delimiter = ':')
    void boundaryTest(String input, String expected) {
        assertThat(new ThresholdCarMoveManager().isMove(Integer.parseInt(input)))
                .isEqualTo(Boolean.parseBoolean(expected));
    }

}