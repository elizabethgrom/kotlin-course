// ANSI цвета для консоли
object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
    const val BLACK = "\u001B[30m"

    const val BG_WHITE = "\u001B[47m"
    const val BG_RED = "\u001B[41m"
    const val BG_BLUE = "\u001B[44m"
    const val BG_GREEN = "\u001B[42m"
    const val BG_YELLOW = "\u001B[43m"
}

// ============================================================
// ЗАДАНИЕ 1: ЖИВОТНЫЕ И ИХ ЗВУКИ
// ============================================================
open class Animal(val name: String) {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("${Colors.GREEN}Bark${Colors.RESET}")
    }
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("${Colors.YELLOW}Meow${Colors.RESET}")
    }
}

class Bird(name: String) : Animal(name) {
    override fun makeSound() {
        println("${Colors.CYAN}Tweet${Colors.RESET}")
    }
}

// ============================================================
// ЗАДАНИЕ 2: ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ
// ============================================================
import kotlin.math.PI
import kotlin.math.sin

abstract class Shape {
    open fun area(): Double = 0.0
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = PI * radius * radius
}

class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
}

class Triangle(val a: Double, val b: Double, val angleDegrees: Double) : Shape() {
    override fun area(): Double {
        val angleRadians = Math.toRadians(angleDegrees)
        return 0.5 * a * b * sin(angleRadians)
    }
}

// ============================================================
// ЗАДАНИЕ 3: ПРИНТЕР
// ============================================================
abstract class Printer {
    abstract fun print(text: String)
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
        val words = text.split(" ")
        println("--- Лазерный принтер ---")
        words.forEach { word ->
            // Чёрные буквы на белом фоне
            println("${Colors.BLACK}${Colors.BG_WHITE}$word${Colors.RESET}")
        }
    }
}

class InkjetPrinter : Printer() {
    private val colorPairs = listOf(
        Pair(Colors.RED, Colors.BG_WHITE),
        Pair(Colors.BLUE, Colors.BG_YELLOW),
        Pair(Colors.GREEN, Colors.BG_WHITE),
        Pair(Colors.PURPLE, Colors.BG_GREEN),
        Pair(Colors.CYAN, Colors.BG_RED)
    )

    override fun print(text: String) {
        val words = text.split(" ")
        println("--- Струйный принтер ---")
        words.forEachIndexed { index, word ->
            val (textColor, bgColor) = colorPairs[index % colorPairs.size]
            println("$textColor$bgColor$word${Colors.RESET}")
        }
    }
}

// ============================================================
// ЗАДАНИЕ 4.1: КОРЗИНА ТОВАРОВ (ПЕРЕГРУЗКА МЕТОДОВ)
// ============================================================
class ShoppingCart {
    // ID товара -> количество
    private val items = mutableMapOf<String, Int>()

    // Базовый метод
    fun addToCart(itemId: String) {
        addToCart(itemId, 1)
    }

    // Перегрузка 1: с количеством
    fun addToCart(itemId: String, amount: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + amount
    }

    // Перегрузка 2: со словарём
    fun addToCart(newItems: Map<String, Int>) {
        newItems.forEach { (id, amount) ->
            addToCart(id, amount)
        }
    }

    // Перегрузка 3: со списком
    fun addToCart(itemIds: List<String>) {
        itemIds.forEach { addToCart(it) }
    }

    // Переопределение toString для красивого вывода
    override fun toString(): String {
        if (items.isEmpty()) return "Корзина пуста."

        val sb = StringBuilder()
        sb.appendLine("+----------------+------------+")
        sb.appendLine("| ID товара      | Количество |")
        sb.appendLine("+----------------+------------+")

        var totalItems = 0
        for ((id, count) in items) {
            sb.appendLine(String.format("| %-14s | %10d |", id, count))
            totalItems += count
        }
        sb.appendLine("+----------------+------------+")
        sb.appendLine("Артикулов: ${items.size} | Всего штук: $totalItems")
        return sb.toString()
    }
}

// ============================================================
// ЗАДАНИЕ 4.2: ЛОГГЕР (ПЕРЕГРУЗКА МЕТОДОВ)
// ============================================================
class Logger {
    private val INFO_PREFIX = "${Colors.BLUE}[INFO]${Colors.RESET}"
    private val WARNING_PREFIX = "${Colors.YELLOW}[WARNING]${Colors.RESET}"
    private val ERROR_PREFIX = "${Colors.BG_RED}${Colors.WHITE}[ERROR]${Colors.RESET}"
    private val DEBUG_PREFIX = "${Colors.PURPLE}[DEBUG]${Colors.RESET}"

    // Базовый метод
    fun log(message: String) {
        println("$INFO_PREFIX $message")
    }

    // Перегрузка 1: уровень + сообщение
    fun log(level: String, message: String) {
        when (level.uppercase()) {
            "INFO" -> println("$INFO_PREFIX $message")
            "WARNING" -> println("${Colors.YELLOW}[WARNING] $message${Colors.RESET}")
            "ERROR" -> println("$ERROR_PREFIX $message")
            "DEBUG" -> println("$DEBUG_PREFIX $message")
            else -> println("$INFO_PREFIX $message")
        }
    }

    // Перегрузка 2: список сообщений
    fun log(messages: List<String>) {
        messages.forEach { log(it) }
    }

    // Перегрузка 3: объект Exception
    fun log(exception: Exception) {
        println("$ERROR_PREFIX ${exception.message}")
    }
}

// ============================================================
// ДЕМОНСТРАЦИЯ
// ============================================================
fun main() {
    println("=== ЗАДАНИЕ 1: Животные ===")
    val animals = listOf(Dog("Rex"), Cat("Murka"), Bird("Kesha"), Animal("Unknown"))
    animals.forEach {
        print("${it.name}: ")
        it.makeSound()
    }

    println("\n=== ЗАДАНИЕ 2: Геометрические фигуры ===")
    val shapes = listOf(
        Circle(5.0),
        Square(4.0),
        Triangle(3.0, 4.0, 45.0)
    )
    shapes.forEach { shape ->
        val name = shape::class.simpleName
        println("Площадь $name: ${"%.2f".format(shape.area())}")
    }

    println("\n=== ЗАДАНИЕ 3: Принтеры ===")
    val text = "Переопределение методов в Котлин это очень мощный инструмент ООП"
    val laser = LaserPrinter()
    val inkjet = InkjetPrinter()

    laser.print(text)
    println()
    inkjet.print(text)

    println("\n=== ЗАДАНИЕ 4.1: Корзина ===")
    val cart = ShoppingCart()
    cart.addToCart("Apple")                           // 1 шт
    cart.addToCart("Banana", 3)                       // 3 шт
    cart.addToCart(mapOf("Orange" to 2, "Apple" to 2))// Apple: +2, Orange: +2
    cart.addToCart(listOf("Milk", "Bread", "Milk"))   // Milk: +2, Bread: +1
    println(cart)

    println("=== ЗАДАНИЕ 4.2: Логгер ===")
    val logger = Logger()
    logger.log("Просто сообщение по умолчанию (INFO)")
    logger.log("WARNING", "Внимание: заканчивается место на диске!")
    logger.log("ERROR", "Критическая ошибка базы данных!")
    logger.log("DEBUG", "Отладочная информация: x = 42")
    logger.log(listOf("Первое сообщение из списка", "Второе сообщение из списка"))
    logger.log(Exception("Исключение: NullPointerException"))
}