val INPUT: String = "Rudolph can fly 22 km/s for 8 seconds, but then must rest for 165 seconds.\n"+
"Cupid can fly 8 km/s for 17 seconds, but then must rest for 114 seconds.\n"+
"Prancer can fly 18 km/s for 6 seconds, but then must rest for 103 seconds.\n"+
"Donner can fly 25 km/s for 6 seconds, but then must rest for 145 seconds.\n"+
"Dasher can fly 11 km/s for 12 seconds, but then must rest for 125 seconds.\n"+
"Comet can fly 21 km/s for 6 seconds, but then must rest for 121 seconds.\n"+
"Blitzen can fly 18 km/s for 3 seconds, but then must rest for 50 seconds.\n"+
"Vixen can fly 20 km/s for 4 seconds, but then must rest for 75 seconds.\n"+
"Dancer can fly 7 km/s for 20 seconds, but then must rest for 119 seconds."



class Reindeer(val name: String, val maxSpeed: Int, val flightTime: Int, val restTime: Int) {
    
    fun distanceTraveledIn(seconds: Int): Int {
        var dist: Int = 0
        var secsPast: Int = 0
        for (iter: Int in 1..seconds) {
            if(iter < secsPast) continue
            if(secsPast > flightTime) secsPast += restTime
            dist += maxSpeed
        }

        return dist
    }

}

fun main() {
    val reindeers: List<Reindeer> = createReindeers()
    val times: MutableMap<Reindeer, Int> = race(reindeers)


}

fun createReindeers(): List<Reindeer> {
    var clean = INPUT.split("\n").forEach {
        val name: String = it.split(" ")[0]
        val dataa = INPUT.replace("[^0-9 ]".toRegex(), " ").split(" ").filterNot {it.chars().toArray().asList().contains(' ')}.asSequence().toList()
        println(dataa)
    }
    var reindeers: MutableList<Reindeer> = mutableListOf<Reindeer>()
    return listOf(Reindeer("temp", 22, 6, 50))
}

fun race(reindeers: List<Reindeer>): MutableMap<Reindeer, Int> {
    val times: MutableMap<Reindeer, Int> = mutableMapOf<Reindeer, Int>()
    for(reindeer: Reindeer in reindeers) times[reindeer] = reindeer.distanceTraveledIn(2503)
    return times
}

