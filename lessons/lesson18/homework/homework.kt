import java.io.InputStream

// ==================== ИНТЕРФЕЙСЫ ====================

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

// ==================== ЗАДАЧА 1. АБСТРАКТНЫЕ КЛАССЫ УСТРОЙСТВ ====================

abstract class Refrigerator : Powerable, Openable, TemperatureRegulatable

abstract class WashingMachine : Powerable, Openable, WaterConnection, Drainable, Timable, Programmable

abstract class SmartLamp : Powerable, LightEmitting, Programmable

abstract class ElectronicClock : Powerable, Timable, Programmable

abstract class RobotVacuumCleaner : Powerable, Movable, Cleanable, Rechargeable, Programmable, AutomaticShutdown

abstract class MechanicalClock : Mechanical, Timable

abstract class Flashlight : Powerable, LightEmitting, BatteryOperated, Mechanical

abstract class CoffeeMachine : Powerable, WaterContainer, WaterConnection, TemperatureRegulatable, Programmable, Timable, Drainable

abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable

// ==================== ЗАДАЧА 2. ВКЛЮЧАЕМОЕ ОБОРУДОВАНИЕ ====================

abstract class PoweredDevice : Powerable {
    protected var isPoweredOn: Boolean = false

    override fun powerOn() {
        isPoweredOn = true
        println("Устройство включено")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Устройство выключено")
    }
}

// ==================== ЗАДАЧА 3. ПРОГРАММИРУЕМОЕ ОБОРУДОВАНИЕ ====================

abstract class ProgrammableDevice : PoweredDevice(), Programmable {
    protected var currentAction: String? = null

    override fun programAction(action: String) {
        if (!isPoweredOn) {
            println("Ошибка: устройство выключено, программирование невозможно")
            return
        }
        currentAction = action
        println("Запрограммировано действие: $action")
    }

    override fun execute() {
        if (!isPoweredOn) {
            println("Ошибка: устройство выключено, выполнение невозможно")
            return
        }
        val action = currentAction
        if (action == null) {
            println("Нет запрограммированного действия")
            return
        }
        println("Выполняется: $action")
    }
}

// ==================== ЗАДАЧА 4. ТЕМПЕРАТУРА + ОТКРЫВАНИЕ ====================

abstract class TemperatureOpenableDevice :
    ProgrammableDevice(),
    TemperatureRegulatable,
    Openable {

    protected var currentTemperature: Int = 0
    protected var isOpen: Boolean = false

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn) {
            println("Ошибка: устройство выключено, установка температуры невозможна")
            return
        }
        if (temp > maxTemperature) {
            println("Ошибка: температура $temp превышает максимум $maxTemperature")
            return
        }
        currentTemperature = temp
        println("Установлена температура: $temp")
    }

    override fun open() {
        if (!isPoweredOn) {
            println("Ошибка: устройство выключено, открытие невозможно")
            return
        }
        isOpen = true
        println("Устройство открыто")
    }

    override fun close() {
        isOpen = false
        println("Устройство закрыто")
    }
}

// ==================== ЗАДАЧА 5. КОНКРЕТНЫЕ УСТРОЙСТВА ====================

class Fridge : TemperatureOpenableDevice(), WaterContainer {
    override val maxTemperature: Int = 10
    override val capacity: Int = 300
    private var waterAmount: Int = 0

    override fun fillWater(amount: Int) {
        if (!isPoweredOn) { println("Ошибка: холодильник выключен"); return }
        waterAmount = (waterAmount + amount).coerceAtMost(capacity)
        println("Налито воды: $amount, всего: $waterAmount")
    }

    override fun getWater(amount: Int) {
        if (!isPoweredOn) { println("Ошибка: холодильник выключен"); return }
        val taken = amount.coerceAtMost(waterAmount)
        waterAmount -= taken
        println("Взято воды: $taken, осталось: $waterAmount")
    }
}

class Washer : TemperatureOpenableDevice(), WaterConnection, Drainable, Timable {
    override val maxTemperature: Int = 90
    private var timer: Int = 0

    override fun connectToWaterSupply() {
        if (!isPoweredOn) { println("Ошибка: машина выключена"); return }
        println("Подключено к водопроводу")
    }

    override fun getWater(amount: Int) {
        if (!isPoweredOn) { println("Ошибка: машина выключена"); return }
        println("Набрано воды: $amount")
    }

    override fun connectToDrain() {
        if (!isPoweredOn) { println("Ошибка: машина выключена"); return }
        println("Подключено к сливу")
    }

    override fun drain() {
        if (!isPoweredOn) { println("Ошибка: машина выключена"); return }
        println("Вода слита")
    }

    override fun setTimer(time: Int) {
        if (!isPoweredOn) { println("Ошибка: машина выключена"); return }
        timer = time
        println("Таймер установлен на $time мин")
    }
}

class Kettle : TemperatureOpenableDevice() {
    override val maxTemperature: Int = 100
}

class Oven : TemperatureOpenableDevice() {
    override val maxTemperature: Int = 250
}

// ==================== ДЕМОНСТРАЦИЯ ====================

fun main() {
    println("=== Холодильник ===")
    val fridge = Fridge()
    fridge.setTemperature(5)          // ошибка: выключен
    fridge.powerOn()
    fridge.open()
    fridge.setTemperature(5)
    fridge.fillWater(100)
    fridge.getWater(30)
    fridge.programAction("Режим супер-охлаждения")
    fridge.execute()
    fridge.close()
    fridge.powerOff()

    println("\n=== Стиральная машина ===")
    val washer = Washer()
    washer.powerOn()
    washer.open()
    washer.setTemperature(60)
    washer.connectToWaterSupply()
    washer.getWater(40)
    washer.setTimer(45)
    washer.programAction("Стирка хлопка")
    washer.execute()
    washer.connectToDrain()
    washer.drain()
    washer.close()
    washer.powerOff()

    println("\n=== Чайник ===")
    val kettle = Kettle()
    kettle.powerOn()
    kettle.open()
    kettle.setTemperature(100)
    kettle.programAction("Вскипятить воду")
    kettle.execute()
    kettle.close()
    kettle.powerOff()

    println("\n=== Духовка ===")
    val oven = Oven()
    oven.setTemperature(180)          // ошибка: выключена
    oven.powerOn()
    oven.open()
    oven.setTemperature(180)
    oven.programAction("Выпечка пирога")
    oven.execute()
    oven.close()
    oven.setTemperature(300)          // ошибка: превышение максимума
    oven.powerOff()
}