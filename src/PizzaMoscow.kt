class PizzaMoscow : PizzaCity() {
    private var ketchupCount = 0
    private var garlicSauceCount = 0
    private val ketchupPrice = 50.0
    private val garlicSaucePrice = 70.0

    override fun selectAddService(pizzaType: String) {
        offerCheckPhoto(pizzaType)
        offerCoffee(pizzaType)
        offerSauces()
    }

    private fun offerSauces() {
        println("\nВыберите соус:")
        println("1 - Кетчуп ($ketchupPrice руб.)")
        println("2 - Чесночный ($garlicSaucePrice руб.)")
        println("0 - Без соуса")

        when (readLine()) {
            "1" -> {
                ketchupCount++
                totalRevenue += ketchupPrice
                println("Кетчуп добавлен!")
            }
            "2" -> {
                garlicSauceCount++
                totalRevenue += garlicSaucePrice
                println("Чесночный соус добавлен!")
            }
            "0" -> println("Без соуса")
            else -> println("Неверный выбор")
        }
    }

    override fun showStatistics() {
        println("\n=== СТАТИСТИКА МОСКВА ===")
        showBaseStats()

        if (ketchupCount + garlicSauceCount > 0) {
            println("Соусы: Кетчуп-$ketchupCount, Чесночный-$garlicSauceCount")
        }

        println("ИТОГО: ${totalRevenue.toInt()} руб.")
    }
}