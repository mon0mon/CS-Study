package Ch02.Sec09.case_01

import Ch02.Sec09.EggLayable
import Ch02.Sec09.Flyable
import Ch02.Sec09.Tweetable

// 타조 클래스
class Ostich: Tweetable, EggLayable {
    override fun tweet() {
        TODO("Not yet implemented")
    }

    override fun layEgg() {
        TODO("Not yet implemented")
    }
}

// 참새 클래스
class Sparrow: Flyable, Tweetable, EggLayable {
    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun tweet() {
        TODO("Not yet implemented")
    }

    override fun layEgg() {
        TODO("Not yet implemented")
    }
}
