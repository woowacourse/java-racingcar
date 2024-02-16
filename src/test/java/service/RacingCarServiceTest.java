package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarServiceTest {
    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @DisplayName("Cars 생성 테스트")
    @Test
    void getCarsTest() {
        assertThat(racingCarService.makeCars("가,나,다").getCars()).hasSize(3);
    }

    @DisplayName("반복 횟수 입력 예 처리 테스트")
    @Test
    void getCountNotNumberTest() {
        assertThatThrownBy(() -> racingCarService.getCount("notNumber")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("반복 횟수 입력 예 처리 테스트")
    @ValueSource(strings = {"-1", "0"})
    @ParameterizedTest
    void getCountInvalidNumberTest(String count) {
        assertThatThrownBy(() -> racingCarService.getCount(count)).isInstanceOf(IllegalArgumentException.class);
    }
}