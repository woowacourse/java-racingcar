package racinggame.view;

import java.util.Scanner;

/**
 * InputView 클래스는 입력을 받는 부분만 담당하는(MVC 구조에 View를 담당하는) 클래스이다.
 * InputView 인스턴스를 만드는 것을 고려하지 않고 설계하였다.
 */
public class InputView {
    /**
     * scanner는 입력을 위한 Scanner 인스턴스이다.
     * 본 클래스 내에서 다수 사용되기 때문에,
     * static final로 생성하여 재활용 여부와 데이터의 신뢰성을 보장하도록 하였다.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 생성자 메서드는 호출되지 않는 것이 정상이므로 private으로 설정하였다.
     *
     * @throws AssertionError : 잘못된 선언이 발생할 경우 예외처리한다.
     */
    private InputView() {
        throw new AssertionError();
    }

    public static String inputName() {
        OutputView.printNameFormat();
        return scanner.nextLine();
    }

    public static String inputRepeat() {
        OutputView.printRepeatFormat();
        return scanner.nextLine();
    }
}
