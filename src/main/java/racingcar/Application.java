package racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Cars cars = new Cars(input);

        String countInput = sc.nextLine();
        RacingGame racingGame = new RacingGame(countInput, cars);

        // 3. 게임 실행 및 결과 출력
    }
}
