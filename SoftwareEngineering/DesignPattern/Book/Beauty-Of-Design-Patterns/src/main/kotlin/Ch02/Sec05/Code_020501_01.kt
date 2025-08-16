package Ch02.Sec05

class ShoppingCart(
    var itemsCount: Int,                                               // getter/setter
    var totalPrice: Double,                                            // getter/setter
    val shoppingCards: MutableList<ShoppingCartItem> = mutableListOf() // getter/add
) {
    fun addItem(item: ShoppingCartItem) {
        shoppingCards.add(item)
    }
}

class ShoppingCartItem
