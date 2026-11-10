// 1
fun <M> getMiddleElement(list: List<M>): M? {
    if (list.size % 2 == 0) {
        return null
    }
    return list[list.size / 2]
}

// 2
class ListHolder<T> {

    private val list = mutableListOf<T>()

    fun add(element: T) {
        list.add(element)
    }

    fun get(): List<T> {
        return list.toList()
    }
}

// 3
interface Mapper<T, R> {
    fun map(element: T): R
    fun map(elements: List<T>): List<R>
}

// 4
class PhrasesToListOfStrings : Mapper<String, List<String>> {

    override fun map(element: String): List<String> {
        return element.split(" ")
    }

    override fun map(elements: List<String>): List<List<String>> {
        return elements.map { it.split(" ") }
    }
}

// 5
fun <I, D> transposition(map: Map<I, D>): Map<D, I> {
    return map.map { it }.associate { it.value to it.key }
}

// 6
interface Validator<T> {
    fun validate(element: T): Boolean
}

// 7
class StringValidator : Validator<String?> {

    override fun validate(element: String?): Boolean {
        return element?.isNotBlank() ?: false
    }
}

// 8
class OddValidator : Validator<Int> {

    override fun validate(element: Int): Boolean {
        return element % 2 == 0
    }
}

// 9
class ListValidator<W : Number> : Validator<List<W?>> {

    override fun validate(element: List<W?>): Boolean {
        return element.all { it != null && it.toDouble() != 0.0 }
    }
}