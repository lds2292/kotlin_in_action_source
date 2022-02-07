package com.example.kotlin_in_action.chapter4.code

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.Serializable

// TODO : 리스트 4.1 간단한 인터페이스 선언하기
//interface Clickable {
//    fun click()
//}

// TODO : 리스트 4.2 단순한 인터페이스 구현하기
//interface Clickable {
//    fun click()
//}
//class Button : Clickable {
//    override fun click() = println("I was clicked")
//}
//fun main() {
//    Button().click()
//}

// TODO : 리스트 4.3 인터페이스 안에 본문이 있는 메소드 정의하기
//interface Clickable {
//    fun click()
//    fun showOff() = println("I'm clickable!")
//}

// TODO : 리스트 4.4 동일한 메소드를 구현하는 다른 인터페이스 정의
//interface Focusable {
//    fun setFocus(b: Boolean) =
//        println("I ${if (b) "got" else "lost"} focus.")
//    fun showOff() = println("I'm focusable!")
//}

// TODO : 리스트 4.5 상속한 인터페이스의 메소드 구현 호출하기
//interface Clickable {
//    fun click()
//    fun showOff() = println("I'm clickable!")
//}
//interface Focusable {
//    fun setFocus(b: Boolean) =
//        println("I ${if (b) "got" else "lost"} focus.")
//    fun showOff() = println("I'm focusable!")
//}
//class Button : Clickable, Focusable{
//    override fun click() = println("I was clicked")
//    override fun showOff() {
//        super<Clickable>.showOff()
//        super<Focusable>.showOff()
//    }
//}

// TODO : 리스트 4.6 열린 메소드를 포함하는 열린 클래스 정의하기
//interface Clickable {
//    fun click()
//    fun showOff() = println("I'm clickable!")
//}
//open class RichButton: Clickable {  // 이 클래스는 다른 클래스에서 상속할 수 있다
//    fun disable() {}    // 이 함수는 파이널이다. 하위 클래스가 이 메소드를 오버라이드할 수 없다
//    open fun animate() {}   // 이 함수는 열려있다. 하위 클래스에서 오버라이드 할 수 있다
//    override fun click() {} // 오버라이드한 메소드는 기본적으로 열려있다
//}

// TODO : 리스트 4.7 오버라이드 금지하기
//interface Clickable {
//    fun click()
//}
//open class RichButton : Clickable{
//    final override fun click() {}   // override는 기본적으로 열려있기 때문에 하위클래스에서 상속하지 못하게 하려면
//                                    // final을 붙여야 한다.
//}

// TODO : 리스트 4.8 추상 클래스 정의하기
//abstract class Animated{    // 이클래스는 추상클래스이며 인스턴스를 만들 수 없다
//    abstract fun animate()  // 추상함수는 구현이 없으며, 하위클래스에서 이 메소드를 반드시 오버라이드해야한다
//    open fun stopAnimating(){}  // 비추상 함수는 기본적으로 final 이지만
//    fun animateTwice(){}        // open으로 오버라이드를 허용할 수 있다
//}

// TODO : 리스트 4.9 직렬화할 수 있는, 상태가 있는 뷰 선언
//interface State: Serializable
//interface View{
//    fun getCurrentState():State
//    fun restoreState(state: State){}
//}

// TODO : 리스트 4.10 자바에서 내부 클래스를 사용해 View 구현하기
//public class Button implements View {
//    @Override
//    public State getCurrentState(){
//        return new ButtonState();
//    }
//
//    @Override
//    public void restoreState(state: State){ ... }
//    public class ButtonState implements State { ...}
//}

// TODO : 리스트 4.11 중첩 클래스를 사용해 코틀린에서 View 구현하기
//interface State: Serializable
//interface View{
//    fun getCurrentState():State
//    fun restoreState(state: State){}
//}
//class Button: View {
//    override fun getCurrentState(): State {}
//    override fun restoreState(state: State) {}
//    class ButtonState : State { ... }   // 이 클래스는 자바의 static class와 대응한다
//}

// TODO : 리스트 4.12 인터페이스 구현을 통해 식 표현하기
//interface Expr
//class Num(val value: Int) : Expr
//class Sum(val left:Expr, val right:Expr) : Expr
//fun eval(e: Expr): Int =
//    when (e) {
//        is Num -> e.value
//        is Sum -> eval(e.left) + eval(e.right)
//        else -> // else 분기가 꼭 있어야 한다
//            throw IllegalArgumentException("Unknown expression")
//    }

