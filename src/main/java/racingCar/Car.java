package racingCar;

public class Car {

    String name;
    int distance;

    Car(String name){
        if(!NameSpliter.inputChecker(name)){
            //error
        }
        this.distance = 0;
        this.name = name;
    }
}
