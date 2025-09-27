package Ch04.Sec03.Part03.case_01

// 플래그 매개변수 함수 분할 전 적용 방식
fun beforeSplit(userId: Long, courseId: Long, isVip: Boolean) {
    /**
     * 함수를 분할하기 전 방식이 더 유리한 경우는 2가지 케이스 일 때
     * 1. 함수의 영향 범위가 제한된 전용 함수일 경우
     * 2. 분할 후 두 함수가 자주 동시에 호출되는 경우
     */

    // 플래그 매배 변수 사용으로 코드가 더 간결해짐
    buyCourse(userId, courseId, isVip)
}

// 플래그 매개변수 함수 분할 후 적용 방식
fun afterSplit(userId: Long, courseId: Long, isVip: Boolean) {
    if (isVip) {
        buyCourse(userId, courseId)
    } else {
        buyCourseForVip(userId, courseId)
    }
}
