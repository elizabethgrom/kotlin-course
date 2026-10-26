

// ============================================================
// БАЗОВЫЙ АБСТРАКТНЫЙ КЛАСС
// ============================================================
abstract class Materials {
    protected val materials = mutableListOf<String>()

    abstract fun addMaterial(material: String)

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer(name: String = this::class.simpleName ?: "Container") {
        println("--- $name ---")
        if (materials.isEmpty()) {
            println("(контейнер пуст)")
            return
        }
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

// ============================================================
// 1. ВСТАВКА НА ДНО (индекс 0)
// ============================================================
class BottomContainer : Materials() {
    override fun addMaterial(material: String) {
        materials.add(0, material)
    }
}

// ============================================================
// 2. ЧЕРЕДОВАНИЕ СПИСКА С СУЩЕСТВУЮЩИМИ (0, 2, 4, ...)
// ============================================================
class InterleaveContainer : Materials() {
    override fun addMaterial(material: String) {
        materials.add(0, material)
    }

    fun addMaterials(materialsToAdd: List<String>) {
        val existing = materials.toList()
        materials.clear()

        var newIdx = 0
        var oldIdx = 0
        while (newIdx < materialsToAdd.size || oldIdx < existing.size) {
            if (newIdx < materialsToAdd.size) materials.add(materialsToAdd[newIdx++])
            if (oldIdx < existing.size) materials.add(existing[oldIdx++])
        }
    }
}

// ============================================================
// 3. АЛФАВИТНАЯ СОРТИРОВКА
// ============================================================
class SortedContainer : Materials() {
    override fun addMaterial(material: String) {
        materials.add(material)
        materials.sort()
    }
}

// ============================================================
// 4. СЛОВАРЬ: КЛЮЧИ В НАЧАЛО (обратный порядок), ЗНАЧЕНИЯ В КОНЕЦ
// ============================================================
class KeyValueContainer : Materials() {
    override fun addMaterial(material: String) {
        materials.add(material)
    }

    fun addDictionary(dictionary: Map<String, String>) {
        val keys = dictionary.keys.toList().reversed()
        val values = dictionary.values.toList()

        val combined = keys + materials.toList() + values
        materials.clear()
        materials.addAll(combined)
    }
}

// ============================================================
// ДЕМОНСТРАЦИЯ
// ============================================================
fun main() {
    // 1. BottomContainer
    val bottom = BottomContainer()
    bottom.addMaterial("стекло")
    bottom.addMaterial("дерево")
    bottom.addMaterial("металл")
    bottom.printContainer("BottomContainer")

    // 2. InterleaveContainer
    val interleave = InterleaveContainer()
    interleave.addMaterial("старое1")
    interleave.addMaterial("старое2")
    interleave.addMaterials(listOf("новоеA", "новоеB", "новоеC"))
    interleave.printContainer("InterleaveContainer")

    // 3. SortedContainer
    val sorted = SortedContainer()
    listOf("цинк", "алюминий", "медь", "бронза").forEach { sorted.addMaterial(it) }
    sorted.printContainer("SortedContainer")

    // 4. KeyValueContainer
    val kv = KeyValueContainer()
    kv.addMaterial("существующее1")
    kv.addMaterial("существующее2")
    kv.addDictionary(mapOf("k1" to "v1", "k2" to "v2", "k3" to "v3"))
    kv.printContainer("KeyValueContainer")

    // Демонстрация extractMaterials()
    println("\nИзвлечено из KeyValueContainer: ${kv.extractMaterials()}")
    kv.printContainer("KeyValueContainer после extractMaterials")
}