package controller;

import domain.Cars;
import domain.Trial;
import view.InputView;

public class Controller {
    InputView inputView = new InputView();
    public void run() {
        askCars();
        askTrial();
    }


    private Cars askCars() {
        try{
            return new Cars(inputView.askCars());
        } catch (IllegalArgumentException e){
            return askCars();
        }
    }
    private Trial askTrial() {
        try{
            return new Trial(inputView.askTrial());
        }catch (IllegalArgumentException e){
            return askTrial();
        }
    }


}
