package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("name 객체 생성 확인")
    void createName() {
        Name name = new Name("amazi");
        assertThat(name).isEqualTo(new Name("amazi"));
    }

    @Test
    @DisplayName("자동차의 이름을 null 또는 빈문자로 주었을 경우")
    void createNullName() {
        String carName = "";
        assertThatThrownBy(() -> {
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 한글 혹은 영어로 이루어지지 않은 경우")
    void createNotKoreanAndEnglish() {
        String carName = "ㅏㅁ*7";
        assertThatThrownBy(() -> {
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5 초과인 경우")
    void createNameExceedLimitLength() {
        String carName = "pobbbbbbi";
        assertThatThrownBy(() -> {
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void creatName() {
        String carName = "ㅏㅁ*7";
        assertThatThrownBy(() -> {
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
