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

- [x] 입력이 숫자가 아닌 경우 `NumberFormatException`을 throw 한다.
- [x] 입력이 음수인 경우 `IllegalArgumentException`을 throw 한다.

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
    - [x] 이름을 입력하지 않는 경우 -> `NoSuchElementException`
    - [x] 입력한 이름 중 공백이 있는 경우 -> `IllegalArgumentException`
    - [x] 이름이 5자를 넘을 경우 -> `IllegalArgumentException`
    - [x] 중복된 이름을 입력한 경우 -> `IllegalArgumentException`
    - [x] 자동차가 없는데 우승자를 구하는 경우 -> `IllegalStateException`

- [x] 시도할 회수가 잘못된 경우 `RuntimeException`을 throw 한다.
    - [x] 회수가 입력하지 않는 경우 -> `NoSuchElementException`
    - [x] 회수가 숫자가 아닌 경우 -> `IllegalArgumentException`
    - [x] 회수가 음수인 경우 -> `NumberFormatException`

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
    - DTO의 위치를 racingcar 하위로 이동함.
        - DTO는 View, Domain모두에서 사용하기 때문에 domain 패키지 하위에 있을 필요가 없다고 생각했다.
- [x] DTO들이 필드를 하나씩만 가지고 있는데, DTO를 쓸 필요가 있을까요?
    - 이전 코드를 작성할 당시에는 DTO에 대해 제대로 이해하지 않고 사용하면서 조금은 무의식적으로 사용했던것 같습니다. 공부를 하고난 뒤 이 부분을 보면서 DTO가 필요한 이유를 고민해봤습니다.
    - DTO가 필드를 하나만 가지고 있더라도 DTO를 이용하여 값을 전달하면 domain에서 데이터를 가져오기 전까지 변조가 되지 않는 장점이 있을 것 같습니다. Contoller에서 View와
      Domain사이에 오가는 데이터를 수정할 이유도 없고 수정해서도 안되기 때문에 DTO로 데이터 불변을 보장하는것이 좋다고 생각됩니다.
- [x] View에서만 사용되는 에러 메시지를 왜 Domain 패키지에 위치한걸까요?
    - 아직 view와 domain의 경계를 구분하지 못하고 있어서 포함시킨 것 같습니다.
    - View에서 발생하는 예외 처리에 사용할 ViewErrorMessage와 domain에서 발생하는 예외 처리에 사용할 DomainErrorMessage로 분리.
    - 서로 다른 클래스에 이름이 같은 패키지가 위치하면 몇 가지 단점이 있다.
        - 한 코드에서 이들을 함께 사용할 경우 패키지까지 명시해서 구분해야 한다는 점.
        - 이름만 나타내면 실수로 이름이 같은 다른 클래스를 import해서 사용하더라도 실수를 눈치채기 어렵다는 점.
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
    - Util이라는 이름은 어디서든 사용할 수 있다는 느낌이 있기도 하다. 구현 코드에서도 `StringUtil` 은 가장 상위 메서드에 있고 `calculator`와 `racingcar`에서 모두 사용한다.
      이것처럼 여러 클라이언트가 사용하는 코드가 될 수 있기 때문에 많은 주의가 필요하다. 변경이 발생할 경우 파급력이 굉장히 클 수 있기 때문에 변경을 최소화해야 한다.
    - "비지니스 로직"이라고 부를 만큼 중요한 로직이 Util 클래스에 위치하게 된다면 어쩌면 도메인에 그 로직이 위치하기 더 적절한 곳이 있을 수도 있다. 그래서 Util 클래스/메서드를 작성할 때에는
      항상 "이 기능이 정말 Utility 성격인지" 고민해보는 것이 좋다.
    - Util에 어떤 기능을 두어야 하는지 명확한 기준을 세워보는것도 도움이 될 것 같다.
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
    - Cars.findWinners를 자동차가 없는 상태에서 호출하면 stream().max().orElseThrow()에서 예외가 발생 -> `IllegalStateException`
        - 이 상황에서 `IllegalStateException`을 사용하는 것이 맞는걸까?
        - `IllegalStateException`는 호출 시점이 적절하지 않은 경우 발생한다고
          한다. (https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html)
        - 스트림을 close한 다음 읽거나 쓰는 경우 등이 있을 것 같다.
        - 리뷰어님은 비지니스 로직의 전제 조건이 만족되지 않는 경우에 이 예외를 던지기도 한다고 함. 논리적으로는 반드시 존재해야 하는 객체가 실제로는 저장소에 존재하지 않는다거나 하는 경우!
        - 현재 구현 코드의 경우 자동차가 없다면 객체 생성자체가 불가능하고 생성된 후 자동차가 삭제되지도 않기 때문에 findWinners 메서드는 무조건 자동차가 있는 상태에서 호출된다. 그렇다면
          Javadoc에서 설명한 상황과 정확히 맞지는 않지만 리뷰어님의 예시와 비슷한 상황인 것 같아서 사용해도 될 것 같다. 다른 크루들과도 더 이야기해보자.
