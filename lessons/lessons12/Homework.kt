

//Задачи на приведение коллекции к значению

//1.Проверить, что размер коллекции больше 5 элементов.
//2.Проверить, что коллекция пустая
//3.Проверить, что коллекция не пустая
//4.Взять элемент по индексу или создать значение если индекса не существует
//5.Собрать коллекцию в строку
//6.Посчитать сумму всех значений
//7.Посчитать среднее
//8.Взять максимальное число
//9.Взять минимальное число
//10.Взять первое число или null
//11.Проверить что коллекция содержит элемент

//Реши задачи подходящим методом для работы с коллекцией. Для каждой задачи есть свой метод, не повторяйся.
// Список методов в рекомендациях под заданиями.


//1
if (numbers.contains(5>..)) {
    print("Размер коллекции болшьше 5 элементов")
} else {
    print("Размер коллекции меньше 5 элементов")
}

//2
if (numbers.isEmpty()) {
    println("Коллекция пуста")
} else {
    println("В коллекции ${numbers.size} значений")
}

//3
if (numbers.isEmpty()) {
    println("Коллекция что-то содержит")
} else {
    println("В коллекции ${numbers.size} значений")
}

//4
val element = numbers.getOrElse(10) { -1 }
println(element)
// -1  (индекса 10 нет)

//5
val text = numbers.joinToString(separator = ", ")
println(text)

//6
val sumOfNumbers = numbers.sum()
println(sumOfNumbers)


//7
val averageOfNumbers = numbers.average()
println(averageOfNumbers)


//8
val maxNumber = numbers.maxOrNull()
println(maxNumber)

//9
val minNumber = numbers.minOrNull()
println(minNumber)


//10
val setOfNumbers = setOf(8, 6, 7, -22, 3)
val firstElement = setOfNumbers.first()
println(firstElement)

//11
println(numbers.contains(8))
println(numbers.contains(67))



//Задачи на обработку коллекций

//1.Отфильтровать коллекцию по диапазону 18-30
//2.Выбрать числа, которые не делятся на 2 и 3 одновременно
//3.Очистить текстовую коллекцию от null элементов
//4.Преобразовать текстовую коллекцию в коллекцию длин слов
//5.Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
//6.Отсортировать список в алфавитном порядке
//7.Взять первые 3 элемента списка
//8.Распечатать квадраты элементов списка
//9.Группировать список по первой букве слов
//10.Очистить список от дублей
//11.Отсортировать список по убыванию
//12.Взять последние 3 элемента списка
//13.Реши задачи ниже в отдельных функциях.

//1
fun filter(collection: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in collection) {
        if (i in 15..89) result.add(i)
    }
    return result
}

//2
fun notdelid2And3(numbers: List<Int>): List<Int> {
    return numbers.filterNot { it % 2 == 0 && it % 3 == 0 }
}

//3
fun removeNulls(words: List<String?>): List<String> {
    return words.filterNotNull()
}

//4
fun wordsToLengths(words: List<String>): List<Int> {
    return words.map { it.length }
}

//5
fun wordsToReversedMap(words: List<String>): Map<String, Int> {
    return words.associate { it.reversed() to it.length }
}

//6
fun sortAlphabetically(words: List<String>): List<String> {
    return words.sorted()
}

//7
fun sortAlphabetically(words: List<String>): List<String> {
    return words.sorted()
}

//8
fun printSquares(numbers: List<Int>) {
    numbers.forEach { println(it * it) }
}

//9
fun groupByFirstLetter(words: List<String>): Map<Char, List<String>> {
    return words.groupBy { it.first() }
}

//10
fun removeDuplicates(numbers: List<Int>): List<Int> {
    return numbers.distinct()
}

//11
fun sortDescending(numbers: List<Int>): List<Int> {
    return numbers.sortedDescending()
}

//12
fun lastThree(numbers: List<Int>): List<Int> {
    return numbers.takeLast(3)
}


//Задача 24. Характеристика числовой коллекции
//Напиши функцию, которая принимает коллекцию чисел и возвращает строку с характеристикой коллекции используя конструкцию when
//
//Если коллекция пустая - “Пусто”
//Если количество элементов меньше пяти - “Короткая”
//Если коллекция начинается с 0 - “Стартовая”
//Если сумма всех чисел больше 10000 - “Массивная”
//Если среднее значение равно 10 - “Сбалансированная”
//Если длина строки образованная склеиванием коллекции в строку равна 20 - “Клейкая”
//Если максимальное число меньше -10 - “Отрицательная”
//Если минимальное число больше 1000 - “Положительная”
//Если содержит одновременно числа 3 и 14 - “Пи***тая”
//Иначе - “Уникальная”
//Вызвать метод с данными, подходящими под каждую из веток

