package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class GameTest {

    @Test
    @DisplayName("자동차들이 중복된 이름을 가질 시 예외가 발생한다.")
    void validateDuplicate(){
        assertThatThrownBy(() -> new Game(List.of("포비", "포비"))).isInstanceOf(IllegalArgumentException.class);
    }

}