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
