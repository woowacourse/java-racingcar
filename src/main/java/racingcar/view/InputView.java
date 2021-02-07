package racingcar.view;

import java.util.Scanner;


//TODO
// validation 도메인에 있는것들 iputview에도 추가하기
public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }
}
