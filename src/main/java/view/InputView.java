package view;

import java.util.Scanner;

public class InputView {

    // TODO: 실패 시 에러처리 및 재입력 받는 부분 작성하기
    public static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
