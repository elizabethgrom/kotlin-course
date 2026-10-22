

//1.Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и attendees (Int).
// Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.

fun main() {
    val party = Party( "Осторов Эпштейна, 67")
    party.details()
}
class party(val location : String, val attendes : Int){
    fun details(){
        print("Вечеринка в `$location`, гостей:$attendees")
    }
}

//Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String) и intensity (Int).
// Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.

fun main(){
    val happy = Emotion( "счастье,67")
    happy.express()
    val sad = Emotion("грусть, 34")
    sad.express()
}
class Emotion(val type: String, val intensity: Int)
fun express() {
    val level = when {
        intensity >= 66 -> "оч сильно"
        intensity >= 35 -> " ну тип окей"
        else -> "чуток"
    }
    println("Я чувствую $type $level (интенсивность $intensity).")
}



//Природное явление: луна. Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean),
// чтобы отображать, видна ли Луна в данный момент, и phase (String),
// чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
fun main(){
     val fullmoon = Moon( true, "Full Moon")
    fullMoon.showPhase()

    val newmoon = Moon(false,"New Moon")
    newMoon.showPhase()
}

class Moon(val isVisible: Boolean, val phase: String) {
    fun showPhase() {
        val visibility = if (isVisible) "видна" else "не видна"
        println("Луна сейчас $visibility. Текущая фаза: $phase.")
    }
}

//4.Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны быть свойства “название”, “цена”, “количество”.

fun main() {
    val product = Product("Компутер", 677.55, 9)
    println(product)
}

data class Product(
    val name: String,
    val price: Double,
    val quantity: Int
)

//5.Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место проведения”,
// “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”.
// Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.

fun main() {
    val concert = Concert("noizems", "гавгав", 6700.0, 3)
    concert.info()
    concert.buyTicket()
    concert.buyTicket()
    concert.buyTicket()
    concert.buyTicket() // распродано
    concert.info()
}

class Concert(
    val group: String,
    val venue: String,
    val price: Double,
    val capacity: Int
) {
    private var soldTickets: Int = 0

    fun info() {
        println(
            "Концерт группы $group в $venue. " +
                    "Цена: $price, вместимость: $capacity, " +
                    "продано билетов: $soldTickets."
        )
    }

    fun buyTicket(): Boolean {
        return if (soldTickets < capacity) {
            soldTickets++
            true
        } else {
            println("Билеты распроданы.")
            false
        }
    }

    fun getSoldTickets(): Int = soldTickets
}

//Задание 6. Стеллаж и полки.
//
//Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".

fun main() {
    val shelf = Shelf(capacity = 10)
    shelf.addItem("книга")   // 5
    shelf.addItem("ручка")   // 5 -> 10
    println("Предметы: ${shelf.getItems()}, осталось: ${shelf.remaining()}")
    println("containsItem('книга'): ${shelf.containsItem("книга")}")
    println("addItem('стол'): ${shelf.addItem("стол")}")
}

class Shelf(val capacity: Int) {
    private val items = mutableListOf<String>()

    private fun used(): Int = items.sumOf { it.length }

    fun canAccommodate(item: String): Boolean = used() + item.length <= capacity

    fun addItem(item: String): Boolean {
        return if (canAccommodate(item)) {
            items.add(item)
            true
        } else {
            false
        }
    }

    fun removeItem(item: String): Boolean = items.remove(item)

    fun containsItem(item: String): Boolean = items.contains(item)

    fun getItems(): List<String> = items.toList() // неизменяемый список

    fun remaining(): Int = capacity - used()

    override fun toString(): String = "Shelf(capacity=$capacity, items=$items)"
}

//rack
fun main() {
    val rack = Rack(maxShelves = 3)
    rack.addShelf(Shelf(8))
    rack.addShelf(Shelf(6))
    rack.addShelf(Shelf(6))
    println("addShelf сверх лимита: ${rack.addShelf(Shelf(5))}")

    for (name in listOf("лампа", "монитор", "мышь", "клавиатура", "коврик")) {
        println("addItem $name: ${rack.addItem(name)}")
    }

    rack.printContents()
    println("removeItem 'мышь': ${rack.removeItem("мышь")}")
    println("containsItem 'лампа': ${rack.containsItem("лампа")}")
    println("removeShelf(0): ${rack.removeShelf(0)}")
    rack.printContents()

    // advancedRemoveShelf
    val r2 = Rack(maxShelves = 3)
    r2.addShelf(Shelf(5))
    r2.addShelf(Shelf(4))
    r2.addShelf(Shelf(10))
    r2.addItem("aaa")
    r2.addItem("bb")
    r2.addItem("cccc")
    r2.printContents()
    val leftover = r2.advancedRemoveShelf(2)
    println("Не удалось разместить: $leftover")
    r2.printContents()
}

class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= maxShelves) return false
        if (shelves.contains(shelf)) return false
        shelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        return if (index in shelves.indices) {
            shelves.removeAt(index).getItems()
        } else {
            emptyList()
        }
    }

    fun addItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.addItem(item)) return true
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.removeItem(item)) return true
        }
        return false
    }

    fun containsItem(item: String): Boolean = shelves.any { it.containsItem(item) }

    fun getShelves(): List<Shelf> = shelves.toList()

    fun printContents() {
        println("Содержимое стеллажа:")
        if (shelves.isEmpty()) {
            println("  (пусто)")
            return
        }
        shelves.forEachIndexed { i, shelf ->
            println(
                "  Полка #$i: вместимость=${shelf.capacity}, " +
                        "осталось=${shelf.remaining()}, предметы=${shelf.getItems()}"
            )
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()

        val removed = shelves.removeAt(index)
        val items = removed.getItems().sortedByDescending { it.length }

        val leftover = mutableListOf<String>()
        for (item in items) {
            if (!shelves.any { it.addItem(item) }) {
                leftover.add(item)
            }
        }
        return leftover
    }
}