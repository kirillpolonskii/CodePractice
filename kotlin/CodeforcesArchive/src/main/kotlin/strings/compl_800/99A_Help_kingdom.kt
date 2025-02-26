package strings.compl_800

fun main(){
    var num: String = readln()
    val dotInd = num.indexOf('.')
    if (num[dotInd - 1] != '9'){
        var lastDigit = num[dotInd - 1].digitToInt()
        if (num[dotInd + 1].digitToInt() in 5..9) {
            ++lastDigit
            num = num.replace( "${num[dotInd - 1]}.", "${lastDigit}.")
        }
        num = num.substring(0, dotInd)
        print(num)
    } else {
        print("GOTO Vasilisa.")
    }
}