fun describeCollection(numbers: List<Int>): String {
    return when {
        numbers.isEmpty() -> "Пусто"
        numbers.size < 5 -> "Короткая"
        numbers.first() == 0 -> "Стартовая"
        numbers.sum() > 10000 -> "Массивная"
        numbers.average() == 10.0 -> "Сбалансированная"
        numbers.joinToString("").length == 20 -> "Клейкая"
        (numbers.maxOrNull() ?: 0) < -10 -> "Отрицательная"
        (numbers.minOrNull() ?: 0) > 1000 -> "Положительная"
        numbers.contains(3) && numbers.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}
fun main() {
    println(describeCollection(emptyList()))                       // Пусто
    println(describeCollection(listOf(1, 2, 3)))                   // Короткая
    println(describeCollection(listOf(0, 1, 2, 3, 4)))             // Стартовая
    println(describeCollection(listOf(3000, 3000, 3000, 3000, 1))) // Массивная
    println(describeCollection(listOf(10, 10, 10, 10, 10)))        // Сбалансированная
    println(describeCollection(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))) // Клейкая
    println(describeCollection(listOf(-20, -30, -40, -50, -60)))   // Отрицательная
    println(describeCollection(listOf(2000, 3000, 4000, 5000, 6000))) // Положительная
    println(describeCollection(listOf(3, 14, 1, 2, 5)))            // Пи***тая
    println(describeCollection(listOf(7, 8, 9, 11, 12)))           // Уникальная
}

//Задача 25. Анализ учебных оценок
//Напиши функцию, которая принимает список чисел и возвращает список чисел.
//
//Пример данных: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
//
//Цель: Отфильтровать удовлетворительные оценки (>=60),
// отсортировать оставшиеся по возрастанию и взять первые 3. Вызывай методы обработки и фильтрации
// последовательно один из другого,
// чтобы результат предыдущего метода являлся основой для следующего.

fun analyzeGrades(grades: List<Int>): List<Int> {
    return grades
        .filter { it >= 60 }      // 1. оставляем только удовлетворительные (>= 60)
        .sorted()                 // 2. сортируем по возрастанию
        .take(3)                  // 3. берём первые 3
}

fun main() {
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println(analyzeGrades(grades))   // [67, 74, 85]
}



//Задача 26. Создание каталога по первой букве
//Напиши функцию, которая принимает список строк и возвращает словарь с ключом - буквой
// и значением - списком строк.
//
//Начальные значения: val list = listOf(
//"Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра",
// "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник",
// "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло",
// "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница",
// "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир",
// "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
//)

fun groupByFirstLetter(words: List<String>): Map<Char, List<String>> {
    return words.groupBy { it.first().uppercaseChar() }
}

//Задание 27. Подсчёт средней длины слов в списке
//Напиши функцию, которая принимает список строк и возвращает строку.
//
//Начальные значения взять из предыдущей задачи.
//
//Цель: Перевести все слова в количество букв, подсчитать среднее значение.
// Вернуть форматированный текст с двумя знаками после запятой, используя функцию format
// и подходящий шаблон.

fun averageWordLength(words: List<String>): String {
    val average = words
        .map { it.length }
        .average()

    return "%.2f".format(average)
}

//Задание 28: Категоризация чисел
//Напиши функцию, которая принимает список чисел и возвращает словарь с ключами - строками и значениями - список чисел.
//
//Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
//
//Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”).

fun categorizeNumbers(numbers: List<Int>): Map<String, List<Int>> {
    return numbers
        .distinct()
        .sortedDescending()
        .groupBy {
            if (it % 2 == 0) "четные" else "нечетные"
        }
}

//Задание 29: Поиск первого подходящего элемента
//Напиши функцию, которая принимает список чисел и число и возвращает nullable число.
//
//Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60) и число для проверки возраста, например 18.
//
//Цель: Найти первый возраст в списке, который соответствует условию (больше второго аргумента) и вернуть его, либо null если значения не нашлось.

fun findFirstOlderThan(ages: List<Int?>, minAge: Int): Int? {
    return ages
        .filterNotNull()
        .firstOrNull { it > minAge }
}
