import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.test.assertEquals
import kotlin.text.*

const val YES = "Yes"
const val NO = "No"
// Complete the appendAndDelete function below.
fun appendAndDelete(s: String, t: String, k: Int): String {
    val longerString: String
    val shorterString: String
    if (s.length > t.length) {
        longerString = s
        shorterString = t
    } else {
        longerString = t
        shorterString = s
    }
    if (k > (shorterString.length + longerString.length)) return YES
    val resultIndexedString = longerString.toCharArray()
    var lastCommonIndex = shorterString.withIndex().indexOfFirst { resultIndexedString[it.index] != it.value } - 1
    if (lastCommonIndex == -2) lastCommonIndex = shorterString.length - 1
    if (lastCommonIndex == shorterString.length - 1
        && (k - (longerString.length - lastCommonIndex - 1)) % 2 == 0
    ) return YES
    val minNumberOfOperations = abs(s.length - lastCommonIndex + t.length - lastCommonIndex - 2)
    if (minNumberOfOperations > k) return NO
    if (minNumberOfOperations == k) return YES
    return NO
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val s = scan.nextLine()
//
//    val t = scan.nextLine()
//
//    val k = scan.nextLine().trim().toInt()

//    val result = appendAndDelete(s, t, k)

    val result1 = appendAndDelete("hackerhappy", "hackerrank", 9)
    val result2 = appendAndDelete("aba", "aba", 2)
    val result3 = appendAndDelete("ashley", "ash", 2)


    assertEquals(YES, result1)
    assertEquals(YES, result2)
    assertEquals(NO, result3)

    val result4 = appendAndDelete("abc", "abcde", 4)
    assertEquals(YES, result4)

    val result5 = appendAndDelete("yuiop", "yuio", 1)
    assertEquals(YES, result5)

    val result6 = appendAndDelete("uiiiii", "ui", 6)
    assertEquals(YES, result6)

    val result7 = appendAndDelete("hhhk", "ui", 13)
    assertEquals(YES, result7)

    val result8 = appendAndDelete("ui", "ui", 2)
    assertEquals(YES, result8)

    val result9 = appendAndDelete("uii", "ui", 5)
    assertEquals(YES, result9)

    val result10 = appendAndDelete("uii", "uiii", 8)
    assertEquals(YES, result10)

    val result11 = appendAndDelete("okuu", "oko", 8)
    assertEquals(YES, result11)

    val result12 = appendAndDelete("oku", "oku", 1)
    assertEquals(NO, result12)

    val result13 = appendAndDelete("okupunktura", "okup", 11)
    assertEquals(YES, result13)

    val result14 = appendAndDelete("123456789", "1", 5)
    assertEquals(NO, result14)

    val result15 = appendAndDelete("010101", "010101", 200)
    assertEquals(YES, result15)

    val result16 = appendAndDelete("010101", "01010", 3333)
    assertEquals(YES, result16)

    val result17 = appendAndDelete("1", "101", 5)
    assertEquals(YES, result17)

    val result18 = appendAndDelete("peek", "seeker", 3)
    assertEquals(NO, result18)

    val result19 = appendAndDelete("y", "yu", 2)
    assertEquals(NO, result19)

    val result20 = appendAndDelete("yuu", "yuu", 1)
    assertEquals(NO, result20)


//    println(result)
}
