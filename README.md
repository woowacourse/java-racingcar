# java-racingcar

# 자동차 경주 게임 미션 저장소

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- indent(인덴트, 들여쓰기) depth를 3을 넘지 않도록 구현한다. 2까지만 허용한다.
- else 예약어를 쓰지 않는다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.

## 구조
## RacingCar

### View

- **InputView**
    - 차 이름을 입려받는 inputCarName
        - 공백을 제거하기 위한 trimCarNames 메소드
        - 예외처리를 하기 위한 checkInputCarNameValidation 메소드
    - 시도 횟수를 입력받는 inputTrialTime
        - 예외처리를 하기 위한 checkInputTrialTimeValidation 메소드
        
- OutputView

---

### Model(도메인)

- **Car**
    - carName, position을 상태 변수로 갖는다.
    - position 상태를 변화시키는 goOrNot 메소드
        - 랜덤 숫자에 따라 이동할 지 결정하는 isGo 메소드
            - 랜덤 숫자를 반환하는 createRandomNumber 메소드
    - 인자로 받은 Car 객체와의 position 변수를 비교하여 높은 값을 갖고 있는지를 알려주는 comparePosition 메소드
    - 현재 위치를 '-'를 이용하여 보여주는 showCurrentPosition 메소드
    - 최종 우승한 차의 carName을 저장하기 위한 findWinners 메소드

---

### Controller

- **Game**
    - Car 객체를 저장하는 cars, 시도 횟수를 저장하는 trialTime를 클래스 변수로 갖는다.
    - initialize
        - 자동차 이름 input
        - Car instance 생성
        - trialTime input
        - trialTime 초기화
    - race
        - trialTime만큼 경주 진행하는 raceOneRound 메소드
            - 각 Car 객체에 대해 이동할 지 확인하고, 현재 position 값에 맞게 '-'로 출력.
    - showWinner
        - findTopPositionCar 메소드를 호출하여 position이 가장 큰 Car 객체를 찾음.
            - cars 리스트를 순회하여 position이 가장 큰 Car 객체를 찾는 findTopPositionCar 메소드.
        - 가장 큰 Car객체에서 findWinners 메소드를 사용하여 cars 리스트를 순회 후, 최종 우승자 목록 출력.
        
- **InputValidation 예외처리(유효성 검사) 클래스**

    **자동차 이름** 

    - [예외처리] 차 이름 다섯글자 초과인 경우 ⇒ "차 이름의 길이가 6 이상입니다." (IllegalArgumentException)
    - [예외처리] null이나 빈문자열이 입력될 경우 ⇒ "입력이 null 이나 빈 문자열입니다." (NullPointerException)
    - [예외처리] 차 이름 중 빈 문자열이 있을 경우 ⇒ "차 이름은 빈 문자열일 수 없습니다." (IllegalArgumentException)

    **시도 횟수**

    - [예외처리] 소수가 입력되었을 경우 ⇒ "소수는 입력할 수 없습니다."(InputMismatchException)
    - [예외처리] 문자가 입력되었을 경우 ⇒ "문자는 입력할 수 없습니다." (NumberFormatException)
    - [예외처리] 시도횟수가 0이하인 경우 ⇒ "음수 또는 0을 입력할 수 없습니다." (IllegalArguementException)
    - [예외처리] Int범위를 벗어날 경우 ⇒ "입력 범위를 초과했습니다." (ArithmeticException)
    
    ---
    
    ## Main
    
    - Game 클래스 메소드인 initialize, race, showWinner 메소드를 순차적으로 호출한다.
    
    ---
    
## 테스트 목록
    
### InputControlTest

- inputControl_컴마로_분리
- inputControl_차_이름_글자수
- inputControl_null_또는_빈문자열_입력
- inputControl_시도횟수가_0이하
- inputControl_시도횟수가_범위초과
- inputControl_시도횟수가_소수_입력
- inputControl_시도횟수가_문자_입력

### CarTest

- isGo_랜덤숫자가_4이상일때만_true_반환()
    - true, false로 테스트.
- comparePosition_파라미터로_들어온_객체보다_포지션이_크면_true로_반환()
    - true, false로 테스트.

### GameTest

- findTopPositionCar()
    - position이 가장 큰 차 선별
    - 임의로 리스트 생성 후, 그 중 가장 큰 position으로 생성된 객체와 비교.
- findWinners()
    - 가장 큰 position을 갖고 있는 객체와 리스트에 있는 객체들을 비교.
    - 가장 큰 position을 갖고 있는 객체 자신과 동일한 position 값을 갖고 있는 객체를 포함.
        
## 피드백 내용

### 첫번째 피드백

- [x] CarTest class 내 isGo 메서드 관련 테스트 케이스를 단순화 하자.
- [x] Car 객체의 isGo 메서드를 private으로 선언 할 수 있지 않을까.
- [x] 잘못된 input을 받는 경우에, 재시도를 하기 위한 종료 조건이 필요하다.
- [x] InputView의 역할이 가중되어 있다.
- [ ] Car 객체로부터 출력을 분리하자.
- [x] Car Name에 대한 유효성 검사는 Car의 역할로 적합하다.
- [ ] indent의 최대 깊이는 1이다.
- [ ] Game class로부터 입출력을 분리하자.
- [x] null인 경우, 빈 문자열인 경우에 대해 테스트를 분리하자
        
# 문자열 계산기 미션 저장소

## 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

## 힌트 ( 필요한 테스트 메서드 )
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
- splitAndSum_null_또는_빈문자()
2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- splitAndSum_숫자하나()
3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
- splitAndSum_쉼표구분자()
4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- splitAndSum_custom_쉼표_혹은_콜론_구분자()
5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- splitAndSum_custom_구분자()
6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
- splitAndSum_negative()

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
