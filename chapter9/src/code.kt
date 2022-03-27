import java.lang.Appendable
import java.lang.IllegalArgumentException
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
//fun <T> ensureTrailingPeriod(seq: T)
//    where T : CharSequence, T : Appendable { // 타입 파라미터 제약 목록이다
//    if (!seq.endsWith('.')){
//        seq.append('.')
//    }
//}
//fun main() {
//    val helloWorld = StringBuilder("Hello World")
//    ensureTrailingPeriod(helloWorld)
//    println(helloWorld)
//}

// TODO : 리스트 9.5 제네릭 타입으로 타입 캐스팅 하기
//fun printSum(c: Collection<*>) {
//    val intList = c as? List<Int>
//        ?: throw IllegalArgumentException("List is expected")
//    println(intList.sum())
//}
//
//fun main() {
//    printSum(listOf(1, 2, 3))
////    printSum(setOf(1, 2, 3))
//    printSum(listOf("a", "b", "c"))
//}

// TODO : 리스트 9.6 알려진 타입 인자를 사용해 타입 검사하기
//fun printSum(c: Collection<Int>) {
//    if (c is List<Int>) {
//        println(c.sum())
//    }
//}
//
//fun main() {
//    printSum(listOf(1, 2, 3))
//}

// TODO : 리스트 9.7 실체화한 타입 파라미터를 사용하는 함수 정의하기
// fun <T> isA(value: Any) = value is T 이건 컴파일되지 않는다
//inline fun <reified T> isA(value: Any) = value is T
//fun main() {
//    println(isA<String>("abc"))
//    println(isA<String>(123))
//}

// TODO : 리스트 9.8 filterIsInstance 표준 라이브러리 함수 사용하기
//fun main() {
//    val items = listOf("one", 2, "three")
//    println(items.filterIsInstance<String>())
//}

// TODO : 리스트 9.9 filterIsInstance를 간단하게 정리한 버전
//inline fun <reified T> Iterable<*>.filterIsInstance():List<T>{
//    val destination = mutableListOf<T>()
//    for (element in this) {
//        if (element is T) {
//            destination.add(element)
//        }
//    }
//    return destination
//}

// TODO : 리스트의 내용을 출력하는 함수
//fun printContents(list: List<Any>){
//    println(list.joinToString())
//}
//fun main() {
//    printContents(listOf("abc", "bac"))
//}

// TODO : 리스트를 변경하는 다른 함수
//fun addAnswer(list: MutableList<Any>){
//    list.add(42)
//}
//fun main() {
//    val strings = mutableListOf("abc", "bac")
//    addAnswer(strings)
//    strings.maxByOrNull { it.length }
//}

// TODO : 리스트 9.10 어떤 타입이 다른 타입의 하위 탕비인지 검사하기
//fun test(i: Int){
//    val n: Number = i // Int가 Number의 하위 타입이어서 컴파일 됨
//
//    fun f(s: String) { println(s) }
//    f(i) // Int가 String의 하위 타입이 아니어서 컴파일 불가
//}

// TODO : 공변적 선언
//interface Producer<out T>{ // 클래스가 T에 대해 공변적이라고 선언한다
//    fun produce(): T
//}

// TODO : 리스트 9.11 무공변 컬렉션 역할을 하는 클래스 정의하기
//open class Animal {
//    fun feed() { println("feed()") }
//}
//
//class Herd<T: Animal>{ // 이 타입 파라미터를 무공변성으로 지정한다
//    val size: Int get() = 10
//    operator fun get(i: Int): T {
//
//    }
//}
//
//fun feedAll(animals: Herd<Animal>){
//    for (i in 0 until animals.size) {
//        animals[i].feed()
//    }
//}

// TODO : 리스트 9.12 무공변 컬렉션 역할을 하는 클래스 사용하기
//class Cat : Animal(){
//    fun cleanLitter(){}
//}
//fun takeCareOfCats(cats: Herd<Cat>){
//    for (i in 0 until cats.size){
//        cats[i].cleanLitter()
//        feedAll(cats)
//    }
//}

// TODO : 리스트 9.13 공변적 컬렉션 역할을 하는 클래스 사용하기
//open class Animal {
//    fun feed() { println("feed()") }
//}
//
//class Herd<out T: Animal>{ // T는 이제 공변적이다
//    val size: Int get() = 10
//    operator fun get(i: Int): T { }
//}
//
//fun feedAll(animals: Herd<Animal>){
//    for (i in 0 until animals.size) {
//        animals[i].feed()
//    }
//}
//
//class Cat : Animal(){
//    fun cleanLitter(){}
//}
//
//fun takeCareOfCats(cats: Herd<Cat>){
//    for (i in 0 until cats.size){
//        cats[i].cleanLitter()
//    }
//    feedAll(cats) // 캐스팅을 할 필요가 없다
//
//    mutableListOf(1,2,3).add()
//}

// TODO : Comparator<Any>
//fun main() {
//    val anyComparator = Comparator<Any> {
//        e1, e2 -> e1.hashCode() - e2.hashCode()
//    }
//
//    val strings: List<String> = listOf("a","b","c","d")
//    strings.sortedWith(anyComparator)
//    // 문자열과 같은 구체적인 타입의 객체를 비교하기 위해
//    // 모든 객체를 비교하는 Comparator를 사용할 수 있다
//}

// TODO : 리스트 9.14 무공변 파라미터 타입을 사용하는 데이터 복사 함수
//fun <T> copyData(source: MutableList<T>, destination: MutableList<T>){
//    for (item in source){
//        destination.add(item)
//    }
//}

// TODO : 리스트 9.15 타입 파라미터가 둘인 데이터 복사 함수
// source의 원소 타입은 destination 원소 타입의 하위 타입이어야 한다
//fun <T: R, R> copyData(source: MutableList<T>, destination: MutableList<R>){
//    for (item in source){
//        destination.add(item)
//    }
//}
//fun main() {
//    val ints = mutableListOf(1,2,3)
//    val anyItems = mutableListOf<Any>()
//    copyData(ints, anyItems)  // Int는 Any의 하위 타입이므로 이 함수를 호출할 수 있다
//    println(anyItems)
//}

// TODO : 리스트 9.16 아웃-프로젝션 타입 파라미터를 사용하는 데이터 복사 함수
// out 키워드를 붙이면 T타입을 in 위치에 사용하지 않겠다는 뜻이다
//fun <T> copyData(source: MutableList<out T>, destination: MutableList<T>){
//    for (item in source){
//        destination.add(item)
//    }
//}

// TODO : 리스트 9.17 인-프로젝션 타입 파라미터를 사용하는 데이터 복사 함수
fun <T> copyData(source: MutableList<T>, destination: MutableList<in T>){
    for (item in source){
        destination.add(item)
    }
}