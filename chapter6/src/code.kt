import java.io.File

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
//fun ignoreNulls(s: String?){
//    val sNotNull: String = s!!
//    println(sNotNull.length)
//}
//fun main() {
//    ignoreNulls(null)
//}

// TODO : sendEmailTo
//fun sendEmailTo(email: String){
//
//}
//fun main() {
//    val email: String? = "abc@email.com"
//    sendEmailTo(email)
//}

// TODO : 리스트 6.9 let을 사용해 null이 아닌 인자로 함수 호출하기
//fun sendEmailTo(email: String){
//    println("Sending email to $email")
//}
//fun main() {
//    var email: String? = "yole@example.com"
//    email?.let { sendEmailTo(it) }
//
//    email = null
//    email?.let { sendEmailTo(it) }
//}

// TODO : 리스트 6.10 널 아님 단언을 사용해 널이 될 수 있는 프로퍼티 접근하기
//class MyService {
//    fun performAction() : String = "foo"
//}
//class MyTest {
//    private var myService: MyService? = null
//
//    @Before fun setUp(){
//        myService = MyService()
//    }
//
//    @Test fun testAction(){
//        Assert.assertEquals("foo", myService!!.performAction())
//    }
//}

// TODO : 리스트 6.11 나중에 초기화하는 프로퍼티 사용하기
//class MyService {
//    fun performAction() : String = "foo"
//}
//class MyTest {
//    // 초기화하지 않고 널이 될 수 없는 프로퍼티를 선언한다
//    private lateinit var myService: MyService
//
//    @Before fun setUp(){
//        myService = MyService()
//    }
//
//    @Test fun testAction(){
//        // 널 검사를 수행하지 않고 프로퍼티를 사용한다
//        Assert.assertEquals("foo", myService.performAction())
//    }
//}

// TODO : 리스트 6.12 null이 될 수 있는 수신 객체에 대해 확장 함수 호출하기
//fun verifyUserInput(input: String?){
//    if (input.isNullOrBlank()){
//        println("Please fill in the required fields")
//    }
//}
//fun main() {
//    verifyUserInput(" ")
//    verifyUserInput(null)
//}

//data class Person(val name : String, val age : Int)
//fun sendEmailTo(email: String){ println("Sending email to $email") }
//fun main() {
//    val person: Person? = null
//    person?.let { sendEmailTo(it) }
//}

//// TODO : 리스트 6.13 널이 될 수 있는 타입 파라미터 다루기
//fun <T> printlnHashCode(t: T){
//    println(t?.hashCode())
//}
//fun main() {
//    printlnHashCode(null)
//}

// TODO : [리스트 6.14] 타입 파라미터에 대해 널이 될 수 없는 상한을 사용하기
//fun <T: Any> printlnHashCode(t: T){
//    println(t.hashCode())
//}
//fun main() {
////    printlnHashCode(null)
//    printlnHashCode(42)
//}

// TODO : 리스트 6.16 널 검사 없이 자바 클래스 접근하기
//fun yellAt(person: Person){
//    println(person.name.toUpperCase() + "!!!")
//}
//fun main() {
//    yellAt(Person(null))
//}

// TODO : 리스트 6.17 널 검사를 통해 자바 클래스 접근하기
//fun yellAt(person: Person){
//    println((person.name ?: "Anyone").toUpperCase() + "!!!")
//}
//fun main() {
//    yellAt(Person(null))
//}

// TODO : 리스트 6.19 자바 인터페이스를 여러 다른 널 가능성으로 구현하기
//class StringPrinter : StringProcessor{
//    override fun process(value: String) {
//        println(value)
//    }
//}
//
//class NullableStringProcessor : StringProcessor{
//    override fun process(value: String?) {
//        if (value != null){
//            println(value)
//        }
//    }
//}

// TODO : 리스트 6.20 널이 될 수 있는 원시 타입
//data class Person(val name: String, val age: Int? = null){
//    fun isOlderThan(other: Person) : Boolean?{
//        if (age == null || other.age == null)
//            return null
//        return age > other.age
//    }
//}
//
//fun main() {
//    println(Person("Sam", 35).isOlderThan(Person("Amy", 42)))
//    println(Person("Sam", 35).isOlderThan(Person("Jane")))
//}

// TODO : 숫자 리터럴
//fun foo(l: Long) = println(l)
//fun main() {
//    val b: Byte = 1 // 상수 값은 적절한 타입으로 해석된다
//    val l = b + 1L  // +는 Byte와 Long을 인자로 받을 수 있다
//    foo(42) // 컴파일러는 42를 Long값으로 해석한다
//}

// TODO : Unit
//interface Processor<T> {
//    fun process() : T
//}
//class NoResultProcess : Processor<Unit>{
//    // Unit을 반환하지만 타입을 지정할 필요는 없다
//    override fun process() {
//        // 업무 처리 코드
//        // 여기서 return을 명시할 필요가 없다
//    }
//}

