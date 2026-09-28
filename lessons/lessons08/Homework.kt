

//1
fun makeIronic(input: String): String {
    var result = input

    // 1. Заменяем "невозможно"
    if (result.contains("невозможно")) {
        result = result.replace(
            "невозможно",
            "совершенно точно возможно, просто требует времени"
        )
    }

    // 2. Фраза начинается с "Я не уверен"
    if (result.startsWith("Я не уверен")) {
        result = result + ", но моя интуиция говорит об обратном"
    }

    // 3. Заменяем "катастрофа"
    if (result.contains("катастрофа")) {
        result = result.replace("катастрофа", "интересное событие")
    }

    // 4. Фраза заканчивается на "без проблем"
    if (result.endsWith("без проблем")) {
        result = result.replace(
            "без проблем",
            "с парой интересных вызовов на пути"
        )
    }

    // 5. Фраза из одного слова (нет пробелов)
    if (!result.contains(" ")) {
        result = "Иногда, $result, но не всегда"
    }

    return result
}

fun main() {
    val phrases = listOf(
        "Это невозможно выполнить за один день",
        "Я не уверен в успехе этого проекта",
        "Произошла катастрофа на сервере",
        "Этот код работает без проблем",
        "Удача"
    )

    for (phrase in phrases) {
        println(makeIronic(phrase))
    }
}

//2
fun extractDateTime(log: String) {
    // 1. Ищем позицию "->"
    val arrowIndex = log.indexOf("->")

    // 2. Берём всё после стрелки и убираем лишние пробелы
    val rightPart = log.substring(arrowIndex + 2).trim()

    // 3. Разбиваем на дату и время по пробелу
    val parts = rightPart.split(" ")

    val date = parts[0]
    val time = parts[1]

    println("Дата: $date")
    println("Время: $time")
}
//....

fun main() {
    val log = "Пользователь вошел в систему -> 2021-12-01 09:48:23"
    extractDateTime(log)
}

//3
fun maskCard(card: String): String {
    val lastFour = card.takeLast(4)          // последние 4 символа
    val prefixLength = card.length - 4        // сколько символов замаскировать

    var masked = ""

    // Проходим по всем символам, кроме последних 4
    for (i in 0 until prefixLength) {
        if (card[i] == ' ') {
            masked += " "                     // пробел оставляем
        } else {
            masked += "*"                     // цифру заменяем
        }
    }

    return masked + lastFour
}

fun main() {
    val card = "4539 1488 0343 6467"
    println(maskCard(card))
}

//4
fun formatEmail(email: String): String {
    return email
        .replace("@", " [at] ")
        .replace(".", " [dot] ")
}

fun main() {
    val email = "username@example.com"
    println(formatEmail(email))
}

//5
fun extractFileName(path: String): String {
    // Нормализуем: заменяем все "\" на "/"
    val normalized = path.replace("\\", "/")

    // Берём всё после последнего "/"
    val lastSlash = normalized.lastIndexOf("/")
    val fileName = normalized.substring(lastSlash + 1)

    return fileName
}

fun main() {
    println(extractFileName("C:/Пользователи/Документы/report.txt"))
    println(extractFileName("D:/good.themes/dracula.theme"))
    println(extractFileName("C:\\Users\\Admin\\file.doc"))
}

//6
fun makeAbbreviation(phrase: String): String {
    val words = phrase.split(" ")
    var abbr = ""

    for (word in words) {
        if (word.isNotEmpty()) {
            abbr += word[0].uppercaseChar()
        }
    }

    return abbr
}

fun main() {
    println(makeAbbreviation("Котлин лучший язык программирования"))
    println(makeAbbreviation("Объектно ориентированное программирование"))
    println(makeAbbreviation("Союз Советских Социалистических Республик"))
}

