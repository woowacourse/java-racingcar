package domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StatusTest {

    @Test
    void INIT_메서드로_초기화() {
        Status status = Status.INIT();
        assertThat(status.getMoveCount()).isEqualTo(0);
    }

    @Test
    void NEXT_메서드로_증가된_Status_값객체_생성() {
        Status status = Status.INIT();
        Status movedStatus = status.next();
        assertThat(movedStatus.getMoveCount()).isEqualTo(1);
        assertThat(movedStatus).isNotEqualTo(status);
    }
}
