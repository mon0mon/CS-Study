package Ch03.Sec04.Part02.case_02

class Statistics (
    val max: Long,
    val min: Long,
    val average: Long,
    val sum: Long,
    val percentile99: Long,
    val percentile999: Long
)

// 인터페이스 분리 원칙에 따라, 단위 메소드는 독립적인 통계 기능을 제공하도록 수정
// 단일로 된 거대한 메소드보다, 작은 단위의 메소드로 분리
fun max(dataSet: Collection<Long>): Long = TODO()
fun min(dataSet: Collection<Long>): Long = TODO()
fun average(dataSet: Collection<Long>): Long = TODO()
