import java.lang.Appendable
import java.lang.StringBuilder

// TODO : 리스트 9.1 제네릭 함수 호출하기
//fun main() {
//    val letters = ('a'..'z').toList()
//    println(letters.slice<Char>(0..2)) // 타입 인자를 명시적으로 지정한다
//    println(letters.slice(10..13)) // 컴파일러는 여기서 T가 Char라는 사실을 추론한다
//}

// TODO : 리스트 9.2 제네릭 고차 함수 호출하기
//fun <T> List<T>.filter(predicate: (T) -> Boolean):List<T>{}
//fun main() {
//    val authors = listOf("Dmitry", "Svetlana")
//    val readers = mutableListOf<String>()
//    readers.filter { it !in authors }
//}

// TODO : 제네릭 확장 프로퍼티
//val <T> List<T>.penultimate: T
//    get() = this[size - 2]
//fun main() {
//    println(listOf(1, 2, 3, 4).penultimate)
//}

// TODO : 리스트 9.3 타입 파라미터를 제약하는 함수 선언하기
//fun <T: Comparable<T>> max(first: T, second: T): T {
//    return if (first > second) first else second
//}
//fun main() {
//    println(max("kotlin", "java"))
//    println(max("kotlin", 42))
//}

// TODO : 리스트 9.4 타입 파라미터에 여러 제약을 가하기
fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T : Appendable { // 타입 파라미터 제약 목록이다
    if (!seq.endsWith('.')){
        seq.append('.')
    }
}
fun main() {
    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}