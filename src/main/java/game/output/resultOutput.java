package game.output;

import game.Car;

import java.util.List;

public class resultOutput {
    static StringBuilder sb = new StringBuilder();

    public static void eachGameOutput(Car car) {
        sb.setLength(0);
        sb.append(car.getCarName());
        sb.append(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }

        System.out.println(sb);
    }

    public static void winnersOutput(List<String> winners) {
        sb.setLength(0);

        sb.append(String.join(", ", winners));
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
