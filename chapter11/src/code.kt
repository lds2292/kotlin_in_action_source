import kotlin.text.StringBuilder

// TODO : 리스트 11.1 람다를 인자로 받는 buildString() 정의하기
//fun buildString(
//    // 함수타입인 파라미터를 정의한다
//    builderAction: (StringBuilder) -> Unit
//) : String {
//    val sb = StringBuilder()
//    // 람다 인자로 StringBuilder 인스턴스를 넘긴다
//    builderAction(sb)
//    return sb.toString()
//}
//
//fun main() {
//    val s = buildString {
//        // "it" StringBuilder 인스턴스를 가리킨다
//        it.append("Hello, ")
//        it.append("World!")
//    }
//}

// TODO : 리스트 11.2 수신 객체 지정 람다를 사용해 다시 정의한 buildString()
//fun buildString(
//    // 수신 객체가 있는 함수 타입의 파라미터를 선언한다
//    builderAction: StringBuilder.() -> Unit
//) : String {
//    val sb = StringBuilder()
//    // StringBuilder 인스턴스를 람다의 수신 객체로 넘긴다
//    sb.builderAction()
//    return sb.toString()
//}
//
//fun main() {
//    val s = buildString {
//        // this 키워드는 StringBuilder 인스턴스를 가리킨다
//        this.append("Hello, ")
//        // this를 생략해도 묵시적으로 StringBuilder 인스턴스가 수신 객체로 취급된다
//        append("World!")
//    }
//}

// TODO : 리스트 11.3 수신 객체 지정 람다를 변수에 저장하기
fun main() {
    // appendExcl은 확장 함수 타입의 값이다
    val appendExcl : StringBuilder.() -> Unit = { this.append("!") }
    val stringBuilder = StringBuilder("Hi")
    // appendExcl을 확장 함수처럼 호출할 수 있다
    stringBuilder.appendExcl()
    println(stringBuilder)
    // appendExcl을 인자로 넘길 수 있다
    println(buildString(appendExcl))
}