// TODO : 리스트 4.13 sealed 클래스로 식 표현하기
//sealed class Expr {     // 기반 클래스를 sealed로 봉인한다
//    class Num(val value:Int) : Expr()   // 기반 클래스의 모든 하위 클래스를 중첩 클래스로 나열한다
//    class Sum(val left: Expr, val right:Expr) : Expr()
//}
//fun eval(e: Expr): Int =
//    when (e) {      // when 식이 모든 하위 클래스를 검사하므로 별도의 else 분기가 없어도 된다
//        is Expr.Num -> e.value
//        is Expr.Sum -> eval(e.left) + eval(e.right)
//    }

// TODO : 리스트 4.14 인터페이스의 프로퍼티 구현하기
//interface User {
//    val nickname: String
//}
//class PrivateUser(override val nickname: String) : User
//class SubscribingUser(val email:String)  : User{
//    override val nickname: String
//        get() = email.substringBefore('@')
//}
//class FacebookUser(val accountId: Int): User{
//    override val nickname = getFacebookName(accountId)
//}

// TODO : 리스트 4.15 세터에서 뒷받침하는 필드 접근하기
// 접근자 본문에서는 `field`라는 특별한 식별자를 통해 뒷받침하는 필드에 접근할 수 있다
//class User(val name: String){
//    var address : String = "unspecified"
//        set(value: String){
//            println("""
//                Address was changed for $name:
//                "$field" -> "$value".
//            """.trimIndent())
//            field = value
//        }
//}
//fun main() {
//    val user = User("Alice")
//    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
//}

// TODO : 리스트 4.16 비공개 세터가 있는 프로퍼티 선언하기
//class LengthCounter {
//    var counter: Int = 0
//        private set     // 이 클래스 밖에서 이 프로퍼티의 값을 바꿀 수 없다
//    fun addWord(word: String){
//        counter += word.length
//    }
//}
//fun main() {
//    val lengthCounter = LengthCounter()
//    lengthCounter.addWord("hi!")
//    println(lengthCounter.counter)
//}

// TODO : 리스트 4.17 Client 클래스의 초기 정의
//class Client(val name:String, val postalCode: Int)

// TODO : 리스트 4.18 Client에 toString() 구현하기
//class Client(val name:String, val postalCode:Int){
//    override fun toString(): String = "Client(name=$name, postalCode=$postalCode"
//}

// TODO : 리스트 4.19 Client에 equals() 구현하기
//class Client(val name:String, val postalCode: Int){
//    override fun equals(other: Any?): Boolean {
//        if (other == null || other !is Client)
//            return false
//        return name == other.name && postalCode == other.postalCode
//    }
//    override fun toString(): String = "Client(name=$name, postalCode=$postalCode"
//}

// TODO : 리스트 4.20 Client에 hashCode 구현하기
//class Client(val name: String, val postalCode: Int){
//    override fun equals(other: Any?): Boolean {
//        if (other == null || other !is Client)
//            return false
//        return name == other.name && postalCode == other.postalCode
//    }
//    override fun toString(): String = "Client(name=$name, postalCode=$postalCode"
//    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
//}

// TODO : 리스트 4.21 Client를 데이터 클래스로 선언하기
//data class Client(val name:String, val postalCode: Int)

// TODO : 리스트 4.22 클래스 위임 사용하기
//class CountingSet<T>(
//    val innerSet: MutableCollection<T> = HashSet<T>()
//) : MutableCollection<T> by innerSet {
//    var objectsAdded = 0
//
//    override fun add(element: T): Boolean {
//        objectsAdded++
//        return innerSet.add(element)
//    }
//
//    override fun addAll(elements: Collection<T>): Boolean {
//        objectsAdded += elements.size
//        return innerSet.addAll(elements)
//    }
//}
//
//fun main() {
//    val cset = CountingSet<Int>()
//    cset.addAll(listOf(1,1,2))
//    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
//}

