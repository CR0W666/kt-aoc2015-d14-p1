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
		var flying: Int = flightTime
		var resting: Int = restTime
        
        for(i in 0 until seconds) {
            if(flying > 0) {
                dist += maxSpeed
                flying--
            } else {
                resting--
                if(restTime == 0) {
                    flying = flightTime
                    resting = restTime
                }
            }
        }
        
        return dist
    }

}

fun main() {
    val reindeers: List<Reindeer> = createReindeers()
    val times: MutableMap<Reindeer, Int> = race(reindeers)
    val winner = times.maxByOrNull { it.value }

	println("Winner: ${winner!!.key.name} - ${winner!!.value} km")
	
}

fun createReindeers(): List<Reindeer> {
    val reindeers: MutableList<Reindeer> = mutableListOf<Reindeer>()
	
    INPUT.split("\n").forEach {
        val name: String = it.split(" ")[0]
        val stats = it.replace("[^0-9 ]".toRegex(), " ").split(" ").map { it.toIntOrNull() }.filterNotNull()
        
    	reindeers.add(Reindeer(name, stats[0], stats[1], stats[2]))
    }
    
    return reindeers
}

fun race(reindeers: List<Reindeer>): MutableMap<Reindeer, Int> {
    val times: MutableMap<Reindeer, Int> = mutableMapOf<Reindeer, Int>()
    
    reindeers.forEach { times[it] = it.distanceTraveledIn(2503) }
    return times
}
