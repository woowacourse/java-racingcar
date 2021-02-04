package racingcar.view;

import racingcar.domain.car.CarRepository;

public class GamePage {

    public static void printResult(){
        System.out.println("\n실행 결과");
    }

    public static void printSingleRoundResult(){
        CarRepository.cars()
                .forEach(System.out::println);
        System.out.println();
    }
}
