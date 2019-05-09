package game.output;

import game.Car;

public class resultOutput {
    public static void result(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getCarName());
        sb.append(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }

        System.out.println(sb);
    }
}
