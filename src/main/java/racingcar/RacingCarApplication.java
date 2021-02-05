package racingcar;

import racingcar.view.InputView;

import java.util.Scanner;

/**
 * Application.java
 * 자동차 경주 게임
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class RacingCarApplication {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        InputView.setScanner(scanner);
    }
}
