import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import string.StringCalcurator;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    StringCalcurator stringCalcurator = new StringCalcurator();

    @Test
    @DisplayName("1,2 를 , 로 split시 잘 분리되는지 확인")
    public void splitTest(){
        String[] result = stringCalcurator.splitString("1,2");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    @DisplayName("1 을 , 로 split시 잘 분리되는지 확인")
    public void splitTest2(){
        String[] result = stringCalcurator.splitString("1");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("(1,2) 에서 (,) 이 잘 제거되었는지 확인")
    public void isRemoveParenthesis() {
        String result = stringCalcurator.removeString("(1,2)");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("(1,2) 에서 ) 이 잘 제거되었는지 확인")
    public void isRemoveParenthesis2() {
        String result = stringCalcurator.removeString("(1,2");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc값 주어졌을 때 특정 위치의 문자 가져오는지 확인")
    public void isFindCharToIndex() {
        String result = stringCalcurator.findCharToIndex(1);
        assertThat(result).isEqualTo("b");
    }

    @Test
    @DisplayName("abc값 주어졌을 때 벗어난 위치의 문자 조회시 예외 발생 확인")
    public void isExceptionFindCharToIndex() {
        assertThatThrownBy(() -> {
            stringCalcurator.findCharToIndex(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
