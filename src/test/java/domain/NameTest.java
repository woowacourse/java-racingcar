package domain;

import domain.name.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("문자열을 통해 이름을 생성한다")
    public void createName(){

        //Given
        String value = "pond";

        //When
        Name name = new Name(value);

        //Then
        assertInstanceOf(Name.class,name);
    }
    @ParameterizedTest
    @DisplayName("공백 이름은 에러를 발생시킨다")
    @ValueSource(strings = {""," "})
    public void throwExceptionWhenValueIsBlank(String value){
        assertThrows(IllegalArgumentException.class,()->{
            new Name(value);
        });
    }
    @Test
    @DisplayName("다섯 글자 이상의 이름은 에러를 발생시킨다.")
    public void throwExceptionWhenValueIsExceed5(){
        String value = "joyson";

        assertThrows(IllegalArgumentException.class,()-> {
                    new Name(value);
                }
        );
    };
}
