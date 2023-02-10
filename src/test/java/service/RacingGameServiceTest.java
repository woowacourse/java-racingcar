package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.constants.ErrorMessages;
import utils.exception.AlreadyDefinedFieldException;

class RacingGameServiceTest {
    RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
    }

    @Test
    @DisplayName("중복된 이름이 입력되면 예외발생")
    void setCarsFailTest() {
        assertThatThrownBy(() -> racingGameService.setCars(List.of("fox", "fox")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATED_NAME.getMessage());
    }
}