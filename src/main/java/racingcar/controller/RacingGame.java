package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String RESULT_STR = "실행 결과";
    private static final InputView input = new InputView();

    public void run(){
        List<Car> carList = setCarName();
        int number = inputNumber();

        System.out.println("\n"+RESULT_STR);
        for(int i = 0 ; i< number ; i++){
            carList = getRacingPostion(carList);
        }
        List<String> winner =  getWinner(carList);
        ResultView resultView = new ResultView();
        resultView.printWinner(winner);
    }

    private List<Car> setCarName(){
        String[] name = input.inputName();
        List<Car>  carList = new ArrayList<>();

        for(String carName : name){
            carList.add(new Car(carName));
        }

        return  carList;
    }

    private int inputNumber(){
        return input.inputNumber();
    }

    private List<Car> getRacingPostion(List<Car> carList){
        Racing racing = new Racing();
        ResultView resultView = new ResultView();

        for(int i = 0 ; i < carList.size() ; i++){
            int position = racing.move(carList.get(i), racing.getRandomNumber());
            carList.get(i).setPosition(position);
        }
        resultView.printResult(carList);

        return carList;
    }

    private List<String> getWinner(List<Car> carList){
        GameResult gameResult = new GameResult();
        return gameResult.racingResult(carList);
    }

}
