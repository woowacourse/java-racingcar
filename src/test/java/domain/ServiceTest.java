package domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTest {
    Service service = new Service();

    @DisplayName("쉼표 기준으로 자동차 이름을 분리한다")
    @Test
    void splitTest() {
        List<String> carName = service.separateCarName("릴리,애쉬,엘라");
        Assertions.assertThat(carName).isEqualTo(List.of("릴리", "애쉬", "엘라"));
    }

