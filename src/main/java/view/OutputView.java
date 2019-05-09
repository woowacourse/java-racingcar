package view;

import domain.Car;
import domain.Const;

import java.util.List;

public class OutputView {
<<<<<<< HEAD:src/main/java/view/OutputView.java
    public static void outputGameResultTile(){
        System.out.println(Const.OUTPUT_GAME_RESULT);
    }

    public static void outputGameResult(List<Car> carList){
        for(Car car : carList){
=======
    public static void outputGameResult(List<Car> cars) {
        System.out.println(Const.OUTPUT_GAME_RESULT);
        for (Car car : cars) {
>>>>>>> seonghun127:src/main/java/domain/OutputView.java
            System.out.println(car.getName() + " : " + outputCarPosition(car.getPosition()));
        }
        System.out.println();
    }

    private static String outputCarPosition(int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        return result;
    }

<<<<<<< HEAD:src/main/java/view/OutputView.java
    public static void outputWinners(String winners){
=======
    public static void outputWinner(String winners) {
>>>>>>> seonghun127:src/main/java/domain/OutputView.java
        System.out.println(winners + Const.OUTPUT_WINNER);
    }
}
