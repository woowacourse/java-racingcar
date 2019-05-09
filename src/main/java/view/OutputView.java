package view;

import domain.Car;
import domain.Const;

import java.util.List;

public class OutputView {
    public static void outputGameResult(List<Car> cars){
        System.out.println(Const.OUTPUT_GAME_RESULT);
        for(Car car : cars){
            System.out.println(car.getName() + " : " + outputCarPosition(car.getPosition()));
        }
    }

    private static String outputCarPosition(int position){
        String result = "";
        for(int i = 0 ; i < position ; i++){
            result += "-";
        }
        return result;
    }

    public static void outputWinner(String winners){
        System.out.println(winners + Const.OUTPUT_WINNER);
    }
}
