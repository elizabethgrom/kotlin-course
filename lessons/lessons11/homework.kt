

// 1. Не принимает аргументов и не возвращает значения.
fun doNothing(): Unit { }

// 2. Принимает два целых числа и возвращает их сумму.
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 3. Принимает строку и ничего не возвращает.
fun printString(text: String): Unit {
    println(text)
}

// 4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun average(numbers: List<Int>): Double {
    if (numbers.isEmpty()) return 0.0
    return numbers.sum().toDouble() / numbers.size
}

// 5. Принимает nullable строку и возвращает её длину в виде nullable целого числа,
// доступна только в текущем файле.
private fun lengthOrNull(text: String?): Int? {
    return text?.length
}

// 6. Не принимает аргументов и возвращает nullable вещественное число.
fun getNullableDouble(): Double? {
    return null
}

// 7. Принимает nullable список целых чисел, не возвращает значения,
// доступна только в текущем файле.
private fun processNullableList(list: List<Int>?): Unit {
    list?.forEach { println(it) }
}

// 8. Принимает целое число и возвращает nullable строку.
fun intToStringOrNull(number: Int): String? {
    return if (number >= 0) number.toString() else null
}

// 9. Не принимает аргументов и возвращает список nullable строк.
fun getNullableStringList(): List<String?> {
    return listOf("a", null, "b", null)
}

// 10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun checkBoth(text: String?, number: Int?): Boolean? {
    if (text == null || number == null) return null
    return text.length == number
}

// 1. multiplyByTwo — умножает число на 2
fun multiplyByTwo(number: Int): Int {
    return number * 2
}

// 2. isEven — проверяет чётность числа
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

// 3. printNumbersUntil — выводит числа от 1 до n,
// если n < 1 — прекращает выполнение без вывода
fun printNumbersUntil(n: Int) {
    if (n < 1) return
    for (i in 1..n) {
        println(i)
    }
}

// 4. findFirstNegative — находит первое отрицательное число или null
fun findFirstNegative(numbers: List<Int>): Int? {
    for (num in numbers) {
        if (num < 0) return num
    }
    return null
}

// 5. processList — выводит строки, при встрече null прекращает работу
fun processList(list: List<String?>) {
    for (item in list) {
        if (item == null) return
        println(item)
    }
}

fun main() {
    // Сигнатуры
    doNothing()
    println(sum(3, 5))
    printString("Привет")
    println(average(listOf(1, 2, 3, 4, 5)))
    println(lengthOrNull("Kotlin"))
    println(lengthOrNull(null))
    println(getNullableDouble())
    processNullableList(listOf(1, 2, 3))
    processNullableList(null)
    println(intToStringOrNull(42))
    println(intToStringOrNull(-5))
    println(getNullableStringList())
    println(checkBoth("Hello", 5))
    println(checkBoth(null, 5))

    // Код
    println(multiplyByTwo(7))
    println(isEven(4))
    println(isEven(5))
    printNumbersUntil(3)
    printNumbersUntil(0) // ничего не выведет
    println(findFirstNegative(listOf(1, 2, -3, 4)))
    println(findFirstNegative(listOf(1, 2, 3)))
    processList(listOf("a", "b", null, "c")) // выведет a, b и остановится
}

