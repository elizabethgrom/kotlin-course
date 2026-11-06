

abstract class BaseClass(
    // 1.privateVal доступен в main() для чтения из ChildrenClass,
    //потому что ChildrenClass объявляет свое поле privateVal в конструкторе

    private val privateVal: String,
    // 2.protectedVal недоступен в main(), потому что protected даёт доступ только внутри класса и в наследниках, но не во внешнем коде
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. getProtectedClass() не может быть публичной, потому что возвращает
    //ProtectedClass — вложенный protected-класс. Публичный метод не может раскрывать protected-тип во внешний код
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. В поле "generate" будет "Это генерация из дочернего класса",
    //потому что generate() — open, и ChildrenClass его переопределяет
    open fun generate(): String {
        return "Эт генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. getPrivateClass() не может быть ни публичной, ни protected,
    //потому что возвращает PrivateClass— приватный класс
    //тип с приватной видимостью не может "утекать" в публичный/protected API.
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass()

    private class PrivateClass()
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. publicVal доступен в main(), потому что в ChildrenClass он объявлен  как обычный аргумент конструктора val/var

    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    // 11. getAll() доступна в main(), потому что она public в BaseClass
    //и наследуется ChildrenClass (public-члены наследуются автоматически)
    // 12. printText() выведет "Печать из класса BaseClass", потому что
    //privatePrint() в ChildrenClass — это НОВАЯ функция, а не переопределение.
    //private-методы не участвуют в полиморфизме и не видны в наследнике,
    //поэтому BaseClass.printText() вызывает свой собственный privatePrint().
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // 4.Сеттер для изменения publicField из main()
    fun setPublicField(value: String) {
        publicField = value
    }

    // 5.Сеттер для protectedField (доступен в наследнике)
    fun setProtectedField(value: String) {
        protectedField = value
    }

    // 6.Сеттер для privateField родителя прясмо не возможен
    //privateField приватный в BaseClass. Поэтому добавляем в BaseClass метод-сеттер

}

