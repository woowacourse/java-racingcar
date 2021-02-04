package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        if(!NameSpliter.inputChecker(input)){
            throw new RuntimeException();
        }
        String[] carNames = input.split(",");
        for(String carName : carNames) {
            Cars.carAdd(new Car(carName));
        }
        int count = getNumber();
        playGame(count);
        showResult();
    }

    private static void showResult() {
        List<String> winners = new ArrayList<>();
        int max = findMax();
        for (Car car : Cars.cars) {
            if (car.distance == max) {
                winners.add(car.name);
            }
        }
        String result = "";
        for (int i=0; i<winners.size(); i++) {
            result += winners.get(i);
            if (i==winners.size()-1) {
                break;
            }
            result += ", ";
        }
        result += "가 최종 우승했습니다.";
        System.out.println(result);
    }

    private static int findMax() {
        int max = 0;
        for (Car car : Cars.cars) {
            if (car.distance > max) {
                max = car.distance;
            }
        }
        return max;
    }

    private static void playGame(int count) {
        for(int i=0;i<count;i++){
            playCar();
        }
    }

    private static void showStatus() {
        for (Car car : Cars.cars) {
            System.out.println(car.name + " : " + bar(car.distance));
        }
        System.out.println();
    }

    private static String bar(int distance) {
        String bars = "";
        for (int i=0; i<distance; i++) {
            bars += "-";
        }
        return bars;
    }

    private static void playCar() {
        for(int i=0;i<Cars.cars.size();i++){
            int number = RandomUtils.nextInt(0,9);
            Cars.cars.get(i).move(number);
        }
        showStatus();
    }

    private static int getNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int number;
        try{
            number = scanner.nextInt();
            if(number < 1){
                throw new RuntimeException();
            }
        }catch(RuntimeException e){
            throw new RuntimeException();
        }
        return number;
    }
}
