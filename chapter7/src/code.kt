import java.math.BigDecimal
import java.math.BigInteger

// data class Point(val x:Int, val y:Int)

// TODO : 리스트 7.1 plus 연산자 구현하기
//data class Point(val x:Int, val y:Int){
//    operator fun plus(other: Point) : Point {
//        return Point(x + other.x, y + other.y)
//    }
//}
//fun main() {
//    val p1 = Point(10, 20)
//    val p2 = Point(30, 40)
//    println(p1 + p2)
//}

// TODO: 리스트 7.2 연산자를 확장 함수로 정의하기
//data class Point(val x:Int, val y:Int)
//operator fun Point.plus(other : Point): Point {
//    return Point(x + other.x, y + other.y)
//}

// TODO : 리스트 7.3 두 피연산자의 타입이 다른 연산자 정의하기
//data class Point(val x:Int, val y:Int)
//operator fun Point.times(scale: Double): Point {
//    return Point((x * scale).toInt(), (y * scale).toInt())
//}
//fun main() {
//    val p = Point(10, 20)
//    println(p * 1.5)
//}

// TODO : 리스트 7.4 결과 타입이 피연산자 타입과 다른 연산자 정의하기
//operator fun Char.times(count: Int): String{
//    return toString().repeat(count)
//}
//fun main() {
//    println('a' * 3)
//}

// TODO : plusAssign
//operator fun <T> MutableCollection<T>.plusAssign(element: T){
//    this.add(element)
//}
//fun main() {
//    val numbers = ArrayList<Int>()
//    numbers += 42
//    println(numbers[0])
//}

// TODO : collection plusAssign
//fun main() {
//    val list = arrayListOf(1, 2)
//    list += 3   // +=는 "list"를 변경한다
//    val newList = list + listOf(4, 5)   // +는 두 리스트의 모든 우너소를 포함하는 새로운 리스트를 반환한다
//
//    println(list)
//    println(newList)
//}

// TODO : 리스트 7.5 단항 연산자 정의하기
//data class Point(val x:Int, val y:Int)
//operator fun Point.unaryMinus(): Point {
//    return Point(-x, -y)
//}
//fun main() {
//    val p = Point(10, 20)
//    println(-p)
//}

// TODO : 리스트 7.6 증가 연산자 정의하기
//operator fun BigDecimal.inc() = this + BigDecimal.ONE
//fun main() {
//    var bd = BigDecimal.ZERO
//    println(bd++)
//    println(++bd)
//}

// TODO : 리스트 7.7 equals 메소드 구현하기
class Point(val x:Int, val y:Int){
    override fun equals(obj: Any?): Boolean {
        if (obj == this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }
}
