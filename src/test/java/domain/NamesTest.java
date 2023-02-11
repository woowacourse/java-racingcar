package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력받은 이름들은 ")
class NamesTest {

    @Test
    @DisplayName("0명이면 익셉션이 발생한다.")
    void throwExceptionWhenNoNameInput(){
        assertThatThrownBy(()->new Names(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1명이상이 참여하면 익셉션이 발생하지 않는다.")
    void notThrowExceptionWhenOneMoreName(){
        assertDoesNotThrow(()->new Names(new ArrayList<>(List.of(
                "pobi", "honux", "bkcat"
        ))));
    }
}
