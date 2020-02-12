package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CarTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/racingtestcase/illegalCarNameTestcase.csv")
    public void Car(String testcase) {
        assertThatThrownBy(() -> {
            new Car(testcase);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
