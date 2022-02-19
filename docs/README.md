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

## 요구사항

- 코드 컨벤션을 지킨다.
    - https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
- 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- else 를 쓰지 않는다.
- 함수의 길이는 15라인을 넘어가지 않도록 구현한다.
- 핵심 비지니스 로직을 가지는 객체는 domain, UI 관련 객체는 view 패키지에 구현한다.
- view 패키지의 객체가 domain 패키지의 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지의 객체에 의존하지 않도록 구현한다.
- 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.

---

## 피드백 수정 기록 및 궁금한 점

- [x] google java style 메소드 명은 동사로 시작해야 한다.(5.2.3)
    - valid -> validate
    - judge -> find
    - toString(), of() 처럼 전치사로 시작하는 경우는 예외인가?
    - google Java 컨벤션 -> 메소드 명은 동사, 동사구로 시작한다.
    - oracle Java 컨벤션 -> 메소드 명은 동사로 시작한다.
    - 네이버 Java 컨벤션 -> 메소드 명은 동사/전치사로 시작한다.

- [x] 파라미터가 없는 메소드에서 `IllegalArgumentException`이 사용되는 것이 적절한가?
    - RandomUtil.generateRandomNumber()에는 파라미터가 없지만 그 내부에서 `IllegalArgumentException`이 사용됨.
    - `IllegalStateException`를 사용하여 예외를 처리하도록 수정
    - `IllegalStateException`는 메소드 처리를 하려할 때 잘못된 상태가 된 경우 발생하는 예외이다.

- [x] Cars를 생성하는 책임을 Cars에게 줄 수 있다면?
    - RacingCar
    - RacingCar는 입력된 자동차 이름을 String 배열로 만들어서 Cars에게 주고 Cars가 자동차 객체들을 생성하여 List로 만들게 함.
    - Cars를 RacingCar가 아닌 Cars가 생성하도록 하여 Cars에 대한 책임은 Cars에 모아두도록 수정함.

- [x] 출력 형식이 바뀌어야 한다면 View와 Cars중 어느곳이 수정되어야 하는가?
    - Cars.repeatRaceBy()
    - 출력 형식이나 결과가 바뀐다면 View가 수정되어야 할 것이다.
    - Cars는 결과를 반환하고 View에서 결과를 이용하여 출력 값을 만드는 방법으로 수정했다.
    - Cars는 매 라운드 별 자동차들의 이름과 이동 거리를 vo(RoundResult)로 만들어 반환한다.
    - View는 RoundResult에서 반환된 결과값으로 출력을 함.

- [x] VO가 View의 세부사항을 알고 있는것이 바람직한가?
    - Position
    - 출력과 관련된 부분은 VO가 아닌 View가 처리하도록 수정
    - 실행 결과의 형식이 달라지면 VO가 아닌 OutputView를 수정하게 됨.

- [x] 메소드 명이 적절한가?
    - Cars.isSize()
    - isXXX는 객체가 XXX인지 확인한다는 의미로 단순하게 크기만을 비교하고 싶다면 matchSize등이 더 적합할 것 같음.

- [x] 이 메서드는 테스트에서만 사용되는데 이 메서드를 꼭 사용해서 테스트해야할까?
    - Cars
    - 테스트만을 위한 메소드를 만드는 방법도 있다고 들었지만 이상황에서는 잘 안맞는 것 같음.
    - isSize() 또는 matchSize() 등의 메소드는 테스트가 아닌 상황에서 사용이 될 수도 있을 것 같았기 때문이다.
    - toString()와 assertThat().contains()를 이용하여 테스트를 할 수 있을 것 같다.

- [x] Winners가 CarName을 가지는 것과 Car를 가지는 것 중 어느것이 더 좋을까?
    - Winners
    - Winners는 Cars에서 우승자(Car)를 찾는 것이기 때문에 Car를 가지고 있는것이 더 자연스러운것 같다.
    - 이후 이름을 얻기위해 getName()으로 CarName을 얻고 CarName.get()으로 String형 이름을 얻는다.

- [x] checkedException/uncheckedException의 차이에 대해 고민해보기
    - Calculator.toInteger()
    - Integer.parseInt()는 잘못된 값을 파라미터로 보낼 경우 알아서 `NumberFormatException`을 throw한다.
    - `NumberFormatException`도 `RuntimeException`의 한 종류이다.
    - 따라서 try/catch문을 쓰지 않아도 되지만 내가 원하는 에러를 발생시키고 싶다면 예외를 catch하여 원하는 에러 메시지를 추가하여 다시 throw를 해야하지 않을까?

