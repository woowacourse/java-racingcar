package service;

import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;
import vo.Name;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ServiceTest {
    Service service;

    @BeforeEach
    void setUp() {
        service = new Service(new Cars(new ArrayList<>(), new RandomNumberGenerator()));
    }

    @Test
    @DisplayName("중복된 이름이 입력되면 예외발생")
    void givenDuplicatingNames_whenInitializingCars_thenThrowsException() {
        assertThatThrownBy(
                () -> service.initializeCars(Name.of(List.of("fox", "fox")))
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Service.DUPLICATING_NAME_EXCEPTION_MESSAGE);
    }
}