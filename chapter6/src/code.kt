import java.lang.IllegalArgumentException

// TODO : 리스트 6.1 if 검사를 통해 null 값 다루기
//fun strLenSafe(s: String?): Int =
//    if (s != null) s.length else 0
//fun main() {
//    val x: String? = null
//    println(strLenSafe(x))
//    println(strLenSafe("abc"))
//}

// TODO : 리스트 6.2 널이 될 수 있는 프로퍼티를 다루기 위해 안전한 호출 사용하기
//class Employee(val name: String, val manager: Employee?)
//fun managerName(employee: Employee) : String? = employee.manager?.name
//fun main() {
//    val ceo = Employee("Da Boss", null)
//    val developer = Employee("Bob Smith", ceo)
//    println(managerName(developer))
//    println(managerName(ceo))
//}

// TODO : 리스트 6.3 안전한 호출 연쇄시키기
//class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
//class Company(val name: String, val address: Address?)
//class Person(val name: String, val company: Company?)
//fun Person.countryName() : String {
//    val country = this.company?.address?.country
//    return if ( country != null) country else "Unknown"
//}
//fun main() {
//    val person = Person("Dmitry", null)
//    println(person.countryName())
//}

// TODO : 리스트 6.4 엘비스 연산자를 활용해 널 값 다루기
//fun strLenSafe(s: String?): Int = s?.length ?: 0
//fun main() {
//    println(strLenSafe("abc"))
//    println(strLenSafe(null))
//}

// TODO : 리스트 6.5 throw와 엘비스 연산자 함께 사용하기
//class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
//class Company(val name: String, val address: Address?)
//class Person(val name: String, val company: Company?)
//fun printShippingLabel(person: Person){
//    val address = person.company?.address ?: throw IllegalArgumentException("No address")
//    with (address){
//        println(streetAddress)
//        println("$zipCode $city, $country")
//    }
//}
//fun main() {
//    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
//    val jetbrains = Company("JetBrains", address)
//    val person = Person("Dmitry", jetbrains)
//
//    printShippingLabel(person)
//
//    printShippingLabel(Person("Alexey", null))
//}

// TODO : 리스트 6.6 안전한 연산자를 사용해 equals 구현하기
//class Person(val firstName: String, val lastName: String){
//    override fun equals(o: Any?): Boolean {
//       val otherPerson = o as? Person ?: return false
//        return otherPerson.firstName == firstName &&
//                otherPerson.lastName == lastName
//    }
//
//    override fun hashCode(): Int =
//        firstName.hashCode() * 37 + lastName.hashCode()
//}
//
//fun main() {
//    val p1 = Person("Dmitry", "Jemerov")
//    val p2 = Person("Dmitry", "Jemerov")
//    println(p1 == p2)
//    println(p1.equals(42))
//}

// TODO : 리스트 6.7 널 아님 단언 사용하기
fun ignoreNulls(s: String?){
    val sNotNull: String = s!!
    println(sNotNull.length)
}
fun main() {
    ignoreNulls(null)
}