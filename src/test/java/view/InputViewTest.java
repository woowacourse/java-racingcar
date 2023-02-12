package view;

import exception.BlankInputException;
import exception.BlankNameException;
import exception.DuplicateCarNameException;
import exception.WrongNameLengthException;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("공백을 입력하면 BlankInputException 예외가 발생한다.")
    void inputBlank() {
        InputView inputView = generateTestInputView(" ");

        Assertions.assertThatThrownBy(inputView::inputCarsName)
                .isInstanceOf(BlankInputException.class);
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 WrongNameLengthException 예외가 발생한다.")
    void inputWrongLengthName() {
        InputView inputView = generateTestInputView("abcdef");

        Assertions.assertThatThrownBy(inputView::inputCarsName)
                .isInstanceOf(WrongNameLengthException.class);
    }

    @Test
    @DisplayName("중복된 이름을 입력하면 DuplicateCarNameException 예외가 발생한다.")
    void inputDuplicateName() {
        InputView inputView = generateTestInputView("aaa,aaa");

        Assertions.assertThatThrownBy(inputView::inputCarsName)
                .isInstanceOf(DuplicateCarNameException.class);
    }

    @Test
    @DisplayName("자동차의 이름을 구분할 때 이름이 공백이면 BlankNameException 예외가 발생한다.")
    void inputBlankName() {
        InputView inputView = generateTestInputView(",aaa");

        Assertions.assertThatThrownBy(inputView::inputCarsName)
                .isInstanceOf(BlankNameException.class);
    }

    private InputView generateTestInputView(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return new InputView(new Scanner(System.in));
    }
}