fun main() {
    // 1
    try {
        null!!
    } catch (e: NullPointerException) {
        println("It is NullPointerException! \uD83C\uDF89")
    }
// 2
    try {
        listOf("")[1]
    } catch (e: IndexOutOfBoundsException) {
        println("It is IndexOutOfBoundsException! \uD83C\uDF89")
    }
// 3
    try {
        "" as Int
    } catch (e: ClassCastException) {
        println("It is ClassCastException! \uD83C\uDF89")
    }
// 4
    try {
        require(false)
    } catch (e: IllegalArgumentException) {
        println("It is IllegalArgumentException! \uD83C\uDF89")
    }
// 5
    try {
        "".toInt()
    } catch (e: NumberFormatException) {
        println("It is NumberFormatException! \uD83C\uDF89")
    }
// 6
    try {
        check(false)
    } catch (e: IllegalStateException) {
        println("It is IllegalStateException! \uD83C\uDF89")
    }
// 7
    try {
        (0..Long.MAX_VALUE).map { Long.MAX_VALUE }
    } catch (e: OutOfMemoryError) {
        println("It is OutOfMemoryError! \uD83C\uDF89")
    }
// 8
    try {
        a()
    } catch (e: StackOverflowError) {
        println("It is StackOverflowError! \uD83C\uDF89")
    }
}

fun a() {
    a()
}
Задача 10

fun catchable(arg: Any?) {
    try {
        arg!!
        arg as List<*>
        arg[2]
        require(arg[2] is String)
        check((arg[2] as String).toInt() == 3)
    } catch (e: Throwable) {
        val result = when (e) {
            is NullPointerException -> "It is NullPointerException"
            is ClassCastException -> "It is ClassCastException"
            is IndexOutOfBoundsException -> "It is IndexOutOfBoundsException"
            is NumberFormatException -> "It is NumberFormatException"
            is IllegalArgumentException -> "It is IllegalArgumentException"
            is IllegalStateException -> "It is IllegalStateException"
            else -> "It is unknown exception"
        }
        println(result)
        throw e
    }
    println("We have a fantastically good argument!")
}
Варианты проверки функции

fun main() {
//    catchable(null)
//    catchable("WTF?")
//    catchable(listOf(""))
//    catchable(listOf(1, 2, 3))
//    catchable(listOf(1, 2, "WTF?"))
    catchable(listOf(1, 2, "3"))
}
Задача 11

class MyAssertionError(message: String) : AssertionError(message)

fun main() {
    throw MyAssertionError("Алярм!!")
}
Задача 12

class MyRuntimeException(cause: IndexOutOfBoundsException) : RuntimeException(cause)

fun main() {
    try {
        listOf("")[1]
    } catch (e: IndexOutOfBoundsException) {
        println("Произошёл IndexOutOfBoundsException")
        throw MyRuntimeException(e)
    }
}