- [x] 변수, 클래스, 메서드 명을 전부 다 확인하여 의도에 맞게, 규칙에 맞게 지어졌는지 다시 확인해보기
    - move()에서 파라미터 값의 이름이 `randomNumber`입니다. 꼭 random이어야 할까요? 이것도 잘못된 의도로 이해가 될 수도 있지 않을까요?
    - CarName에서 validEmpty() 메서드 명도 수정해야한다.
    - `Attemp`에서 `validate`는 실제로 유효성 검사 뿐만 아니라 문자열 -> 정수 변환도 이루어지고 있음. 한 메서드에서 하나의 일만 하도록 메서드를 메서드를 분리하고 필요없어진 메서드는 삭제.
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
        - Javadoc에서 설명하는 `IllegalStateException`의 발생 상황과 정확히 맞지는 않다. 하지만 RuntimeException의 모든 예외를 확인해봐도 이 예외보다 적절한 예외가
          있는지는 더 고민해봐야 할 것 같다. Random값을 생성하고 검증하는 부분에서도 `IllegalStateException`를 사용하는데 이 상황과 예외에 대해서 다른 크루들과 함께 고민해봐야 할
          것 같다.

## step2 MVC 패턴으로 리팩터링 해보기 피드백 정리 2

- [x] 오류 메시지를 가진 enum이 과연 필요한 것인가? 왜 오류 메시를 사용하는 곳이 아니라 별도의 enum으로 분리했을까요?
    - 오류 메시지를 가진 enum을 왜 사용했는지를 생각해보면 오류가 발생하는 곳에서 사용하기도 하지만 Test코드에서 사용하기 위해 생성한 것 같다. 오류 메시지를 바꾸게 되면 테스트도 바꿔야 하고 구현
      코드도 바꿔야 하네? 왜 두 곳이나 바꿔야 하지? 라는 생각이었다. 더 정확한 테스트를 위해 `hasMessageContaining`을 이용해서 테스트했는데, enum만들고 테스트 코드에서도 get()
      으로 불러오면 되겠다고 짧게 생각했던 것 같다. 지금 다시 생각해보면 몇 가지 문제가 있을 것 같다.

    1. 오류 메시지를 수정해야 한다면 test코드의 수정 없이 enum파일만 수정하면 되기 때문에 test코드가 사실상 의미가 없는 것이 아닌가?
    2. TDD는 test코드를 수정하고 빨간불을 본 뒤 구현 코드를 수정하여 초록불이 되도록 해야 하는데 enum 파일만 수정하면 되기 때문에 TDD의 목적과 정반대가 아닌가?
    3. 지금 enum에서 상수의 이름만 보면 어느 클래스, 어느 위치에서 사용되는지 알기 어렵다.
    4. 오류 메시지를 사용하는 여러 클래스가 하나의 enum에 의존하게 될 것 같은데 코드의 수정을 조심해야 한다거나 다른 클래스의 오류 메시지까지 알게되는 등 문제점이 발생할 수 있지 않을까?

    - 지금 다시 생각해보면 오류 메시지가 바뀌게 된다면 test코드를 고치고 구현 코드를 고치면서 두 곳이 모두 수정되는 것이 맞다고 생각한다. enum이 생기면서 TDD의 목적과도 반대되고 불필요한 의존성까지
      생기기 때문에 이 상황에서는 enum이 꼭 필요한 것은 아니라고 생각된다.

