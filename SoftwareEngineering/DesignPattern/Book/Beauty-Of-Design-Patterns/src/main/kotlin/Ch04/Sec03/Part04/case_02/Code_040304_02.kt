package Ch04.Sec03.Part04.case_02

// 두 번째 예제
fun matchStrings(strList: List<String?>, subStr: String): List<String> {
    val matchedStrings = mutableListOf<String>()

    for (str in strList) {
        // 이 if문은 다음 if문과 통합이 가능하다
        if (str != null) {
            if (str.contains(subStr)) {
                matchedStrings.add(str)
            }
        }
    }

    return matchedStrings
}

// 1차 리팩토링
fun matchString1(strList: List<String?>, subStr: String): List<String> {
    val matchedStrings = mutableListOf<String>()

    for (str in strList) {
        // continue, break, return을 사용하여 중첩을 바로 종료
        if (str == null || !str.contains(subStr)) {
            continue
        }

        matchedStrings.add(str)
    }

    return matchedStrings
}

// 2차 리팩토링
fun matchString2(strList: List<String?>, subStr: String): List<String> {
    val matchedStrings = mutableListOf<String>()

    // 책에서는 null 여부를 조회하지만, 이미 non null 데이터 타입이고,
    // forEach로 빈 컬렉션은 스킵되기 때문에 리팩토링 할 내용이 없음
    for (str in strList) {
        if (str == null || !str.contains(subStr)) {
            continue
        }

        matchedStrings.add(str)
    }

    return matchedStrings
}

// 3차 리팩토링
fun matchString3(strList: List<String?>, subStr: String): List<String> {
    // 코틀린 함수형 프로그래밍 인터페이스 사용
    return strList.filterNotNull().filter { it.contains(subStr) }
}

