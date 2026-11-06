//Private: Члены класса доступны только внутри этого класса.
//Protected: Члены класса доступны внутри класса и в производных классах.
//Internal: Члены класса доступны в любом месте того же модуля.
//Public: Члены класса доступны отовсюду, где есть доступ к классу.




class SlotMachine(
    val color: String,
    val model: String,
    private var isOn: Boolean = false,
    private var isOsLoaded: Boolean = false,
    private val installedGames: MutableList<String> = mutableListOf(),
    private var hasJoystick: Boolean = true,
    private var revenue: Double = 0.0,
    val owner: String,
    private val supportPhone: String,
    private var set
    private val games = mutableListOf(
        "Sims4",
        "гавгав",
        "Дурак онлайн",
        "Subway Surfes",
) {

    fun turnOn() {
        isOn = true
        loadOs()
    }


    fun turnOff() {
        shutDownOs()
        isOn = false

        }
    }


    private fun loadOs() {
        if (isOn) {
            println("ОС загружена")
        }
    }


    private fun shutdownOs() {
        println("ОС завершила работу")
    }


    fun showGames() {
        if (isOsLoaded) {
            println("Установленные игры: ${installedGames.joinToString()}")
        } else {
            println("Сначала загрузите ОС")
        }
    }


    private fun launchGame(gameName: String) {
        if (isGameSessionPaid && installedGames.contains(gameName)) {
            println("Игра '$gameName' запущена")
        } else {
            println("Игра недоступна или сеанс не оплачен")
        }
    }


      fun payForSession(amount: Double) {
        if (amount >= sessionPrice) {
            revenue += amount
            isGameSessionPaid = true
            println("Сеанс оплачен. Сдача: ${amount - sessionPrice}")
        } else {
            println("Недостаточно средств")
        }
    }


    fun withdrawCash(pin: String) {
        if (checkPin(pin)) {
            openSafeAndGiveCash()
        } else {
            print("Неверный пин-код")
        }
    }


    fun openSafe(): Double {
    val withdraw = balance
    balance = 0.0
    return withdraw
    }

    private fun checkPin(pin: String): Boolean = pin == pinCode
}