# 기능 요구 사항

- [x] 각 자동차에 이름을 부여할 수 있다.
    - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다
    - [x] 자동차 이름은 5자 이하만 가능하다.
    - [x] 자동차 이름은 중복일 수 없다.
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - [x] 시도횟수는 음이 아닌 정수여야 한다.
    - [x] 시도횟수는 Integer.MAX_VALUE를 넘지 않는다.
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - [x] 자동차는 전진 할 수 있다.
    - [x] 자동차는 멈출 수 있다.
    - [x] 자동차는 위 행위를 반복 할 수 있다.
    - [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한다.
    - [x] random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- [x] 1회 시도 후 현황을 출력한다.
    - [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 가장 많이 전진한 자동차를 우승자로 정한다. 단 우승자는 여러 명일 수 있다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [x] 예외가 발생하였을 때, 해당 부분부터 다시 입력을 받을 수 있다.

# 예외 사항

- [x] 자동차 이름이 5자 초과일 경우 예외처리
- [x] 자동차의 이름이 동일한 경우 예외처리
- [x] 입력된 시도횟수가 유효하지 않는 값일 경우 예외처리

# 프로그램 흐름

1. 자동차 이름 입력받기(InputView)
2. 자동차 객체 생성(Controller → Service)
3. 시도횟수 입력받기(InputView)
4. 시도횟수 만큼 아래를 반복
    1. 조건에 맞게 자동차를 전진시키거나 정지하기(Controller → Service → Car)
    2. 현황을 조회하기(Service)
    3. 현황을 출력하기(OutputView)
5. 최종 우승자를 결정하기(Service)
6. 최종 우승자를 출력하기(OutputView)

# 리팩토링 목록

- [ ] 유효성 검증을 해야하는 값들을 일급컬렉션으로 분리
    - [x] Race의 List<Car> cars
    - [ ] Race의 int tryTiem
- [x] ExceptionHandlingTemplate의 repeat...메소드의 depth를 1로 줄이기
- [x] RandomNumberPicker에서 Random을 필드변수로 두기.
- [x] Car class에서 this()를 사용하여 코드의 반복을 제거
- [x] 우승자를 결정하는 로직에서 get말고 객체에 메세지를 보내는 방식으로 구현하기
- [x] 가능한 final 키워드를 모든 변수에 사용하기.
- [x] ExceptionHandlingTemplate을 지우고, repeatUntilInitialValid 메서드를 controller에서 정의
    1. ExceptionHandlingTemplate안에 outputView 객체를 생성하는 행위가 불필요하다 생각.
    2. 현 프로젝트에선 controller가 하나밖에 없으므로, 굳이 따로 Template Interface를 정의해서 얻을 이득이 없음.
