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
//class Point(val x:Int, val y:Int){
//    override fun equals(obj: Any?): Boolean {
//        if (obj == this) return true
//        if (obj !is Point) return false
//        return obj.x == x && obj.y == y
//    }
//}

// TODO : 리스트 7.8 compareTo 메소드 구현하기
//class Person(val firstName:String, val lastName: String) : Comparable<Person>{
//    override fun compareTo(other: Person): Int {
//        return compareValuesBy(this, other, Person::lastName, Person::firstName)
//    }
//}
//fun main() {
//    val p1 = Person("Alice", "Smith")
//    val p2 = Person("Bob", "Johnson")
//    println(p1 < p2)
//}

// TODO : 리스트 7.9 get 관례 구현하기
//class Point(val x:Int, val y:Int)
//operator fun Point.get(index: Int): Int {
//    return when(index){
//        0 -> x
//        1 -> y
//        else ->
//            throw IndexOutOfBoundsException("Invalid coordinate $index")
//    }
//}
//fun main() {
//    val p = Point(10, 20)
//    println(p[1])
//}

// TODO : 리스트 7.10 관례를 따르는 set 구현하기
//data class MutablePoint(var x: Int, var y: Int)
//operator fun MutablePoint.set(index: Int, value: Int) {
//    when (index) {
//        0 -> x = value
//        1 -> y = value
//        else ->
//            throw IndexOutOfBoundsException("Invalid coordinate $index")
//    }
//}
//fun main() {
//    val p = MutablePoint(10, 20)
//    p[1] = 42
//    println(p)
//}

// TODO : 리스트 7.11 in 관례 구현하기
//class Point(val x: Int, val y: Int)
//data class Rectangle(val upperLeft: Point, val lowerRight: Point)
//operator fun Rectangle.contains(p: Point): Boolean {
//    return p.x in upperLeft.x until lowerRight.x &&
//            p.y in upperLeft.y until lowerRight.y
//}
//
//fun main() {
//    val rect = Rectangle(Point(10, 20), Point(50, 50))
//    println(Point(20, 30) in rect)
//    println(Point(5, 5) in rect)
//}

// TODO : 리스트 7.12 날짜의 범위 다루기
//fun main() {
//    val now = LocalDate.now()
//    // 오늘부터 시작해 10일짜리 범위를 만든다
//    val vacation = now..now.plusDays(10)
//    // 특정 날짜가 날짜 범위 안에 들어가는지 검사한다
//    println(now.plusWeeks(1) in vacation)
//
//}

// TODO : 리스트 7.13 날짜 범위에 대한 이터레이터 구현하기
//operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
//    object : Iterator<LocalDate> {
//        var current = start
//        override fun hasNext() =
//            current <= endInclusive
//
//        override fun next() = current.apply {
//            current = plusDays(1)
//        }
//    }
//
//fun main() {
//    val newYear = LocalDate.ofYearDay(2017, 1)
//    val daysOff = newYear.minusDays(1)..newYear
//    for (dayOff in daysOff) { println(dayOff) }
//}

//TODO : 구조분해 선언
//data class Point(val x: Int, val y: Int)
//class Point(val x: Int, val y: Int) {
//    operator fun component1() = x
//    operator fun component2() = y
//}
//
//fun main() {
//    val p = Point(10, 20)
//    val (x, y) = p
//    println(x)
//    println(y)
//}

// TODO : 리스트 7.14 구조 분해 선언을 사용해 여러 값 반환하기
//data class NameComponents(val name: String, val extension: String)
//fun splitFileName(fullName: String): NameComponents{
//    val result = fullName.split('.', limit = 2)
//    return NameComponents(result[0], result[1])
//}
//fun main() {
//    val (name, ext) = splitFileName("example.kt")
//    println(name)
//    println(ext)
//}

// TODO : 리스트 7.15 컬렉션에 대해 구조 분해 선언 사용하기
//data class NameComponents(val name: String, val extension: String)
//fun splitFileName(fullName: String): NameComponents{
//    val (name, extension) = fullName.split('.', limit = 2)
//    return NameComponents(name, extension)
//}

