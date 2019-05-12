package racing.view;

import racing.domain.Car;
import racing.domain.Race;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printErrMsg(String message) {
        System.out.println(message);
    }

    public static void printCar(final Car c) {
        String positionBars = "";
        for (int i = 0; i < c.getPosition(); i++) {
            positionBars += "-";
        }
        System.out.println(c.getName() + " : " + positionBars);
    }

    public static void printRace(final Race race) {
        Iterator<Car> it = race.getCars().iterator();
        while (it.hasNext()) {
            printCar(it.next());
        }
        System.out.println();
    }

    public static void printResult(final List<Car> winners) {
        List<String> result = new ArrayList<>();
        Iterator<Car> it = winners.iterator();
        while (it.hasNext()) {
            result.add(it.next().getName());
        }
        System.out.println(String.join(", ", result) + "가 최종 우승했습니다.");
    }
}
