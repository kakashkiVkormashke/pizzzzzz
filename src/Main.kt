import kotlin.system.exitProcess

fun main() {
    val pizzaMoscow = PizzaMoscow()
    val pizzaPiter = PizzaPiter()

    while (true) {
        println("\n=== ВЫБЕРИТЕ ПИЦЦЕРИЮ ===")
        println("1 - Москва")
        println("2 - Питер")
        println("3 - Гойдовск")
        println("0 - Выход")
        print("Выберите город: ")

        when (readLine()) {
            "1" -> runPizzeria(pizzaMoscow, "МОСКВА")
            "2" -> runPizzeria(pizzaPiter, "ПИТЕР")
            "3" -> runPizzeria(PizzaGOIDA(), "ГОЙДОВСК")
            "0" -> exitProcess(0)
            else -> println("Неверный выбор!")
        }
    }
}

fun runPizzeria(pizzeria: PizzaCity, name: String) {
    while (true) {
        println("\n=== ПИЦЦЕРИЯ $name ===")
        println("1 - Неаполитанская пицца")
        println("2 - Римская пицца")
        println("3 - Сицилийская пицца")
        println("0 - Статистика")
        println("9 - Назад")
        print("Выберите вариант: ")

        when (readLine()) {
            "1" -> pizzeria.neapolitanPizzaSale()
            "2" -> pizzeria.romanPizzaSale()
            "3" -> pizzeria.sicilianPizzaSale()
            "0" -> pizzeria.showStatistics()
            "9" -> return
            else -> println("Неверный выбор!")
        }
    }
}