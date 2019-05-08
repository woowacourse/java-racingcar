package domain;

import java.util.List;

public class OutputView {
    public static void outputGameResult(List<Car> cars){
        System.out.println("실행 결과");
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
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
