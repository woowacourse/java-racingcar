package racinggame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import racinggame.condition.RandomMoveCondition;

// TODO : Main을 리팩터링하기 전에 이동한다.
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carName = br.readLine();
        List<String> carNames = Arrays.asList(carName.split(","));
        List<Car> cars = carNames.stream()
            .map(Car::from)
            .toList();

        RacingGame game = RacingGame.of(cars, new RandomMoveCondition());

        System.out.println("시도할 회수는 몇회인가요?");
        Round round = Round.from(Integer.parseInt(br.readLine()));

        game.race(round);
        List<RoundResult> results = game.getResult();

        results.forEach(result -> {
            result.carInfos().forEach(carInfo -> {
                System.out.println(carInfo.name() + " : " + "-".repeat(carInfo.position()));
            });

            System.out.println();
        });

        System.out.format("%s가 최종 우승했습니다.", game.findWinnerName());
    }
}
