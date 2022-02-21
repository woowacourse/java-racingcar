package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.Attempt;

public class RequestAttemptDtoTest {

    @DisplayName("RequestAttemptDto 테스트")
    @Test
    public void requestAttemptDto_test() throws Exception {
        String input = "5";
        Attempt attempt = new Attempt(input);
        RequestAttemptDto dto = new RequestAttemptDto(attempt);

        assertThat(dto).isNotNull();
        assertThat(dto).isOfAnyClassIn(RequestAttemptDto.class);
    }

    @DisplayName("getAttempt() 테스트")
    @Test
    public void getAttempt_test() throws Exception {
        String input = "5";
        Attempt attempt = new Attempt(input);
        RequestAttemptDto dto = new RequestAttemptDto(attempt);
        Attempt dtoByAttempt = dto.getAttempt();

        assertThat(attempt.toString()).isEqualTo(dtoByAttempt.toString());
    }
}
