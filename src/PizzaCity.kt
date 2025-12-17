abstract class PizzaCity {
    protected var neapolitanCount = 0
    protected var romanCount = 0
    protected var sicilianCount = 0
    protected var totalRevenue = 0.0

    protected val neapolitanPrice = 450.0
    protected val romanPrice = 520.0
    protected val sicilianPrice = 480.0

    // Статистика фото чеков
    protected var checkPhotoShown = 0
    protected var checkPhotoNotShown = 0
    protected var totalDiscounts = 0.0

    // Статистика кофе
    protected var coffeeSold = 0
    protected var coffeeNotSold = 0
    protected var coffeeRevenue = 0.0
    protected val coffeePrice = 120.0

    // Кофе по пиццам
    protected var neapolitanCoffee = 0
    protected var romanCoffee = 0
    protected var sicilianCoffee = 0

    fun neapolitanPizzaSale() {
        neapolitanCount++
        totalRevenue += neapolitanPrice
        println("Неаполитанская пицца продана за $neapolitanPrice руб.")
        selectAddService("neapolitan")
    }

    fun romanPizzaSale() {
        romanCount++
        totalRevenue += romanPrice
        println("Римская пицца продана за $romanPrice руб.")
        selectAddService("roman")
    }

    fun sicilianPizzaSale() {
        sicilianCount++
        totalRevenue += sicilianPrice
        println("Сицилийская пицца продана за $sicilianPrice руб.")
        selectAddService("sicilian")
    }

    protected abstract fun selectAddService(pizzaType: String)

    protected fun offerCheckPhoto(pizzaType: String) {
        println("\nПоказать фото чека для скидки 5%?")
        println("1 - Да")
        println("2 - Нет")

        when (readLine()) {
            "1" -> {
                checkPhotoShown++
                val discount = getPizzaPrice(pizzaType) * 0.05
                totalDiscounts += discount
                totalRevenue -= discount
                println("Скидка: ${discount.toInt()} руб.")
            }
            "2" -> {
                checkPhotoNotShown++
                println("Фото чека не показано")
            }
            else -> println("Неверный выбор")
        }
    }

    protected fun offerCoffee(pizzaType: String) {
        println("\nХотите кофе за $coffeePrice руб.?")
        println("1 - Да")
        println("2 - Нет")

        when (readLine()) {
            "1" -> {
                coffeeSold++
                coffeeRevenue += coffeePrice
                totalRevenue += coffeePrice
                when (pizzaType) {
                    "neapolitan" -> neapolitanCoffee++
                    "roman" -> romanCoffee++
                    "sicilian" -> sicilianCoffee++
                }
                println("Кофе добавлено!")
            }
            "2" -> {
                coffeeNotSold++
                println("Кофе не выбрано")
            }
            else -> println("Неверный выбор")
        }
    }

    private fun getPizzaPrice(pizzaType: String): Double {
        return when (pizzaType) {
            "neapolitan" -> neapolitanPrice
            "roman" -> romanPrice
            "sicilian" -> sicilianPrice
            else -> 0.0
        }
    }

    protected fun showBaseStats() {
        println("Пиццы: Неаполитанская-$neapolitanCount, Римская-$romanCount, Сицилийская-$sicilianCount")

        val totalChecks = checkPhotoShown + checkPhotoNotShown
        if (totalChecks > 0) {
            val percent = (checkPhotoShown.toDouble() / totalChecks * 100).toInt()
            println("Фото чеков: показано-$checkPhotoShown($percent%), не показано-$checkPhotoNotShown")
            println("Скидки: ${totalDiscounts.toInt()} руб.")
        }

        val totalCoffee = coffeeSold + coffeeNotSold
        if (totalCoffee > 0) {
            val percent = (coffeeSold.toDouble() / totalCoffee * 100).toInt()
            println("Кофе: продано-$coffeeSold($percent%), отказались-$coffeeNotSold")
            println("Выручка за кофе: ${coffeeRevenue.toInt()} руб.")

            val totalWithCoffee = neapolitanCoffee + romanCoffee + sicilianCoffee
            if (totalWithCoffee > 0) {
                println("Кофе к пиццам:")
                if (neapolitanCoffee > 0) println("Неаполитанская: $neapolitanCoffee(${(neapolitanCoffee.toDouble()/totalWithCoffee*100).toInt()}%)")
                if (romanCoffee > 0) println("Римская: $romanCoffee(${(romanCoffee.toDouble()/totalWithCoffee*100).toInt()}%)")
                if (sicilianCoffee > 0) println("Сицилийская: $sicilianCoffee(${(sicilianCoffee.toDouble()/totalWithCoffee*100).toInt()}%)")
            }
        }
    }

    abstract fun showStatistics()
}