// TODO : 리스트 7.16 구조 분해 선언을 사용해 맵 이터레이션
//fun printEntries(map: Map<String, String>){
//    for ((key, value) in map){
//        println("$key -> $value")
//    }
//}
//fun main() {
//    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
//    printEntries(map)
//}

// TODO : 위임프로퍼티
//class Delegate {
//    operator fun getValue(...) {...}
//    operator fun setValue(..., value: Type) {...}
//}
//
//class Foo {
//    var p: Type by Delegate()  // by 키워드는 프로퍼티와 위임 객체를 연결한다
//}

// TODO : 리스트 7.17 지연 초기화를 뒷받침하는 프로퍼티를 통해 구현하기
//fun loadEmails(person: Person):List<Email>{
//    println("${person.name}의 이메일을 가져옴")
//    return listOf()
//}
//data class Email(val subject: String, val contents: String)
//class Person(val name: String){
//    private var _emails: List<Email>? = null
//    val emails: List<Email>
//        get() {
//            if (_emails == null){
//                _emails = loadEmails(this)
//            }
//            return _emails!!
//        }
//}
//
//fun main() {
//    val p = Person("Alice")
//    p.emails
//    p.emails
//}

// TODO : 리스트 7.18 지연 초기화를 위임 프로퍼티를 통해 구현하기
//fun loadEmails(person: Person):List<Email>{
//    println("${person.name}의 이메일을 가져옴")
//    return listOf()
//}
//data class Email(val subject: String, val contents: String)
//class Person(val name: String){
//    val emails by lazy { loadEmails(this) }
//}
//fun main() {
//    val p = Person("Alice")
//    p.emails
//    p.emails
//}

// TODO : 리스트 7.19 PropertyChangeSupport를 사용하기 위한 도우미 클래스
//open class PropertyChangeAware{
//    protected val changeSupport = PropertyChangeSupport(this)
//
//    fun addPropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.addPropertyChangeListener(listener)
//    }
//
//    fun removePropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.removePropertyChangeListener(listener)
//    }
//}

// TODO : 리스트 7.20 프로퍼티 변경 통지를 직접 구현하기
//open class PropertyChangeAware{
//    protected val changeSupport = PropertyChangeSupport(this)
//
//    fun addPropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.addPropertyChangeListener(listener)
//    }
//
//    fun removePropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.removePropertyChangeListener(listener)
//    }
//}
//class Person(val name: String, age:Int, salary:Int) : PropertyChangeAware(){
//    var age: Int = age
//        set(newValue){
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange("age", oldValue, newValue)
//        }
//    var salary: Int = salary
//        set(newValue){
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange("salary", oldValue, newValue)
//        }
//}
//
//fun main() {
//    val p = Person("Dmitry",  34, 2000)
//    p.addPropertyChangeListener(
//        PropertyChangeListener { evt ->
//            println("Property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
//        }
//    )
//    p.age = 35
//    p.salary = 2100
//}

// TODO : 리스트 7.21 도우미 클래스를 통해 프로퍼티 변경 통지 구현하기
//open class PropertyChangeAware{
//    protected val changeSupport = PropertyChangeSupport(this)
//
//    fun addPropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.addPropertyChangeListener(listener)
//    }
//
//    fun removePropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.removePropertyChangeListener(listener)
//    }
//}
//class ObservableProperty(
//    val propName: String,
//    var propValue: Int,
//    val changeSupport: PropertyChangeSupport
//){
//    fun getValue(): Int = propValue
//    fun setValue(newValue: Int){
//        val oldValue = propValue
//        propValue = newValue
//        changeSupport.firePropertyChange(propName, oldValue, newValue)
//    }
//}
//class Person(
//    val name: String, age: Int, salary: Int
//) : PropertyChangeAware(){
//    val _age = ObservableProperty("age", age, changeSupport)
//    var age: Int
//        get() = _age.getValue()
//        set(value) { _age.setValue(value) }
//
//    val _salary = ObservableProperty("salary", salary, changeSupport)
//    var salary: Int
//        get() = _salary.getValue()
//        set(value) {_salary.setValue(value)}
//}
//fun main() {
//    val p = Person("Dmitry",  34, 2000)
//    p.addPropertyChangeListener(
//        PropertyChangeListener { evt ->
//            println("Property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
//        }
//    )
//    p.age = 36
//    p.salary = 2100
//}

