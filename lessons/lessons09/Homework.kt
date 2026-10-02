
fun main() {
    // 1. Массив из 5 целых чисел со значениями от 1 до 5
    val array1 = intArrayOf(1, 2, 3, 4, 5)

    // 2. Пустой массив строк размером 10 элементов
    val array2 = arrayOfNulls<String>(10)

    // 3. Массив из 5 элементов типа Double, значения — удвоенный индекс
    val array3 = DoubleArray(5) { it * 2.0 }

    // 4. Массив из 5 Int, значение = индекс * 3
    val array4 = IntArray(5)
    for (i in array4.indices) {
        array4[i] = i * 3
    }

    // 5. Массив из 3 nullable строк: один null и две строки
    val array5: Array<String?> = arrayOf(null, "Hello", "World")

    // 6. Копирование массива целых чисел в новый массив в цикле
    val source = intArrayOf(10, 20, 30, 40, 50)
    val copy = IntArray(source.size)
    for (i in source.indices) {
        copy[i] = source[i]
    }

    // 7. Два массива одинаковой длины, третий — разность
    val a = intArrayOf(10, 20, 30, 40, 50)
    val b = intArrayOf(1, 2, 3, 4, 5)
    val diff = IntArray(a.size)
    for (i in a.indices) {
        diff[i] = a[i] - b[i]
    }
    println("Разность массивов: ${diff.joinToString()}")

    // 8. Поиск индекса элемента со значением 5 через while
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    var index = 0
    var foundIndex = -1
    while (index < numbers.size) {
        if (numbers[index] == 5) {
            foundIndex = index
            break
        }
        index++
    }
    println("Индекс элемента 5: $foundIndex")

    // 9. Вывод каждого элемента с пометкой чётное/нечётное
    val arr = intArrayOf(1, 2, 3, 4, 5, 6)
    for (num in arr) {
        val label = if (num % 2 == 0) "чётное" else "нечётное"
        println("$num - $label")
    }

    // 10. Функция поиска элемента, содержащего подстроку
    findSubstring(arrayOf("apple", "banana", "cherry"), "an")
}

fun findSubstring(array: Array<String>, search: String) {
    for (item in array) {
        if (item.contains(search)) {
            println("Найден элемент: $item")
        }
    }
}

fun main() {
    // 1. Пустой неизменяемый список целых чисел
    val emptyList: List<Int> = emptyList()

    // 2. Неизменяемый список строк из трёх элементов
    val fixedList = listOf("Hello", "World", "Kotlin")

    // 3. Изменяемый список целых чисел от 1 до 5
    val mutableList = mutableListOf(1, 2, 3, 4, 5)

    // 4. Добавление новых элементов
    mutableList.addAll(listOf(6, 7, 8))
    println("После добавления: $mutableList")

    // 5. Удаление элемента "World" из изменяемого списка строк
    val stringList = mutableListOf("Hello", "World", "Kotlin")
    stringList.remove("World")
    println("После удаления: $stringList")

    // 6. Вывод каждого элемента списка целых чисел
    for (num in mutableList) {
        println(num)
    }

    // 7. Получение второго элемента списка строк по индексу
    val second = fixedList[1]
    println("Второй элемент: $second")

    // 8. Изменение значения элемента на позиции 2
    val numbers = mutableListOf(10, 20, 30, 40, 50)
    numbers[2] = 99
    println("После изменения: $numbers")

    // 9. Объединение двух списков строк через циклы
    val listA = listOf("A", "B")
    val listB = listOf("C", "D")
    val merged = mutableListOf<String>()
    for (item in listA) merged.add(item)
    for (item in listB) merged.add(item)
    println("Объединённый список: $merged")

    // 10. Минимальный и максимальный элементы списка через цикл
    val nums = listOf(5, 2, 9, 1, 7)
    var min = nums[0]
    var max = nums[0]
    for (n in nums) {
        if (n < min) min = n
        if (n > max) max = n
    }
    println("Минимум: $min, Максимум: $max")

    // 11. Новый список только с чётными числами
    val evens = mutableListOf<Int>()
    for (n in nums) {
        if (n % 2 == 0) evens.add(n)
    }
    println("Чётные: $evens")
}

fun main() {
    // 1. Пустое неизменяемое множество целых чисел
    val emptySet: Set<Int> = emptySet()

    // 2. Неизменяемое множество из трёх элементов
    val fixedSet = setOf(1, 2, 3)

    // 3. Изменяемое множество строк
    val mutableSet = mutableSetOf("Kotlin", "Java", "Scala")

    // 4. Добавление новых элементов
    mutableSet.add("Swift")
    mutableSet.add("Go")
    println("После добавления: $mutableSet")

    // 5. Удаление элемента 2 из множества целых чисел
    val intSet = mutableSetOf(1, 2, 3, 4)
    intSet.remove(2)
    println("После удаления: $intSet")

    // 6. Вывод каждого элемента множества целых чисел
    for (n in intSet) {
        println(n)
    }

    // 7. Функция проверки наличия строки в множестве через цикл
    containsString(setOf("Kotlin", "Java", "Scala"), "Java")

    // 8. Конвертация неизменяемого множества строк в изменяемый список через цикл
    val immutableSet = setOf("A", "B", "C")
    val listFromSet = mutableListOf<String>()
    for (item in immutableSet) {
        listFromSet.add(item)
    }
    println("Список из множества: $listFromSet")
}

fun containsString(set: Set<String>, target: String) {
    var found = false
    for (item in set) {
        if (item == target) {
            found = true
            break
        }
    }
    println(found) // true если строка есть
}
