package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResponseRoundResultDtoTest {

    @DisplayName("ResponseRoundResultDto 테스트")
    @Test
    public void responseRoundResultDto_test() throws Exception {
        ResponseRoundResultDto dto = new ResponseRoundResultDto(new ArrayList<>());

        assertThat(dto).isNotNull();
        assertThat(dto).isOfAnyClassIn(ResponseRoundResultDto.class);
    }

    @DisplayName("getResults 테스트")
    @Test
    public void getCars_test() throws Exception {
        ResponseRoundResultDto dto = new ResponseRoundResultDto(new ArrayList<>());
        List<RoundResult> results = dto.getResults();

        assertThat(results).hasSize(0);
    }
}
