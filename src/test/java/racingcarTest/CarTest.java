package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car = new Car("보스독");

    @ParameterizedTest
    @DisplayName("goOrNot 테스트")
    @CsvSource(value = {
            "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"
    })
    void goOrNot_랜덤숫자가_4이상일때만_true_반환(int randomNumber, Boolean result) {
        assertThat(car.goOrNot(randomNumber)).isEqualTo(result);
    }
}