- [x] `RandomNumberGenerator`(`RandomUtil`)에서 `validateRange`만 static으로 선언된 이유가 무엇일까요?
    - 저 부분만 static으로 선언된 이유는 두 가지가 있다.

    1. `RandomNumberGenerator`
       클래스가 [이 코드로 수정되기 전](https://github.com/OzRagwort/java-racingcar/commit/6630f1f20dddeb39ecd4a100ce5784c577934389)
       에는 랜덤값을 생성하는 `generate`역할을 `createNumber`가 했습니다. `createNumber`는 static으로 선언되었는데 수정하는 과정에서 신경쓰지 못했다.
    2. 수정할 때는 아직 static을 왜 쓰는지 잘 이해하지 못하고 그냥 사용했기 때문에 수정해야 할 필요를 못 느꼈다.

    - `RandomNumberGenerator`는 `RandomUtil`로 수정되었지만 모든 필드와 메서드에서 static을 쓰고 있어서 이것이 static을 사용해도 되는지 고민해봤다.
    - static로 선언된 클래스 필드/메서드는 클래스가 생성되어 종료될 때까지 딱 한 번 생성되어 유지된다. 그래서 그것을 사용하는 모든 곳에서 같은 값을 가져야 할 때 사용한다. 따라서 어떤 상태를 가지지
      않을 때 사용할 수 있을 것 같다. 또 수정되면 모든 곳에서 수정이 되기 때문에 수정을 할 때도 많이 조심해야 한다. 그래서 상수는 모든 곳에서 같아야 하고 수정이 되면 안 되기 때문에 static과
      final을 함께 선언한다고 이해했다.
    - `RandomUtil`는 어떤 인스턴스 필드나 메서드가 사용되는 것이 아니기 때문에 static을 사용해도 된다고 생각했다. `Random`이 클래스 필드로 사용되지만 어떤 상태를 가지는 인스턴스 필드가
      아니기 때문에 상관없다고 생각했다.
- [x] 도메인 객체가 모두 `vo` 패키지 내에 있는데 이것들이 정말 VO가 맞는지도 고민해보면 좋겠습니다.
    - VO는 크게 세 가지 특징이 있다고 합니다. [테코블](https://tecoble.techcourse.co.kr/post/2021-05-16-dto-vs-vo-vs-entity/)
      , [블로그](https://velog.io/@livenow/Java-VOValue-Object%EB%9E%80)

    1. setter가 없고 값이 불변해야함. → 재할당하면 안되고 불변성을 가져야함
    2. `equals()`, `hashCode()`를 재정의 해야한다 → 동등성 검사 필요
    3. `validate()`가 있어야 한다. → 자가 유효성 검증이 필요

    - VO에 있는 (`Cars`, `Car`, `CarName`, `Position`, `Attempt`, `RoundResult` ) 중 이런 특징을 가지지 않는 객체는 `RoundResult`
      이다. `RoundResult`는 특성으로 따지면 View로 데이터를 전달하기 위해 만들었기 때문에 DTO쪽에 더 가까운 것 같다. `RoundResult`에서 setter 역할을 하는 `add()`
      를 지우고 생성자에서 결과를 저장하도록 수정하고 DTO 패키지로 이동시켰다.
    - 나머지는 `Cars`를 제외하고 모두 VO가 맞아야 한다. 하지만 구현 코드에서 `Attempt`와 `Position`는 내부의 값이 변한다. `Position`이 가변이면 `Car`도 가변이다. 따라서
      작성한 코드에서 객체들은 아직은 VO가 아니다. 이 객체들을 모두 불변 객체로 만든다면 VO가 된다.
    - 다음은 `Cars`. `Cars`는 일급 컬렉션. 처음에는 구현 코드에서 `Cars`에 있는 코드들은 원래 Service에 있어야 하는 코드이기 때문에 VO가 아닐 수도 있다고 생각했다. 그러나 결국 일급
      컬렉션도 어느 값을 Wrapping한 것이고 값이 불변해야한다는
      글( [일급 컬렉션 (First Class Collection)의 소개와 써야할 이유](https://jojoldu.tistory.com/412) )을 보고 VO인 것 같기도 하다.
    - 하지만 아무리 고민해봐도 `Cars`가 불변해야한다면 일급 컬렉션을 쓰지 않고 구현했을 때 Service에 있을 List<Car>도 불변해야한다는 것인데 정말 그럴필요가 있는지 잘 모르겠다. 그래서 꼭
      완벽한 불변일 필요는 없고 재할당만 방지하면 될 것이라고 생각하여 `Cars`에서 `List<Car>`를 final로 선언하는 정도로 수정했다. 그리고 `Cars`에서 무언가를 반환하는
      경우 `Collections.umodifiableList`를 사용해 반환한 데이터를 수정할 수 없도록 했다. 반환된 List를 수정하려면 `Collections.umodifiableList`때문에 수정이
      되지 않고 각각의 `Car`는 VO로 불변 객체이기 때문에 결국 `Cars`는 재할당만 방지하고 반환값만 잘 관리하면 될 것 같다고 생각했다.
    - 사실 VO가 왜 불변이어야 하는지를 이해하기가 조금 어려웠고 지금도 잘 알고있건지 모르겠다. 이해한 VO가 불변이어야 하는 이유는 의도하지 않은 수정을 막기 위함.
    - VO가 가변이라면 참조 형식으로 객체를 공유하고 값이 수정되면 의도하지 않게 공유한 다른 곳에서도 값이 수정되기 때문이다.
    - 이 부분이 처음에는 이해하기 어려웠는데 얕은 복사, 깊은 복사에서 얕은 복사를 한 객체를 다른곳에서 사용하면 의도치않게 원본도 함께 복사가 되는 상황과 비슷하다고 느끼면서 조금은 이해가 되었다.
- [x] CarsTest에서 회차마다 입력한 자동차의 이름이 결과에 포함되어 있는지를 검증하지만 실제로 각 car들이 이동했는지를 검증하지 않습니다. 이 부분도 테스트하려면 어떻게 해야 할까요?
    - 힌트를 보고도 가장 오래 고민했지만 많이 어려운 문제였습니다. 우선 각 car들이 이동을 했는지를 확인하려면 두 가지 방법이 있을 것 같다.

    1. DTO에 이동에 성공을 했는지 실패했는지 결과를 추가 → 성공, 실패의 결과를 또 어떻게 테스트할지에 대한 문제가 있음
    2. 랜덤값이 아닌 예상가능한 수로 이동을 통제하고 테스트하는 방법

    - 1번보다는 2번이 더 적절한 방법이라고 생각했다.
    - 프리코스 미션에서는 `Mockito`를 사용하여 Randoms 클래스에서 랜덤값을 고정적으로 반환하도록 한다. `Mockito`를 적용해보려 했으나 기존의 코드를 잘 설계하면 `Mockito`없이도
      테스트할 수 있다는 다른 크루의 피드백을 보고 사용하지 않기로 했다.
    - `Mockito`를 사용하지않고 비슷하게 동작하려면 결국 어쩔 수 없이 테스트를 위한 메서드를 만들어야한다고 생각했다. `Cars`에서 모든 차가 경주를 하는 메서드인 `repeatRaceBy`
      메서드에 미리 정한 숫자들을 전달하고 랜덤값 대신 `car.move(int number)`에 파라미터로 주면 결과를 예상할 수 있고 자동차가 제대로 이동하는지 확인할 수
      있다. `RacingGameService`도 테스트용 메서드를 만들어 `RacingGameService`에서도 테스트가 가능하다.
