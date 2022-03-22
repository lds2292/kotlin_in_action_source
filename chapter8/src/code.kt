import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock

// TODO : 리스트 8.1 간단한 고차 함수 정의하기
//fun twoAndThree(operation: (Int, Int) -> Int) {
//    val result = operation(2, 3)
//    println("The result is $result")
//}
//
//fun main() {
//    twoAndThree { a, b -> a + b }
//    twoAndThree { a, b -> a * b }
//}


// TODO : 리스트 8.2 filter 함수를 단순하게 만든 버전 구하기
//fun String.filter(predicate: (Char)->Boolean): String{
//    val sb = StringBuilder()
//    for(index in 0 until length){
//        val element = get(index)
//        if (predicate(element)) sb.append(element)
//    }
//    return sb.toString()
//}
//fun main() {
//    println("ab1c".filter { it in 'a'..'z' })
//}

// TODO : 자바에서 코틀린 함수 사용
//fun processTheAnswer(f: (Int) -> Int){
//    println(f(42))
//}

// TODO : 리스트 8.3 하드 코딩을 통해 toString 사용 관례를 따르는 joinToString
//fun <T> Collection<T>.joinToString(
//    separator: String = ", ",
//    prefix: String = "",
//    postfix: String = ""
//) : String {
//    val result = StringBuilder(prefix)
//    for ((index, element) in this.withIndex()){
//        if (index > 0) result.append(separator)
//        result.append(element)
//    }
//    result.append(postfix)
//    return result.toString()
//}

// TODO : 리스트 8.4 함수 타입의 파라미터에 대한 디폴트 값 지정하기
//fun <T> Collection<T>.joinToString(
//    separator: String = ", ",
//    prefix: String = "",
//    postfix: String = "",
//    transform: (T) -> String = { it.toString() }
//) : String {
//    val result = StringBuilder(prefix)
//    for ((index, element) in this.withIndex()){
//        if (index > 0) result.append(separator)
//        result.append(transform(element))
//    }
//    result.append(postfix)
//    return result.toString()
//}
//fun main() {
//    val letters = listOf("Alpha", "Beta")
//    println(letters.joinToString())
//    println(letters.joinToString { it.lowercase() })
//    println(letters.joinToString(spearator = "! ", postfix = "! ", transform = { it.uppercase()}))
//}

// TODO : 리스트 8.5 널이 될 수 있는 함수 타입 파라미터 사용하기
//fun <T> Collection<T>.joinToString(
//    separator: String = ", ",
//    prefix: String = "",
//    postfix: String = "",
//    transform: ((T) -> String)? = null
//) : String {
//    val result = StringBuilder(prefix)
//    for ((index, element) in this.withIndex()){
//        if (index > 0) result.append(separator)
//        val str = transform?.invoke(element)?:element.toString()
//        result.append(str)
//    }
//    result.append(postfix)
//    return result.toString()
//}

// TODO : 리스트 8.6 함수를 반환하는 함수 정의하기
//enum class Delivery { STANDARD, EXPEDITED }
//class Order(val itemCount: Int)
//fun getShippingCostCalculator(delivery: Delivery) : (Order) -> Double {
//    if (delivery == Delivery.EXPEDITED){
//        return { order -> 6 + 2.1 * order.itemCount}
//    }
//    return { order -> 1.2 * order.itemCount}
//}
//fun main() {
//    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
//    println("Shipping costs ${calculator(Order(3))}")
//}

// TODO : 리스트 8.7 함수를 반환하는 함수를 UI 코드에서 사용하기
//data class Person(
//    val firstName : String,
//    val lastName : String,
//    val phoneNumber : String?
//)
//
//class ContactListFilters{
//    var prefix: String = ""
//    var onlyWithPhoneNumber: Boolean = false
//    fun getPredicate(): (Person) -> Boolean{
//        val startsWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)}
//        if (!onlyWithPhoneNumber){
//            return startsWithPrefix
//        }
//        return { startsWithPrefix(it) && it.phoneNumber != null}
//    }
//}
//
//fun main() {
//    val contacts = listOf(
//        Person("Dmitry", "Jemerov", "123-4567"),
//        Person("Svetlana", "Isakova", null)
//    )
//
//    val contactListFilters = ContactListFilters()
//    with(contactListFilters){
//        prefix = "Dm"
//        onlyWithPhoneNumber = true
//    }
//    println(contacts.filter(contactListFilters.getPredicate()))
//}

// TODO : 리스트 8.8 사이트 방문 데이터 정의
data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

// TODO : 리스트 8.9 사이트 방문 데이터를 하드 코딩한 필터를 사용해 분석하기
//fun main() {
//    val averageWindowsDuration =
//        log.filter { it.os == OS.WINDOWS }
//            .map(SiteVisit::duration)
//            .average()
//    println(averageWindowsDuration)
//}

