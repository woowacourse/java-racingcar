# 문자열 덧셈 계산기

## 구현할 기능

- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환하는 기능
- [x] 문자열을 나누는 기능
- [x] 문자열을 숫자로 바꾸는 기능
- [x] 숫자를 모두 더하는 기능
- [x] 구분자를 커스텀 할 수 있다.
    - [x] 구분자는 "//(구분자)\n"로 설정한다.
- [x] 입력이 하나인 경우 그대로 반환하는 기능

## 예외 상황

- [x] 입력이 숫자가 아닌 경우 `RuntimeException`을 throw 한다.
- [x] 입력이 음수인 경우 `RuntimeException`을 throw 한다.

# 자동차 경주

## 구현할 기능

- [x] 자동차 이름을 설정하는 기능
- [x] 자동차 이름을 나누는 기능
- [x] 시도할 회수를 설정하는 기능
- [x] 자동차가 전진하는 기능
- [x] 실행 결과 반환하는 기능
- [x] 자동차를 시도할 회수만큼 경주하는 기능
- [x] 우승자를 판단하는 기능
- [x] UI 출력 기능

## 예외 상황

- [x] 자동차 이름이 잘못된 경우 `RuntimeException`을 throw 한다.
    - [x] 이름을 입력하지 않는 경우
    - [x] 입력한 이름 중 공백이 있는 경우
    - [x] 이름이 5자를 넘을 경우
    - [x] 중복된 이름을 입력한 경우

- [x] 시도할 회수가 잘못된 경우 `RuntimeException`을 throw 한다.
    - [x] 회수가 입력하지 않는 경우
    - [x] 회수가 숫자가 아닌 경우
    - [x] 회수가 음수인 경우

---

## 피드백 수정 기록 및 궁금한 점

- [x] FIXME google java style 메소드 명은 동사로 시작해야 한다.(5.2.3)
    - valid -> validate
    - judge -> find
    - toString(), of() 처럼 전치사로 시작하는 경우는 예외인가?
    - google Java 컨벤션 -> 메소드 명은 동사, 동사구로 시작한다.
    - oracle Java 컨벤션 -> 메소드 명은 동사로 시작한다.
    - 네이버 Java 컨벤션 -> 메소드 명은 동사/전치사로 시작한다.

- [x] FIXME 파라미터가 없는 메소드에서 `IllegalArgumentException`이 사용되는 것이 적절한가?
    - RandomUtil.generateRandomNumber()에는 파라미터가 없지만 그 내부에서 `IllegalArgumentException`이 사용됨.
    - `IllegalStateException`를 사용하여 예외를 처리하도록 수정
    - `IllegalStateException`는 메소드 처리를 하려할 때 잘못된 상태가 된 경우 발생하는 예외이다.

- [ ] FIXME Cars를 생성하는 책임을 Cars에게 줄 수 있다면?
    - RacingCar

- [ ] TODO 출력 형식이 바뀌어야 한다면 View와 Cars중 어느곳이 수정되어야 하는가?
    - Cars.repeatRaceBy()

- [ ] FIXME 메소드 명이 적절한가?
    - Cars.isSize()

- [ ] FIXME 이 메서드는 테스트에서만 사용되는데 이 메서드를 꼭 사용해서 테스트해야할까?
    - Cars

- [ ] FIXME Winners가 CarName을 가지는 것과 Car를 가지는 것 중 어느것이 더 좋을까?
    - Winners

- [x] TODO checkedException/uncheckedException의 차이에 대해 고민해보기
    - Calculator.toInteger()
    - Integer.parseInt()는 잘못된 값을 파라미터로 보낼 경우 알아서 `NumberFormatException`을 throw한다.
    - `NumberFormatException`도 `RuntimeException`의 한 종류이다.
    - 따라서 try/catch문을 쓰지 않아도 되지만 내가 원하는 에러를 발생시키고 싶다면 예외를 catch하여 원하는 에러 메시지를 추가하여 다시 throw를 해야하지
      않을까?
      