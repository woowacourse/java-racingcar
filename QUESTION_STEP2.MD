## 2단계 - 리뷰 요청

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
