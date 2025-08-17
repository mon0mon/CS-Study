package Ch02.Sec09.case_02

import Ch02.Sec09.EggLayable
import Ch02.Sec09.Flyable
import Ch02.Sec09.Tweetable

class FlyAbility: Flyable {
    override fun fly() {
        TODO("Not yet implemented")
    }
}

class TweetAbility: Tweetable {
    override fun tweet() {
        TODO("Not yet implemented")
    }
}

class EggLayAbility: EggLayable {
    override fun layEgg() {
        TODO("Not yet implemented")
    }
}

class Ostrich(
    private val tweetAbility: TweetAbility,
    private val eggLayAbility: EggLayAbility
) : Tweetable by tweetAbility, EggLayable by eggLayAbility
