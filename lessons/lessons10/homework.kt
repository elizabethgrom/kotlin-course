fun main() {
    // 1. Пустой неизменяемый словарь (Int -> Int)
    val emptyMap: Map<Int, Int> = emptyMap()

    // 2. Словарь, ключи - Float, значения - Double
    val floatDoubleMap = mapOf(
        1.1f to 10.5,
        2.2f to 20.7,
        3.3f to 30.9
    )

    // 3. Изменяемый словарь: ключи - Int, значения - String
    val mutableMap = mutableMapOf(
        1 to "Один",
        2 to "Два",
        3 to "Три"
    )

    // 4. Добавление новых пар
    mutableMap[4] = "Четыре"
    mutableMap[5] = "Пять"
    println("После добавления: $mutableMap")

    // 5. Извлечение значения по ключу + попытка получить отсутствующий ключ
    println("Ключ 2: ${mutableMap[2]}")
    println("Ключ 99: ${mutableMap[99]}") // вернёт null
    // Безопасный вариант:
    println("Ключ 99 (getOrDefault): ${mutableMap.getOrDefault(99, "не найдено")}")

    // 6. Удаление элемента по ключу
    mutableMap.remove(3)
    println("После удаления ключа 3: $mutableMap")

    // 7. Словарь (Double -> Int), вывод результата деления ключа на значение
    val divisionMap = mapOf(
        10.0 to 2,
        20.0 to 5,
        5.0 to 0 // деление на 0
    )
    for ((key, value) in divisionMap) {
        if (value == 0) {
            println("$key / $value = бесконечность")
        } else {
            println("$key / $value = ${key / value}")
        }
    }

    // 8. Изменение значения существующего ключа
    val editable = mutableMapOf(1 to "A", 2 to "B", 3 to "C")
    editable[2] = "Новое значение"
    println("После изменения: $editable")

    // 9. Объединение двух словарей в третий через циклы
    val mapA = mapOf(1 to "Один", 2 to "Два")
    val mapB = mapOf(3 to "Три", 4 to "Четыре")
    val mergedMap = mutableMapOf<Int, String>()
    for ((k, v) in mapA) mergedMap[k] = v
    for ((k, v) in mapB) mergedMap[k] = v
    println("Объединённый словарь: $mergedMap")

    // 10. Словарь: String -> MutableList<Int>
    val listMap = mutableMapOf<String, MutableList<Int>>()
    listMap["чётные"] = mutableListOf(2, 4, 6)
    listMap["нечётные"] = mutableListOf(1, 3, 5)
    listMap["десятки"] = mutableListOf(10, 20)
    println("Словарь со списками: $listMap")

    // 11. Словарь: Int -> MutableSet<String>
    val setMap = mutableMapOf<Int, MutableSet<String>>()
    setMap[1] = mutableSetOf("Kotlin", "Java")
    setMap[2] = mutableSetOf("Python", "Go")
    // Получаем значение по ключу и добавляем строку
    setMap[1]?.add("Scala")
    println("Множество по ключу 1: ${setMap[1]}")

    // 12. Словарь с ключами-парами чисел
    val pairMap = mapOf(
        Pair(1, 2) to "Первый",
        Pair(5, 7) to "Второй",
        Pair(3, 5) to "Третий",
        Pair(8, 9) to "Четвёртый"
    )
    for ((pair, value) in pairMap) {
        if (pair.first == 5 || pair.second == 5) {
            println("Найдено значение: $value для пары $pair")
        }
    }
}

val library: Map<String, List<String>> = mapOf(
    "Толстой" to listOf("Война и мир", "Анна Каренина"),
    "Достоевский" to listOf("Преступление и наказание", "Идиот"),
    "Булгаков" to listOf("Мастер и Маргарита", "Собачье сердце")
)

val plants: Map<String, List<String>> = mapOf(
    "Цветы" to listOf("Роза", "Тюльпан", "Ромашка"),
    "Деревья" to listOf("Дуб", "Берёза", "Сосна"),
    "Кустарники" to listOf("Сирень", "Шиповник")
)

val teams: Map<String, List<String>> = mapOf(
    "Спартак" to listOf("Иванов", "Петров", "Сидоров"),
    "ЦСКА" to listOf("Кузнецов", "Смирнов", "Попов"),
    "Зенит" to listOf("Морозов", "Волков", "Соколов")
)

val treatment: Map<String, List<String>> = mapOf(
    "2024-01-01" to listOf("Аспирин", "Витамин C"),
    "2024-01-02" to listOf("Антибиотик", "Пробиотик"),
    "2024-01-03" to listOf("Витамин D")
)

val travel: Map<String, Map<String, List<String>>> = mapOf(
    "Франция" to mapOf(
        "Париж" to listOf("Эйфелева башня", "Лувр", "Нотр-Дам"),
        "Ницца" to listOf("Английская набережная", "Старый город")
    ),
    "Италия" to mapOf(
        "Рим" to listOf("Колизей", "Фонтан Треви", "Ватикан"),
        "Венеция" to listOf("Площадь Сан-Марко", "Гранд-канал")
    ),
    "Япония" to mapOf(
        "Токио" to listOf("Токийская башня", "Синдзюку", "Асакуса"),
        "Киото" to listOf("Золотой павильон", "Фусими Инари")
    )
)

