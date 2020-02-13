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

- InputView ← split() 후 배열반환
- OutputView

---

### Model(도메인)

- **Car**
    - name, position
    - go or not (int random)
    - 랜덤 수만 뽑는 메서드
    - 현재 위치 반환(숫자로 반환)
    - 현재 위치 반환(-로 반환)  

---

### Controller

- **Game**
    - cars
    - winner (미정)
    - trialTime
    - initialize
        - 자동차 이름 input
        - car instance 생성
        - trialTime input
        - trialTime 초기화
    - race
        - showPositions(위치 출력도 한다)
        - 자동차_수 * trialTime만큼 경주 진행
    - winner 계산
        - 공동 우승 List
- **InputValidation 예외처리(유효성 검사) 클래스**

    **자동차 이름** 

    - [예외처리] 차 이름 다섯글자 초과인 경우
    - [예외처리] null이나 빈문자열이 입력될 경우

    **시도 횟수**

    - [예외처리] 시도횟수가 0이하인 경우 ⇒ "음수를 입력할 수 없습니다." (IllegalArguementException)
    - [예외처리] Int범위를 벗어날 경우 ⇒ "범위를 초과했습니다." (ArithmeticException)
    - [예외처리] 소수가 입력되었을 경우 ⇒ "소수는 입력할 수 없습니다."(InputMismatchException)
    - [예외처리] 문자가 입력되었을 경우 ⇒ "문자를 입력할 수 없습니다." (IllegalArguementException)
    
    ---
    
    ## Main
    
    
    
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
    
    ### DomainModelTest
    
    - goOrNot_랜덤숫자가_4이상일때만_움직인다()
        - true, false로 테스트.
    - getPosition_차의_현재_포지션
    
    ### GameTest
    
    - initialize_이름으로_차_객체_생성_테스트(String[] inputs)
        - return이 List<Car>
    - setUp → 게임이 끝난 후 차 인스턴스들 만들기 (이름, 포지션)
        - calculateWinner_우승자_선별
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
