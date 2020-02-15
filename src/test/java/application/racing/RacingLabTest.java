package application.racing;

import application.racing.domain.RacingLab;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingLabTest {
    @DisplayName("RacingLab 클래스 생성자 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "ajsd;lfk", "8946846534164684684165841684687687684168468468546846541687465"})
    public void racingLabConstructorTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new RacingLab(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
