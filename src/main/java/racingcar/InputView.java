package racingcar;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 게임이 종료된 후 스캐너를 닫습니다
     */
    public static void terminate() {
        scanner.close();
    }

    public String readCarNamesInput(){
        return scanner.nextLine();
    }

    public int readRoundNumberInput(){
        return Integer.parseInt(scanner.nextLine());
    }
}