// TODO : 리스트 4.23 객체 선언을 사용해 Comparator 구현하기
//object CaseInsensitiveFileComparator : Comparator<File>{
//    override fun compare(file1: File, file2: File): Int {
//        return file1.path.compareTo(file2.path, ignoreCase = true)
//    }
//}
//fun main() {
//    println(
//        CaseInsensitiveFileComparator.compare(
//            File("/User"), File("/user")
//        )
//    )
//
//    val files = listOf(File("/Z"), File("/a"))
//    println(files.sortedWith(CaseInsensitiveFileComparator))
//
//}

// TODO : 리스트 4.24 중첩 객체를 사용해 Comparator 구현하기
//data class Person(val name:String){
//    object NameComparator : Comparator<Person> {
//        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
//    }
//}
//
//fun main() {
//    val persons = listOf(Person("Bob"), Person("Alice"))
//    println(persons.sortedWith(Person.NameComparator))
//}

// TODO : 리스트 4.25 부 생성자가 여럿 있는 클래스 정의하기
//class User {
//    private val nickname: String
//    constructor(email:String){
//        nickname = email.substringBefore('@')
//    }
//    constructor(facebookAccountId: Int){
//        nickname = getFaceBookName(facebookAccountId)
//    }
//
//    private fun getFaceBookName(facebookAccountId: Int): String {
//        return "Alice"
//    }
//}

// TODO : 리스트 4.26 부 생성자를 팩토리 메소드로 대신하기
//class User private constructor(val nickname: String){
//    companion object{
//        fun newSubscribingUser(email:String) = User(email.substringBefore('@'))
//        fun newFaceBookUser(accountId:Int) = User(getFacebookUser(accountId))
//
//        private fun getFacebookUser(accountId: Int): String {
//            return "Alice"
//        }
//    }
//}
//
//fun main() {
//    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
//    val facebookUser = User.newFaceBookUser(4)
//
//    println(subscribingUser.nickname)
//    println(facebookUser.nickname)
//}

// TODO : 리스트 4.27 동반 객체에 이름 붙이기
//class Person(val name:String){
//    companion object Loader {
//        // 동반객체에 이름을 붙인다
//        fun fromJSON(jsonText:String): Person{
//            return Person(jsonText)
//        }
//    }
//}
//
//fun main() {
//    val person = Person.Loader.fromJSON("{name:'Dmitry'}")
//    person.name
//
//    val person2 = Person.fromJSON("{name:'Dmitry'}")
//    person.name
//}

// TODO : 리스트 4.28 동반 객체에서 인터페이스 구현하기
//interface JSONFactory<T>{
//    fun fromJSON(jsonText: String) : T
//}
//class Person(val name:String){
//    companion object : JSONFactory<Person>{
//        override fun fromJSON(jsonText: String): Person {
//            return Person("Person $jsonText")
//        }
//    }
//}
//class Animal(val name:String){
//    companion object : JSONFactory<Animal>{
//        override fun fromJSON(jsonText: String): Animal {
//            return Animal("Animal $jsonText")
//        }
//    }
//}
//
//fun <T> loadFromJSON(factory: JSONFactory<T>) : T {
//    return factory.fromJSON("Bob")
//}
//
//fun main() {
//    println(loadFromJSON(Person).name)
//    println(loadFromJSON(Animal).name)
//}

// TODO : 리스트 4.29 동반 객체에 대한 확장 함수 정의하기
//// 비즈니스 로직 모듈
//class Person(val firstName:String, val lastName:String){
//    // 비어있는 동반 객체를 선언한다
//    companion object{}
//}
//
//// 클라이언트/서버 통신 모듈
//// 확장 함수를 선언한다
//fun Person.Companion.fromJSON(json:String) : Person{
//    return Person("firstName $json", "lastName $json")
//}
//
//fun main() {
//    val p = Person.fromJSON("Alice")
//    println(p.firstName)
//    println(p.lastName)
//}

//val listener = object : MouseAdapter(){
//    override fun mouseClicked(e: MouseEvent) { ... }
//    override fun mouseEntered(e: MouseEvent) { ... }
//}

// TODO : 리스트 4.31 무명 객체 안에서 로컬 변수 사용하기
//fun countClicks(window: Window){
//    var clickCount = 0
//    window.addMouseListener(object : MouseAdapter() {
//        override fun mouseClicked(e: MouseEvent?) {
//            clickCount++
//            super.mouseClicked(e)
//        }
//    })
//}