// TODO : Nothing
//fun fail(message: String): Nothing{
//    throw IllegalStateException(message)
//}
//fun main() {
//    fail("Error occurred")
//}

// TODO : 리스트 6.21 널이 될 수 있는 값으로 이뤄진 컬렉션 만들기
//fun readNumbers(reader: BufferedReader) : List<Int?>{
//    val result = ArrayList<Int?>()
//    for (line in reader.lineSequence()) {
//        try {
//            val number = line.toInt()
//            // 정수(널이 아닌)를 리스트에 추가한다
//            result.add(number)
//        } catch (e: NumberFormatException){
//            // 현재 줄은 파싱이 불가능 하므로 null을 추가한다
//            result.add(null)
//        }
//    }
//    return result
//}

// TODO : 리스트 6.22 널이 될 수 있는 값으로 이뤄진 컬렉션 다루기
//fun readNumbers(reader: BufferedReader) : List<Int?>{
//    val result = ArrayList<Int?>()
//    for (line in reader.lineSequence()) {
//        try {
//            val number = line.toInt()
//            // 정수(널이 아닌)를 리스트에 추가한다
//            result.add(number)
//        } catch (e: NumberFormatException){
//            // 현재 줄은 파싱이 불가능 하므로 null을 추가한다
//            result.add(null)
//        }
//    }
//    return result
//}
//fun addValidNumbers(numbers: List<Int?>){
//    var sumOfValidNumbers = 0
//    var invalidNumbers = 0
//    for (number in numbers) {
//        if (number != null){
//            sumOfValidNumbers += number
//        } else {
//            invalidNumbers++
//        }
//    }
//
//    println("Sum of valid numbers: $sumOfValidNumbers")
//    println("Invalid numbers: $invalidNumbers")
//}
//fun main() {
//    val reader = BufferedReader(StringReader("1\nabc\n42"))
//    val numbers = readNumbers(reader)
//    addValidNumbers(numbers)
//}
// TODO : 리스트 6.23 filterNotNull를 널이 될 수 있는 값으로 이뤄진 컬렉션에 대해 사용하기
//fun addValidNumbers(numbers: List<Int?>){
//    val validNumbers = numbers.filterNotNull()
//
//    println("Sum of valid numbers: ${validNumbers.sum()}")
//    println("Invalid numbers: ${numbers.size - validNumbers.size}")
//}

// TODO : 리스트 6.24 읽기 전용과 변경 가능한 컬렉션 인터페이스
//fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>){
//    for (item in source) {
//        target.add(item)
//    }
//}
//fun main() {
//    val source : Collection<Int> = arrayListOf(3, 5, 7)
//    val target : MutableCollection<Int> = arrayListOf(1)
//    copyElements(source, target)
//    println(target)
//}

// TODO : 컬렉션 자바/코틀린 혼용
//fun printInUppercase(list: List<String>){
//    println(CollectionUtils.uppercaseAll(list))
//    println(list.first())
//}
//fun main() {
//    val list = listOf<String>("a", "b", "c")
//    printInUppercase(list)
//}

// TODO : 리스트 6.26 FileContentProcessor를 코틀린으로 구현한 모습
//class FileIndexer: FileContentProcessor{
//    override fun processContents(
//        path: File,
//        binaryContents: ByteArray?,
//        textContents: MutableList<String>?
//    ) {
//        // ...
//    }
//}

// TODO : 리스트 6.28 DataParser의 코틀린 구현
//data class Person(val name : String, val age : Int? = null)
//class PersonParser : DataParser<Person>{
//    override fun parseData(
//        input: String,
//        output: MutableList<Person>,
//        errors: MutableList<String?>
//    ) {
//        // ...
//    }
//}

// TODO : 리스트 6.29 배열 사용하기
//fun main(args: Array<String>) {
//    // 배열의 인덱스 값의 범위에 대해 이터레이션 하기 위해
//    // array.indices 확장함수를 사용한다
//    for (i in args.indices) {
//        // array[index]로 인덱스를 사용해 배열 원소에 접근한다
//        println("Argument $i is: ${args[i]}")
//    }
//}

// TODO : 리스트 6.30 알파벳으로 이루어진 배열 만들기
//fun main() {
//    val letters = Array(26) {
//        i -> ('a'+i).toString()
//    }
//    println(letters.joinToString(""))
//}

// TODO : 리스트 6.31 컬렉션을 vararg 메소드에게 넘기기
//fun main() {
//    val strings = listOf("a", "b", "c")
//    // vararg 인자를 넘기기 위해 스프레드 연산자(*)를 써야 한다
//    println("%s/%s/%s".format(*strings.toTypedArray()))
//}

// TODO : 리스트 6.32 배열에 forEachIndexed 사용하기
fun main(args: Array<String>) {
    args.forEachIndexed { index,element ->
        println("Argument $index is: $element")
    }
}