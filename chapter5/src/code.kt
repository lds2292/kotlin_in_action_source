import kotlin.math.max

//data class Person(val name: String, val age: Int)
//fun findTheOldest(people: List<Person>){
//    var maxAge = 0
//    var theOldest : Person? = null
//    for (person in people) {
//        if(person.age > maxAge){
//            maxAge = person.age
//            theOldest = person
//        }
//    }
//    println(theOldest)
//}
//
//fun main() {
//    val people = listOf(Person("Alice",29), Person("Bob",31))
//    people.maxByOrNull() { p: Person -> p.age }
//}

/**
 * 5.1.3
 */
//data class Person(val name: String, val age: Int)
//fun main() {
//    val people = listOf(Person("이몽룡", 29), Person("성춘향",31))
//    val names = people.joinToString(separator = " ", transform = { p: Person -> p.name} )
//    println(names)
//
//    people.joinToString( " ") { p: Person -> p.name }
//
//    people.maxByOrNull { p: Person -> p.age }
//    people.maxByOrNull { p -> p.age }
//
//    people.maxByOrNull { it.age }

//    val sum = {x:Int, y:Int ->
//        println("Computing the sum of $x and $y...")
//        x+y
//    }
//    println(sum(1, 2))
//}

/**
 * 5.1.4
 */
//fun printMessageWithPrefix(message: Collection<String>, prefix: String){
//    // 각 원소에 대해 수행할 작업을 람다로 받는다
//    message.forEach{
//        println("$prefix $it")  // 람다 안에서 함수의 "prefix" 파라미터를 사용한다
//    }
//}
//fun main() {
//    val errors = listOf("403 Forbidden", "404 Not Found")
//    printMessageWithPrefix(errors, "Error:")
//}
//
//fun printProblemCounts(responses: Collection<String>){
//    var clientErrors = 0
//    var serverErrors = 0
//    responses.forEach{
//        if (it.startsWith("4")){
//            clientErrors++
//        } else if (it.startsWith("5")){
//            serverErrors++
//        }
//    }
//    println("$clientErrors client errors, $serverErrors server errors")
//}
//fun main() {
//    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
//    printProblemCounts(responses)
//}

// TODO : Person::age는 다음 람다식을 더 간략하게 표현한 것이다
//class Person(val name:String, val age:Int)
//fun main() {
//    val getAge = { person: Person -> person.age }
//    val getAge2 = Person::age
//}


// TODO : 멤버 참조를 자유롭게 바꿔 쓸 수 있다
//class Person(val name:String, val age:Int)
//fun main() {
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    people.maxByOrNull(Person::age)
//    people.maxByOrNull { p -> p.age }
//    people.maxByOrNull { it.age }
//}

// TODO : 최상위에 선언된 함수나 프로퍼티를 참조할 수도 있다
//fun salute() = println("Salute!")
//fun main() {
//    run(::salute)
//}


// TODO : 람다가 인자라 여럿인 다른 함수에게 작업을 위임하는 경우 람다를 정의하지 않고 직접 위임 함수에 대한 참조를 제공하면 편리
//class Person(val name:String, val age:Int)
//val action = { person:Person, message: String -> sendEmail(person, message)}
//fun sendEmail(person: Person, message: String) : String {
//    return "to ${person.name}, your age ${person.age} and message : $message"
//}
//val nextAction = ::sendEmail

// TODO : 생성자 참조
//data class Person(val name:String, val age:Int)
//
//fun main() {
//    val createPerson = ::Person
//    val p = createPerson("Alice", 29)
//    println(p)
//}

// TODO : 확장 함수도 멤버 함수와 똑같은 방식으로 참조할 수 있다
//data class Person(val name:String, val age:Int)
//fun Person.isAdult() = age >= 21
//fun main() {
//    val predicate = Person::isAdult
//    val p = Person("Alice", 29)
//    predicate(p)
//}

// TODO : 바운드 멤버 참조
//data class Person(val name:String, val age:Int)
//fun main() {
//    val p = Person("Dmitry", 34)
//    val personAgeFunction = Person::age
//    println(personAgeFunction(p))
//
//    val dmitryAgeFunction = p::age
//    println(dmitryAgeFunction())
//}

// TODO : filter 함수
//data class Person(val name:String, val age:Int)
//fun main() {
//    val list = listOf(1,2,3,4)
//    println(list.filter{it % 2 == 0})
//
//    val people = listOf(Person("Alice", 29), Person("Bob",31))
//    println(people.filter { it.age > 30 })
//}

// TODO : map 함수
//data class Person(val name:String, val age:Int)
//fun main() {
//    val list = listOf(1,2,3,4)
//    println(list.map { it * it })
//
//    val people = listOf(Person("Alice", 29), Person("Bob",31))
//
//    println(people.map { it.name })
//    println(people.map(Person::name))
//
//    println(people.filter { it.age > 30 }.map(Person::name))
//
//    people.filter { it.age == people.maxByOrNull(Person::age)!!.age }
//
//    val maxAge = people.maxByOrNull { it.age }!!.age
//    people.filter { it.age == maxAge }
//
//    val numbers = mapOf(0 to "zero", 1 to "one")
//    println(numbers.mapValues { it.value.uppercase() })
//}

// TODO :all, any, count, find 함수
//data class Person(val name:String, val age:Int)
//val canBeInClub27 = { p:Person -> p.age <= 27 }
//fun main() {
//    val people = listOf(Person("Alice", 27), Person("Bob",31))
//    println(people.all(canBeInClub27))
//    println(people.any(canBeInClub27))
//
//    val list = listOf(1, 2, 3)
//    println(!list.all { it == 3 })
//    println(list.any { it != 3 })
//
//    println(people.count(canBeInClub27))
//
//    println(people.find(canBeInClub27))
//}

// TODO : groupBy 함수
//data class Person(val name:String, val age:Int)
//fun main() {
//    val people = listOf(Person("Alice", 31), Person("Bob",29), Person("Carol",31))
//    println(people.groupBy { it.age })
//
//    val list = listOf("a", "ab", "b")
//    println(list.groupBy(String::first))
//}

// TODO : flat과 flatten
class Book(val title: String, val authors: List<String>)
fun main() {
    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf( Book("Thursday Next", listOf("Jasper Fforde")),
                                   Book("Mort", listOf("Terry Pratchett")),
                                   Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")) )
    println(books.flatMap { it.authors }.toSet())

    val list = listOf(listOf(1, 2, 3), listOf(3, 4, 5))
    println(list.flatten().toSet())

}