// TODO : 리스트 7.22 ObservableProperty를 프로퍼티 위임에 사용할 수 있게 바꾼 모습
//class ObservableProperty(
//    var propValue: Int,
//    val changeSupport: PropertyChangeSupport
//){
//    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue
//    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int){
//        val oldValue = propValue
//        propValue = newValue
//        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
//    }
//}

// TODO : 리스트 7.23 위임 프로퍼티를 통해 프로퍼티 변경 통지 받기
//open class PropertyChangeAware{
//    protected val changeSupport = PropertyChangeSupport(this)
//
//    fun addPropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.addPropertyChangeListener(listener)
//    }
//
//    fun removePropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.removePropertyChangeListener(listener)
//    }
//}
//
//class ObservableProperty(
//    var propValue: Int,
//    val changeSupport: PropertyChangeSupport
//) {
//    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue
//    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int) {
//        val oldValue = propValue
//        propValue = newValue
//        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
//    }
//}
//
//class Person(
//    val name: String, age: Int, salary: Int
//) : PropertyChangeAware(){
//    var age : Int by ObservableProperty(age, changeSupport)
//    var salary: Int by ObservableProperty(salary, changeSupport)
//}

// TODO : 리스트 7.24 Delegate.observable을 사용해 프로퍼티 변경 통지 구현하기
//open class PropertyChangeAware{
//    protected val changeSupport = PropertyChangeSupport(this)
//    fun addPropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.addPropertyChangeListener(listener)
//    }
//
//    fun removePropertyChangeListener(listener: PropertyChangeListener){
//        changeSupport.removePropertyChangeListener(listener)
//    }
//}
//
//class Person(
//    val name: String, age: Int, salary: Int
//) : PropertyChangeAware(){
//    private val observer = {
//        prop: KProperty<*>, oldValue:Int, newValue:Int ->
//        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
//    }
//    var age: Int by Delegates.observable(age, observer)
//    var salary: Int by Delegates.observable(salary, observer)
//}
//
//fun main() {
//    val p = Person("Dmitry",  34, 2000)
//    p.addPropertyChangeListener(
//        PropertyChangeListener { evt ->
//            println("Property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
//        }
//    )
//    p.age = 36
//    p.salary = 2100
//}

// TODO : 리스트 7.25 값을 맵에 저장하는 프로퍼티 정의하기
//class Person{
//    // 추가 정보
//    private val _attributes = hashMapOf<String, String>()
//    fun setAttribute(attrName: String, value: String){
//        _attributes[attrName] = value
//    }
//
//    // 필수 정보
//    val name: String
//        get() = _attributes["name"]!!
//}
//
//fun main() {
//    val p = Person()
//    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
//    for ((attrName, value) in data) {
//        p.setAttribute(attrName, value)
//    }
//    println(p.name)
//}

// TODO : 리스트 7.26 값을 맵에 저장하는 위임 프로퍼티 사용하기
//class Person{
//    private val _attributes = hashMapOf<String, String>()
//    fun setAttribute(attrName: String, value: String){
//        _attributes[attrName] = value
//    }
//
//    // 위임 프로퍼티로 맵을 사용한다
//    val name: String by _attributes
//}

// TODO : 리스트 7.27 위임 프로퍼티를 사용해 데이터베이스 칼럼 접근하기
object Users : IdTable(){   // 객체는 데이터베이스 테이블에 해당한다
    // 프로퍼티는 테이블 칼럼에 해당한다
    val name = varchar("name", length = 50).index()
    val age = integer("age")
}

// 각 User 인스턴스는 테이블에 들어있는 구체적인 엔티티에 해당한다
class User(id: EntityID) : Entity(id){
    // 사용자 이름은 데이터베이스 "name"칼럼에 들어있다
    var name: String by Users.name
    var age: Int by Users.age
}