package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {
    @ParameterizedTest
    @CsvSource(value = {"rookie:is2js"}, delimiter = ':')
    @DisplayName("자동차 게임 라운드별 기록을 가져오는 기능")
    public void drive_round_record(String name1, String name2) {
        List<String> carList = new ArrayList<>();
        carList.add(name1);
        carList.add(name2);
        Cars cars = new Cars(carList);

        assertThat(cars.getDriveRecord().size()).isEqualTo(2);
        assertThat(cars.getDriveRecord().get(0).getName()).isEqualTo(name1);
        assertThat(cars.getDriveRecord().get(1).getName()).isEqualTo(name2);
    }
}