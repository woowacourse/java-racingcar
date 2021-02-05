package racingcar;

import java.util.Scanner;
import racingcar.domain.CarRacing;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        CarRacing carRacing = new CarRacing(scanner);
        carRacing.start();
    }
}