- [x] move의 테스트를 generateRandomNumber() 때문에 하지 못하고 있는데 해결방법은 없는가?
    - Car
    - https://tecoble.techcourse.co.kr/post/2020-05-17-appropriate_method_for_test_by_interface
    - 문제점
        - move() 내에서 랜덤값을 만드는 메소드를 호출하면 테스트하기 어렵다.
    - 해결 방법
        - move(int randomNumber)와 같이 파라미터로 랜덤값을 주면 move() 메소드를 테스트하기 쉽다.
        - move()메소드를 테스트 할 때 파라미터 값으로 이동이 가능한 값을 주면 이동이 성공하고, 이동이 불가능 한 값을 주면 이동이 실패한다.
        - 전략 패턴을 사용한 인터페이스 분리를 하면 테스트하기 더 쉽고 코드의 응집도가 더 높아진다고 한다.
        - [ ] 전략 패턴과 인터페이스 분리가 완전히 이해되면 체크

- [x] 테스트의 메소드 명을 모두 영어로 수정한다.
    - @DisplayName()을 이용하여 메소드명 + 설명 형식으로 한국어로 설명했다.

- [x] 테스트에서 중복되는 것들을 Parameterized Test를 이용하여 리팩토링할 수 있지 않을까?
    - @ParameterizedTest(name = "{index} : {0}")
        - name으로 @DisplayName처럼 사용할 수 있다.
        - {index} : 반복 테스트 인덱스
        - {0} : 첫번째 파라미터 값
    - @ValueSource(strings = {"a", "b"})
    - @NullSource
    - @EmptySource
    - @NullAndEmptySource
    - @EnumSource(value = MyEnums.class, names = {"NAME1", "NAME2"})
    - @MethodSource
    - https://www.baeldung.com/parameterized-tests-junit-5

## step2 MVC 패턴으로 리팩터링 해보기

### MVC 패턴 관련 수정

- Winners에서 처리하던 출력 세부사항을 OutputView로 이동
- DTO를 이용하여 데이터를 이동
    - View -> Controller : RequestXXXDto
    - Controller -> View : ResponseXXXDto
- 자동차 이름 입력을 나누는 RacingCar.splitCarNames를 InputView에서 하도록 수정(View에서 Cars까지 만들어서 Controller에게 반환)
- RacingCar의 로직을 main으로 이동(Controller의 역할을 RacingCar가 아닌 main이 하도록 수정함)
- controller와 domain 사이에 service를 추가(service에서 여러 로직을 처리하고 controller는 원하는것만 시키거나 얻을 수 있도록 함)

### Test 관련 수정

- 전체 통합 테스트가 제대로 되지 않음
    - 문제점 : ParameterizedTest로 테스트하면 두번째 테스트부터는 실패함.
    - 원인 분석 : InputView에서 Scanner를 상수로 처리했는데 이렇게 되면 문제가 발생 Scanner를 상수(static)으로 생성하고 ParameterizedTest로 테스트하면 2번째 이후
      테스트에서 제대로 입력을 받지 못함. ParameterizedTest를 하면 Java 프로그래밍은 1번돌아가고 거기서 여러번의 테스트케이스가 돌아간다. 그렇기 때문에 가장 처음 케이스에서 성공을 하고
      두번째 테스트에서부터는 Scanner에 첫번째 데이터가 들어간 상태로 이미 상수로 생성되어 있기 때문에 제대로 테스트가 되지 않는다.
    - 해결 방법 :
        - Controller에서 Scanner를 만들어 InputView로 파라미터로 준다.
        - InputView에서 Scanner를 static으로 쓰지 않고 매번 새로 생성한다.
        - 또 다른 방법이 있을까?
    - 시도했던것들 :
        - static을 없애고 InputView의 인스턴스 변수로 Scanner를 만들어 사용하는 방식으로 문제를 해결해봄.
        - Scanner를 Controller에서 만들어서 주지 않은 이유는 InputView에서만 사용되는 Scanner를 꼭 Controller에서 생성하고 가지고 있어야하나? 라는 생각이 들었기 때문임
