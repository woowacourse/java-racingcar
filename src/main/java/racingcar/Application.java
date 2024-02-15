package racingcar;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import racingcar.generator.RandomGenerator;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cars cars = createCars(sc);
        RacingGame racingGame = createRacingGame(sc, cars);

        TotalResult totalResult = new TotalResult(racingGame.gameStart());

        printResult(totalResult);
        printWinnerInfo(totalResult);
    }

    private static Cars createCars(Scanner sc) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();
        validateInput(input);
        List<Car> cars1 = Arrays.stream(input.split(","))
                .map(Car::new)
                .toList();
        return new Cars(cars1, new RandomGenerator());
    }

    private static RacingGame createRacingGame(Scanner sc, Cars cars) {
        System.out.println("시도할 회수는 몇회인가요?");
        String countInput = sc.nextLine();
        sc.close();
        return new RacingGame(countInput, cars);
    }

    private static void printResult(TotalResult totalResult) {
        System.out.println();
        System.out.println("실행 결과");
        for (RoundResult roundResult : totalResult.getTotalResult()) {
            LinkedHashMap<String, Integer> result = roundResult.getResult();
            for (String s : result.keySet()) {
                System.out.println(s + " : " + "-".repeat(result.get(s)));
            }
            System.out.println();
        }
    }

    private static void printWinnerInfo(TotalResult totalResult) {
        List<String> winners = totalResult.selectWinner();
        System.out.printf("최종 우승자: %s%n", String.join(", ", winners));
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty() || input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }
}
