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
fun processTheAnswer(f: (Int) -> Int){
    println(f(42))
}