- 자동차 경주 게임의 기능 통합 테스트와 예외 상황 테스트 추가
- ApplicationTest.empty_input_exception_test에서 가장 마지막에 공백이 오는 경우(`a,b,`) 예외 처리하지 않는 오류 수정
- assertThat.allSatisfy() : Test에서 for문으로 assertThat을 돌리는 경우 사용
- hasMessageContaining()를 이용하여 예외 처리 테스트를 더 정확하게 하도록 수정
    - 에러 메시지를 가지는 Enum을 만든다.
    - 같은 ErrorMessageEnum을 domain과 test에서 사용한다.
    - 그러면 에러 메시지가 수정될 때 domain과 test 모두를 수정하지 않아도 될 것 같다.

## step2 MVC 패턴으로 리팩터링 해보기 피드백 정리

- [x] 도메인에서 DTO가 맡은 역할이 무엇일까요?
    - DTO는 domain과 view 사이에서 필요한 데이터를 안전하게 이동하는 역할을 합니다.
        - 저도 DTO는 domain과 view 사이에서 서로를 의존하지 않으면서 데이터 불변을 보장하여 전달하기 위해 사용했습니다.
        - getter, setter 외에 다른 로직을 가지지 않는 특징이 있습니다. setter를 쓰지 않는다면 객체를 생성할때만 데이터가 설정되기 때문에 전달 과정(controller)에서 전달하는 값이
          수정되지 않는것을 보장할 수 있다고 이해했습니다. 이번 단계에서 핵심 리팩터링
          요구사항으로 `MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.`
          라는 내용이 있었습니다.
        - A가 B를 의존한다는 것은 A가 B를 사용하고 있어서 B가 변경되면 A도 변경될 수도 있다는 의미로 이해했습니다. 이 부분을 알고나니 왜 domain 부분에서 View의 세부사항을 알필요가 없는지
          이해했습니다.
        - 이 요구사항을 만족하기위해 domain의 객체에서 toString()을 view로 보내지 않고 DTO를 이용하여 view로 필요한 데이터를 보내주게 되었습니다.
- [x] DTO들이 필드를 하나씩만 가지고 있는데, DTO를 쓸 필요가 있을까요?
    - 이전 코드를 작성할 당시에는 DTO에 대해 제대로 이해하지 않고 사용하면서 조금은 무의식적으로 사용했던것 같습니다. 공부를 하고난 뒤 이 부분을 보면서 DTO가 필요한 이유를 고민해봤습니다.
    - DTO가 필드를 하나만 가지고 있더라도 DTO를 이용하여 값을 전달하면 domain에서 데이터를 가져오기 전까지 변조가 되지 않는 장점이 있을 것 같습니다. Contoller에서 View와
      Domain사이에 오가는 데이터를 수정할 이유도 없고 수정해서도 안되기 때문에 DTO로 데이터 불변을 보장하는것이 좋다고 생각됩니다.
- [x] View에서만 사용되는 에러 메시지를 왜 Domain 패키지에 위치한걸까요?
    - 아직 view와 domain의 경계를 구분하지 못하고 있어서 포함시킨 것 같습니다.
    - View에서 발생하는 예외 처리에 사용할 ViewErrorMessage와 domain에서 발생하는 예외 처리에 사용할 DomainErrorMessage로 분리.
- [x] Util 클래스는 어떤 책임을 가져야 할까요?
    - 보통 Util 클래스는 문자열 관련, 랜덤값 구하기, 날짜 및 시간 구하기 등 특정 비지니스 로직이나 독립적인 기능을 한다고 한다.
    - 책임은 어떤 요청에 대해 그 클래스가 꼭 해야하는 일과 같은 개념인 것 같다. 그렇다면 Util 클래스의 책임은 여러 계층에서 사용될 수도 있고 특별한 의존 관계가 없는 일인 것 같다.
    - 그 기준을 아직은 정확하게 잡기는 어렵지만 `java.util` , `java.lang` , `java.time` 패키지들을 사용하는 간단한 동작들을 Util 클래스로 만들어 사용할 수 있을 것 같다.
      예를들어 `java.util.Random`을 사용하여 랜덤값을 만들어내는 경우 `RandomUtil`을 만들어 여러 상황에서의 랜덤값을 얻어올 수 있다. 물론 지금은 `Cars`에서만 자동차 이동을 위해
      0~9까지의 랜덤값을 받아오는 기능을 사용하고 있어서 Util 클래스를 만들지 않고 `Cars`에 직접 구현할수도 있겠지만, 랜덤 값을 만드는 것이 자동차가 할 일인가? 라고 생각하면 아니라고 생각되어서
      `RandomUtil`을 만드는 것이 더 좋을 것 같다. 또 `InputView`에서 자동차의 이름을 받아와서 split하는 메서드가 있는데 이런 것도 `StringUtil` 클래스를 만들어 사용해도 될
      것 같다. 입력을 나누는 일이 `View`의 일인가? 라고 생각하면 아니라고 생각되었기 때문입니다.
    - `RandomUtil`은 시작 숫자와 끝 숫자만을 받아와 그 사이에 랜덤값을 반환하는 기능을 하는 메서드를 가지고 시작 숫자와 끝 숫자는 Cars가 가지도록 수정.
    - `MovementUtil`은 파라미터로 받은 값에 따라 이동할지 말지를 확인하고 있는데 이것은 `Car`에서 하도록 수정.
