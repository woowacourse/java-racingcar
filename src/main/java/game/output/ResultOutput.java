package game.output;

import game.Car;

import java.util.List;

public class ResultOutput {
    static StringBuilder sb = new StringBuilder();

    public static void printEachGame(Car car) {
        init();

        sb.append(car.getName());
        sb.append(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }

        System.out.println(sb);
    }

    public static void printWinners(List<String> winners) {
        init();

        sb.append(String.join(", ", winners));
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb);
    }

    public static void printNewLine() {
        System.out.println();
    }

    private static void init() {
        sb.setLength(0);
    }
}