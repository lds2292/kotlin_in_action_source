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

fun printProblemCounts(responses: Collection<String>){
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach{
        if (it.startsWith("4")){
            clientErrors++
        } else if (it.startsWith("5")){
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}
fun main() {
    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)
}