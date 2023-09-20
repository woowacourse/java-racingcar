import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class GameView {
    public void askCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).");
    }
    public void askTryCounts(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }
    public void printRacingStart(){
        System.out.println("실행 결과");
    }
    public static void showProgress(List<Car> carList){
        for (Car car : carList) {
            String s = car.getName() + " : " + "-".repeat(car.getCount());
            System.out.println(s);
        }
    }
    public static void showWinner(List<String> winner){
        String s = " ";
        System.out.println(winner.stream().collect(Collectors.joining(",")) + "가 최종 우승했습니다.");
    }

}
