## 2단계 - 리뷰 요청 - (2)

> 2022.02.19 (토)

---

안녕하세요 희봉 ! 또 만나게 되었군요 .. ㅎㅎ
말씀 주셨던 몇 가지를 반영해보았어요~~!

## 수정한 항목

---

### 1. Comparator를 이용한 구현 및 테스트 케이스 추가

---

이펙티브 자바의 `아이템 14 Comparable 고려` 를 읽고 `Compartor` 를 이용해서 재 구현 해보았어요

오버라이드를 한 메서드 `compareTo` 를 제거하고 이름과 위치에 대한 테스트 코드도 다시 작성해보았어요 (`CarTest`)

덕분에 순서에 대한 것도 제가 수동으로 테스트하는 것이 아닌 테스트 코드가 자동으로 해주네요 .. :)

### 2. Validator 객체로 재 추출

---

이건 `DDD` 에 입각한 사고보다는 테스트 코드를 작성할 때

`Car`에 대한 이름을 검증하는 부분이 `CarsTest` 역할인지 `CarNameTest` 역할인지에 대해 애매했던 부분이 있었어요

검증에 대한 책임을 `CarNameTest`으로 하자니 정작 실제 코드는 `Cars`에 있었고

반대로 `CarsTest`에 두자니 의미상으로는 `CarNameTest`가 그 역할에 가까웠죠..

그래서 아예 `CarNameValidator`로 추출했어요 그랬더니 프로덕션 코드의 책임과 테스트 코드에 대한 책임이 좀더 명확해진 것 같아요

이에 따라 시행횟수인 `TryRoundNumber`도 검증을 담당하는 유틸리티 클래스로 따로 뺴두었습니다 :)

### 3. `RandomMovingStrategy`에 생성은 이제 Cars가 아닌 Application 시작부에

---

`자동차들`에 해당하는 객체인 `Cars`에서 움직임 전략을 생성하는 것이 이상해보였습니다. 때문에 움직임 생성 전략을 `Cars`가 아닌 프로그램의 최상단인 `RacingCarApplication`에서 주입을 시작하는 쪽으로 변경하였어요.

테스트 코드에서는 해당 테스트 클래스가 움직임을 생성하고, 프로덕션은 프로덕션의 시작부인 `Application` 최상단이 맡아서 한다는 느낌으로 코드를 수정한거죠 !

## 문의사항

---

### 1. 이펙티브 자바 ?!

---

희봉은 이펙티브 자바를 어떻게 읽으셨나요??

이 책 아무리 봐도 한 챕터 챕터가 묵~직해서.. 읽히는 부분과 안 읽히는 부분이 골고루 있는데.. ㅎㅎ...

다 읽으신건가요??

원래 이렇게 안 읽히는 부분도 있는 거겠죠? 하하

---

## 2단계 - 리뷰 요청 - (1)

> 2022.2.17 (목)

---

안녕하세요 희봉~!! ..ㅎㅎ 또 리뷰 제출을 하게 되네요 ㅎ
이전 단계에서 워낙 해본 것들이 많아서 (..응?) 이번에는 좀 가다듬는다는 느낌으로 해보았는데 ㅎㅎ
해본 것들은 아래와 같아요 !

## 수정한 목록

---

### 1. Cars 객체를 불변으로 변경

---

아래와 같이 변경했어요 !

> Car

```java
private final List<Car> cars;

...

public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
}
```

### 2. 정규식 컴파일한 것을 캐싱

---

`문자열.matches(정규식)` 이

매번 `Pattern` 를 생성하는데 이게 비용이 많이 든다는 얘기를 듣게 되어..

아래와 같이 캐싱하는 방식으로 변경하였어요 !

> CarName.java

```java
public static final Pattern COMPILED_CAR_NAME_PATTERN = Pattern.compile(NOT_ALLOWED_REGEXP_STRING);

private static boolean doesNotMatchCarName(String carName) {
    return COMPILED_CAR_NAME_PATTERN.matcher(carName).matches();
}
```

## 놓쳤던 리뷰에 대한 리펙터링

---

### 1. `CarController.winners` 를 `private` 으로

---

해당 메서드를 `private`으로 하고 일급컬렉션인 `Cars`에서 책임을 위임받아 작성하였습니다 ㅎ

테스트도 `CarsTest`에서 작성했어요 !

### 2. 메서드 위치 및 공백 라인 제거

---

빌더 패턴을 구현한 `Car` 객체의 메서드 위치를 재조정하였어요 !

잘 보니 `getName` 메서드의 위치만 붕떠보이더라구요..ㅎㅎ... 자세히 봐주시네요 ㅠㅠ
