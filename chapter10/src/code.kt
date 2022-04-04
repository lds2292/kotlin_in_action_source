import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

//interface Company {
//    val name: String
//}
//
//data class CompanyImpl(override val name: String):Company
//
//data class Person(
//    val name: String,
//    @DeserializeInterface(CompanyImpl::class) val company: Company
//)
//
//annotation class DeserializeInterface(val targetClass: KClass<out Any>)

//interface ValueSerializer<T> {
//    fun toJsonValue(value: T): Any?
//    fun fromJson(jsonValue: Any?): T
//}
//
//data class Person(
//    val name: String,
//    @CustomSerializer(DateSerializer::class) val birthDate: Date
//)
//
//annotation class CustomSerializer(
//    val serializerClass: KClass<out ValueSerializer<*>>
//)

//import kotlin.reflect.full.*
//
//class Person(val name: String, val age: Int)
//
//fun main() {
//    val person = Person("Alice", 29)
//    val kClass = person.javaClass.kotlin
//    println(kClass.simpleName)
//    kClass.memberProperties.forEach {
//        println(it.name)
//    }
//}

//fun foo(x: Int) = println(x)
//val kFunction = ::foo
//fun main() {
//    kFunction.call(42)
//}

//import kotlin.reflect.KFunction2
//
//fun sum(x: Int, y: Int) = x+y
//val kFunction: KFunction2<Int, Int, Int> = ::sum
//fun main() {
//    println(kFunction.invoke(1, 2) + kFunction(3, 4))
//
//    kFunction(1)
//}

//var counter = 0
//fun main() {
//    val kProperty = ::counter
//    kProperty.setter.call(21)
//    println(kProperty.get())
//}

//class Person(val name: String, val age: Int)
//
//fun main() {
//    val person = Person("Alice", 29)
//    val memberProperty = Person::age
//    println(memberProperty.get(person))
//}

// TODO : 리스트 10.1 객체 직렬화하기
//private fun StringBuilder.serializeObject(obj: Any){
//    // 객체의 KClass를 얻는다
//    val kClass = obj.javaClass.kotlin
//    // 클래스의 모든 프로퍼티를 얻는다
//    val properties = kClass.memberProperties
//    properties.joinToStringBuilder(
//        this, prefix="{", postfix="}"){ prop ->
//        // 프로퍼티 이름을 얻는다
//        serializeString(prop.name)
//        append(": ")
//        // 프로퍼티 값을 얻는다
//        serializePropertyValue(prop.get(obj))
//    }
//}

// TODO : 리스트 10.2 프로퍼티 필터링을 포함하는 객체 직렬화
//annotation class JsonExclude
//private fun StringBuilder.serializeObject(obj: Any){
//    obj.javaClass.kotlin.memberProperties
//        .filter { it.findAnnotation<JsonExclude>() == null }
//        .jsonToStringBuilder(this, prefix="{", postfix="}"){
//            serializeProperty(it, obj)
//        }
//}

// TODO : 리스트 10.3 프로퍼티 직렬화하기
//annotation class JsonName(val name: String)
//private fun StringBuilder.serializeProperty(
//    prop: KProperty1<Any, *>, obj: Any
//){
//    val jsonNameAnn =  prop.findAnnotation<JsonName>()
//    val propName = jsonNameAnn?.name ?: prop.name
//    serializeString(propName)
//    append(": ")
//    serializePropertyValue(prop.get(obj))
//}


//annotation class CustomSerializer(val serializerClass: KClass<out ValueSerializer<*>>)
//data class Person(
//    val name: String,
//    @CustomSerializer(DateSerializer::class) val birthDate: Date
//)


// TODO : 리스트 10.4 프로퍼티의 값을 직렬화하는 직렬화기 가져오기
//fun KProperty<*>.getSerializer() : ValueSerializer<Any?>{
//    val customSerializerAnn = findAnnotation<CustomSerializer>() ?: return null
//    val serializerClass = customSerializerAnn.serializerClass
//    val valueSerializer = serializerClass.objectInstance
//        ?: serializerClass.createInstance()
//    return valueSerializer as ValueSerializer<Any?>
//}

// TODO : 리스트 10.5 커스텀 직렬화기를 지원하는 프로퍼티 직렬화 함수
private fun StringBuilder.serializeProperty(
    prop: KProperty1<Any, *>, obj: Any
){
    val name =  prop.findAnnotation<JsonName>()?.name ?: prop.name
    serializeString(name)
    append(": ")
    val value = prop.get(obj)
    // 커스텀 직렬화가 없다면 일반적인 방법에 따라 프로퍼티를 직렬화 한다
    val jsonValue  = prop.getSerializer()?.toJsonValue(value) ?: value
    serializePropertyValue(prop.get(obj))
}