- [x] 테스트에서만 사용되는 클래스는 test source set에 선언해주면 어떨까요?
- [x] `Integer.parseInt()`가 중복으로 호출되는곳이 있는데, 어떻게 하면 호출을 줄일 수 있을까요?
    - Integer.parseInt()는 내부에서 입력이 숫자가 아니면 알아서 NumberFormatException을 던지는 것 같다.
    - 그래서 validateNumberFormat 메서드는 필요가 없을 것 같다.
    - 하지만 toInteger에서 NumberFormatException이 발생했을 때 원하는 에러 메시지로 예외를 던지고 싶어서 try catch문을 이용했다.
- [x] 어떤 예외를 던지는지 다시 확인해보기
    - 적절한 시점에 예외를 던지는 것도 중요하지만 예외의 종류도 중요합니다. 어떤 예외를 던지느냐에 따라 사용자에게 전달되는 의미가 달라지기 때문입니다.
    - 구현 코드와 테스트 코드 모두 적절한 예외의 종류로 수정
    - 사용자가 입력한 데이터가 잘못된 경우 → `IllegalArgumentException`
    - 찾으려는 데이터가 없는 경우 → `NoSuchElementException`
    - Integer.parseInt()에 문자열을 파라미터로 준 경우 → `NumberFormatException`
- [x] 변수, 클래스, 메서드 명을 전부 다 확인하여 의도에 맞게, 규칙에 맞게 지어졌는지 다시 확인해보기
    - move()에서 파라미터 값의 이름이 `randomNumber`입니다. 꼭 random이어야 할까요? 이것도 잘못된 의도로 이해가 될 수도 있지 않을까요?
    - CarName에서 validEmpty() 메서드 명도 수정해야한다.
    - 메소드 명, 파라미터 명, 변수 명을 수정
- [x] toString()를 어떻게 잘 사용해야할지 고민해자!
    - 수정 전 RoundResult는 내가 정한 규칙으로 반환한 toString()을 이용하여 나만 알수있는 방법으로 데이터를 가져왔던것 같다. 다른 개발자가 이 코드를 본다면 쉽게 이해하기 어려울 수 있을 것
      같다. toString()을 활용하는 방법을 잘못이해했기 때문에 발생한 문제인것같다.
    - "이펙티브 자바의 Item 12"와 여러 블로그에서 toString()에 대해 보면서 toString()은 디버깅을 위해 사용하는 것 외에 사용은 하지않는 것이 좋다고 생각하게 되었다. 그래서 코드 부분과
      테스트에서 toString()을 이용하여 테스트하는 모든 부분을 수정하였다.
    - 처음에 RoundResult에서 toString()으로 데이터를 가져온 이유는 강박적으로 getter를 쓰지 않기위해서 였다. 그런데 조금 더 생각해보니 Car 객체의 이름과 이동 거리를 view에서
      사용하게 되었기 때문에 getter를 써도 될것같다고 생각했다.
    - getter를 쓰지말라는 이유는 getter로 반환된 값을 다른 메서드가 수정하거나 사용하는 로직을 처리하지 말라는 식으로 이해를 했다. 따라서 view에서 사용하기 위해서 getter를 하는것은 허용이
      되지않을까? 라고 생각을 했다.
- [x] Cars를 생성할 때 차가 0개인 경우 Cars가 생성되지 않도록 수정
    - Cars 생성 시 차가 없으면 `IllegalArgumentException` 발생
    - findWinners()를 실행했을 때 차가 없는 경우 `IllegalStateException` 발생
        - 애초에 차가 없었다면 Cars가 생성되지 못 했었을 것이기 때문이다.
    
