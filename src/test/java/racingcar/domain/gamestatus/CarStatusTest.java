package racingcar.domain.gamestatus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarStatusTest {
    @Nested
    class Feature {
        static final String CAR_POSITION_CHARACTER = "-"; 
        @Test
        @DisplayName("차의 상태는 [이름] : [위치]로 구분되며 [위치]는 `-`의 개수로 구분된다.")
        void testshowCarStatus(){
            var givenCarStatus = new CarStatus("포케", 5);
            
            var status = givenCarStatus.showStatus();
            
            assertThat(status).isEqualTo("포케 : -----");
        }
    }
}
