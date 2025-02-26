package greedy.compl_800

fun main(){
    val n = readln().toInt()
    var curWaitingPpl = 0
    repeat(n){
        val event = readln()
        val eventVal = event.substring(2).toInt()
        if (event[0] == 'P'){
            curWaitingPpl += eventVal
        }
        else {
            val curFreeSeats = if (eventVal >= curWaitingPpl) eventVal - curWaitingPpl else 0
            curWaitingPpl = if (eventVal <= curWaitingPpl) curWaitingPpl - eventVal else 0
            if (curFreeSeats > 0){
                println("YES")
            }
            else {
                println("NO")
            }
        }
    }
}