// TODO : 리스트 8.10 일반 함수를 통해 중복 제거하기
//fun List<SiteVisit>.averageDurationFor(os: OS) =
//    filter { it.os == os }.map(SiteVisit::duration).average()
//
//fun main() {
//    println(log.averageDurationFor(OS.WINDOWS))
//    println(log.averageDurationFor(OS.MAC))
//}

// TODO : 리스트 8.11 복잡하게 하드코딩한 필터를 사용해 방문 데이터 분석하기
//fun main() {
//    val averageWindowsDuration =
//        log.filter { it.os in setOf(OS.IOS, OS.ANDROID) }
//            .map(SiteVisit::duration)
//            .average()
//    println(averageWindowsDuration)
//}

// TODO : 리스트 8.12 고차 함수를 사용해 중복 제거하기
//fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
//    filter(predicate).map(SiteVisit::duration).average()
//
//fun main() {
//    println(log.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) })
//    println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })
//}

// TODO : 리스트 8.13 인라인 함수 정의하기
//inline fun <T> synchronized(lock: Lock, action: () -> T) : T {
//    lock.lock()
//    try {
//        return action()
//    } finally {
//        lock.unlock()
//    }
//}
//fun foo(l:Lock){
//    println("Before sync")
//    synchronized(l){
//        println("Action")
//    }
//    println("After sync")
//}

// TODO : 리스트 8.14 람다를 사용해 컬렉션 거르기
//data class Person(val name: String, val age: Int)
//fun main() {
//    val people = listOf(Person("Alice", 29), Person("Bob",31))
//    println(people.filter { it.age < 30 })
//}

// TODO : 리스트 8.15 컬렉션을 직접 거르기
//data class Person(val name: String, val age: Int)
//fun main() {
//    val people = listOf(Person("Alice", 29), Person("Bob",31))
//    val result = mutableListOf<Person>()
//    for (person in people) {
//        if (person.age < 30) result.add(person)
//    }
//    println(result)
//}

// TODO : 리스트 8.17 use 함수를 자원 관리에 활용하기
//fun readFirstLineFromFile(path: String): String {
//    // BufferedReader 객체를 만들고 "use"함수를 호출하면서 파일에 대한 연산을 실행할 람다를 넘긴다
//    BufferedReader(FileReader(path)).use { br ->
//        return br.readLine()
//    }
//}

// TODO : 리스트 8.18 일반 루프 안에서 return 사용하기
//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Alice", 29), Person("Bob",31))
//fun lookForAlice(people: List<Person>){
//    for (person in people) {
//        if (person.name == "Alice"){
//            println("Found!")
//            return
//        }
//    }
//    println("Alice is not found")
//}
//fun main() {
//    lookForAlice(people)
//}

// TODO : 리스트 8.19 forEach에 전달된 람다에서 return 사용하기
//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Alice", 29), Person("Bob",31))
//fun lookForAlice(people: List<Person>){
//    people.forEach{
//        if (it.name == "Alice"){
//            println("Found!")
//            return
//        }
//    }
//    println("Alice is not Found")
//}
//fun main() {
//    lookForAlice(people)
//}

// TODO : 리스트 8.20 레이블을 통해 로컬 리턴 사용하기
//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Alice", 29), Person("Bob",31))
//fun lookForAlice(people: List<Person>){
//    people.forEach label@{ // 람다식 앞에 레이블을 붙인다
//        if (it.name == "Alice"){
//            return@label  // return@label은 앞에서 정의한 레이블을 참조한다
//        }
//    }
//    println("Alice might be somewhere") // 항상 이 줄이 출력된다
//}
//fun main() {
//    lookForAlice(people)
//}

// TODO : 리스트 8.21 함수 이름을 return 레이블로 사용하기
//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Alice", 29), Person("Bob",31))
//fun lookForAlice(people: List<Person>){
//    people.forEach{ // 람다식 앞에 레이블을 붙인다
//        if (it.name == "Alice"){
//            return@forEach  // return@label은 앞에서 정의한 레이블을 참조한다
//        }
//    }
//    println("Alice might be somewhere") // 항상 이 줄이 출력된다
//}
//fun main() {
//    lookForAlice(people)
//}

// TODO : 리스트 8.22 무명 함수안에서 return 사용하기
//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Alice", 29), Person("Bob",31))
//fun lookForAlice(people: List<Person>){
//    people.forEach(fun (person){ // 람다 식 대신 무명 함수를 사용한다
//        if (person.name == "Alice") return // "return"은 가장 가까운 함수를 가리키는데 이 위치에서 가장 가까운 함수는 무명함수다
//        println("${person.name} is not Alice")
//    })
//}
//fun main() {
//    lookForAlice(people)
//}

// TODO : 리스트 8.23 filter에 무명 함수 넘기기
//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Alice", 29), Person("Bob",31))
//fun main() {
//    people.filter(fun (person):Boolean{
//        return person.age > 30
//    })
//}
// TODO : 리스트 8.24 식이 본문인 무명 함수 사용하기
//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Alice", 29), Person("Bob",31))
//fun main() {
//    people.filter(fun (person) = person.age < 30)
//}