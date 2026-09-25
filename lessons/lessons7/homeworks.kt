

//Задания для цикла for
//Прямой диапазон
//Напишите цикл for, который выводит числа от 1 до 5.
fun main() {
    for (i in 1..5) {
        println(i)
    }
}

//Напишите цикл for, который выводит четные числа от 1 до 10.
fun main() {
    for (i in 2..10 step 2) {
        println(i)
    }
}

//Обратный диапазон
//Создайте цикл for, который выводит числа от 5 до 1.
fun main() {
    for (i in 5 downTo 1) {
        println(i)
    }
}

//Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
fun main() {
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}

//С шагом (step)
//Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
//Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
fun main() {
    for (i in 1..9 step 2) {
        println(i)
    }
}

fun main() {
    for (i in 1..20 step 3) {
        println(i)
    }
}

//Использование до (until)
//Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
fun main() {
    val size = 15
    for (i in 3 until size step 2) {
        println(i)
    }
}

//Задания для цикла while
//Цикл while
//Создайте цикл while, который выводит квадраты чисел от 1 до 5.
fun main() {
    var i = 1
    while (i <= 5) {
        println(i * i)
        i++
    }
}
//Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
fun main() {
    var number = 10
    while (number >= 5) {
        number--
    }
    println(number)   // 4
}

//Задания для прерывания и пропуска итерации
//Использование break
//Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
fun main() {
    for (i in 1..10) {
        if (i == 6) break
        println(i)
    }
}

//Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
fun main() {
    var i = 1
    while (true) {
        println(i)
        if (i == 10) break
        i++
    }
}

//Использование continue
//В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
fun main() {
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }
}

//Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
fun main() {
    var i = 1
    while (i <= 10) {
        if (i % 3 == 0) {
            i++
            continue
        }
        println(i)
        i++
    }
}
