# java-racingcar
자동차 경주 미션 저장소
## 우아한테크코스 코드리뷰
- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
## 기능 명세서
### 입력
- [ ] 자동차 이름을 입력받는 기능
  - [ ] 쉼표를 기준으로 구분
- [ ] 시도횟수를 입력받는 기능
### 출력
- [ ] 단순 텍스트 출력
  - [ ] `경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).`
  - [ ] `시도할 회수는 몇회인가요?`
  - [ ] `실행 결과`
- [ ] 각 라운드 별 레이싱 결과 출력
  - [ ] `name : ---` 형식으로 출력
- [ ] 우승자 출력
  - [ ] 우승자 목록 : 우승자들을 콤마로 Join 하여 String화
  - [ ] `(우승자 목록)가 최종 우승했습니다.` 형식으로 출력
### 비즈니스 로직
- [ ] 전진 여부를 판단하는 기능
  - [ ] 랜덤 값 추출
  - [ ] 랜덤 값이 4 이상이면 true, 아니면 false 반환
- [ ] 자동차 전진 기능
- [ ] 우승자 판단 기능
  - [ ] 전체 자동차 전진 횟수 중 최대값 산출 기능
  - [ ] 최대값과 일치하는 자동차들을 리스트에 담는 기능
### 검증
- [ ] 자동차 이름 유효성 판단 기능
  - [ ] 5자 이상 이름이 들어왔을 때 > 예외발생
  - [ ] 알파벳 이외의 문자로 이름이 구성되었을 때 > 예외발생
  - [ ] 중복된 이름이 입력되었을 때 > 예외발생
- [ ] 자동차 대수 유효성 판단 기능
  - [ ] 차량은 1-100대까지만 허용한다
- [ ] 시도 횟수 유효성 판단 기능
  - [ ] 시도 횟수는 1-100회까지만 허용한다
## 프로그램 흐름
1. 입력
    - `경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)` 출력
    - 자동차 이름 입력
    - `시도할 회수는 몇회인가요?` 출력
    - 시도 횟수 입력
2. 자동차 경주 시작
    - `실행 결과` 출력
    - n회 반복
        - 전진 여부 결정(자동차 대수만큼 반복)
            - 0에서 9 사이에서 random 값 구하기
            - random 값이 4 이상이면 전진, 3 이하면 멈춤
        - 각각의 실행 결과 출력(자동차 대수만큼 반복)
            - 자동차 이름 : 전진횟수 출력
            - 출력 예시
          ```
            pobi : -
            crong : -
            honux : -
            ```
3. 우승자 출력
    - 우승자 판정
        - 전진 횟수가 가장 많은 차(1대 이상)
    - `(우승자 목록)가 최종 우승했습니다.` 출력
    - 예) `pobi, honux가 최종 우승했습니다.`

## 2차 리뷰 반영사항
1. 서비스 로직 이동
    - service 로직을 RacingGame으로 rename
    - pacakge 이동 : service > domain
  
   
2. getter 없이 우승자 목록 반환 기능 개선
   - Car 객체에 score를 기준으로 비교가능한 compareTo Override
   - Car 객체 정렬을 통해 최대 score를 가진 Car 객체 추출
   - 최대 score Car객체와 같은 score를 가진 Car들을 추출
  

3. 이동 로직 확장성 고려
   - RacingGame의 각 라운드는 각 자동차의 이동로직에 종속되지 않아야 한다고 생각했음
   - 이에 각 자동차의 이동로직을 결정하는 willMove()를 메소드로 가지는 MoveStrategy 인터페이스를 생성
   - 이를 구현한 RandomMoveStrategy를 통해 RacingGame의 이동로직 확장이 가능하게 리팩터링함
   
## 고민했었던 점과 질문

### 1. getter 없애기 
### Q : (getter를 없애고 출력 로직을 객체에 넣는 것이 좋은 행위인가?)  
OuputView에서 `[ 자동차 이름 : 자동차 이동거리]` 형태로 출력이 되어야 하기에 getScore와 getName을 없애지 못했음 

그러나, Car 객체의 toString을 오버라이딩 하여
```java
class Car {
    public String toString() {
        return name + " : " + "-".repeat(score);
    }
}
```
를 넣어주면 getter를 제할 수 있었습니다.

그럼에도 다음 사안을 반영해주지 않은 이유는 다음과 같습니다.  

    -1. 정해진 표식 이외에 Car 정보를 출력해야 할 때 => 코드 수정이 불가피하다
    -2. 출력하는 부분은 Car객체가 부담해야할 책임이 아니다. => 출력에 대한 책임을 Car객체가 지면 안된다고 생각했다.

  


### 2. 차량이 많아질 때의 시간복잡도
### Q : compare 구현 이후, 정렬을 통한 비교가 오히려 시간이 더 걸리는 로직이 아닐까?
기존에는 선형탐색으로 최대 score를 찾은후, 다시 선형탐색으로 이와 일치하는 Car 객체들의 name을 찾았습니다.
수정된 코드에서는 compareTo를 통해 배열을 정렬한 후, 다시 선형탐색을 통해 score가 같은 것들을 찾고 있습니다.
```java
public class 기존코드 {
    public static List<String> getWinnerNames(List<Car> cars) {
        int maxScore = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(RuntimeException::new);

        List<String> winnerNames = cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();

        return winnerNames;
    }
}
```
```java
public class 수정된_코드 {

    public static List<String> getWinnerNames(List<Car> cars) {

        Collections.sort(cars);
        Car maxScoreCar = cars.get(0);

        return cars.stream()
                .filter(car -> car.compareTo(maxScoreCar) == 0)
                .map(Car::getName)
                .toList();
    }
}

```
기존 코드의 시간복잡도가 O(n^2)라면 수정된 코드에서는 O(nlog(n)) -정렬 * O(n)-선형탐색 이기에
많은 차량이 주어지면 오히려 시간복잡도가 더 늘어나지 않을까하는 우려가 있었습니다.




