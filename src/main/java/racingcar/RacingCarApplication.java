package racingcar;

import racingcar.view.InputView;

import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        InputView.setScanner(scanner);
    }
}
