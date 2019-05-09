package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ControllerTest {

    @Test
    void 자동차_리스트에_자동차가_잘들어갔는지_확인(){
        Controller controller=new Controller();
        controller.carListInit(new String[]{"a","b","c","d","e"});
        assertThat(controller.carList.get(0).getName()).isEqualTo("a");
        assertThat(controller.carList.get(1).getName()).isEqualTo("b");
        assertThat(controller.carList.get(2).getName()).isEqualTo("c");
        assertThat(controller.carList.get(3).getName()).isEqualTo("d");
        assertThat(controller.carList.get(4).getName()).isEqualTo("e");
    }
}
