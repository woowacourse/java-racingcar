package service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import testNumberGenerator.TestNumberGenerator;
import utils.constants.ErrorMessages;
import utils.numberGenerator.NumberGenerator;

class RacingGameServiceTest {
    RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(3, 5));
        racingGameService = new RacingGameService(numberGenerator);
    }

    @Test
    @DisplayName("중복된 이름이 입력되면 예외발생")
    void setCarsFailTest() {
        assertThatThrownBy(() -> racingGameService.createCars(List.of("fox", "fox")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATED_NAME.getMessage());
    }
}