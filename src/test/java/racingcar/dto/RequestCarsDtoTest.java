package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.fcc.Cars;

public class RequestCarsDtoTest {

    @DisplayName("RequestCarsDto 테스트")
    @Test
    public void requestCarsDto_test() throws Exception {
        String input = "name1,name2";
        Cars cars = new Cars(input.split(","));
        RequestCarsDto dto = new RequestCarsDto(cars);

        assertThat(dto).isNotNull();
        assertThat(dto).isOfAnyClassIn(RequestCarsDto.class);
    }

    @DisplayName("getCars 테스트")
    @Test
    public void getCars_test() throws Exception {
        String input = "name1,name2";
        Cars cars = new Cars(input.split(","));
        RequestCarsDto dto = new RequestCarsDto(cars);
        Cars carsByDto = dto.getCars();

        assertThat(cars.toString()).isEqualTo(carsByDto.toString());
    }
}
