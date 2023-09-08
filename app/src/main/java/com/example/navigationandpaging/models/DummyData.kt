package com.example.navigationandpaging.models

import androidx.compose.runtime.remember
import com.example.navigationandpaging.R
import com.example.navigationandpaging.models.cart.CartItem
import com.example.navigationandpaging.models.fav.FavoriteItem
import com.example.navigationandpaging.models.products.Product
import com.example.navigationandpaging.models.profile.Profile

object DummyData {


    val filterItems = listOf(
        R.drawable.ic_star to "Popular",
        R.drawable.ic_chair to "Chair",
        R.drawable.ic_table to "Table",
        R.drawable.ic_sofa to "Armchair",
        R.drawable.ic_bed to "Bed",
        R.drawable.ic_lamp to "Lamp"
    )


    val products = listOf(
        Product(
            name = "Black Simple Lamp", image = R.drawable.img_black_simple_lamp, price = "$ 12.00"
        ),
        Product(
            name = "Minimal Stand", image = R.drawable.img_minimal_stand, price = "$ 25.00"
        ),
        Product(name = "Coffee Chair", image = R.drawable.img_chair, price = "$ 20.00"),
        Product(name = "Simple Desk", image = R.drawable.img_simple_desk, price = "$ 50.00"),
        Product(
            name = "Black Simple Lamp", image = R.drawable.img_simple_desk, price = "$ 12.00"
        ),
        Product(
            name = "Minimal Stand", image = R.drawable.img_minimal_stand, price = "$ 25.00"
        ),
        Product(name = "Coffee Chair", image = R.drawable.img_chair, price = "$ 20.00"),
        Product(name = "Simple Desk", image = R.drawable.img_simple_desk, price = "$ 50.00"),
        Product(
            name = "Black Simple Lamp", image = R.drawable.img_simple_desk, price = "$ 12.00"
        ),
        Product(
            name = "Minimal Stand", image = R.drawable.img_minimal_stand, price = "$ 25.00"
        ),
        Product(name = "Coffee Chair", image = R.drawable.img_chair, price = "$ 20.00"),
        Product(name = "Simple Desk", image = R.drawable.img_simple_desk, price = "$ 50.00"),
        Product(
            name = "Black Simple Lamp", image = R.drawable.img_simple_desk, price = "$ 12.00"
        ),
        Product(
            name = "Minimal Stand", image = R.drawable.img_minimal_stand, price = "$ 25.00"
        ),
        Product(name = "Coffee Chair", image = R.drawable.img_chair, price = "$ 20.00"),
        Product(name = "Simple Desk", image = R.drawable.img_simple_desk, price = "$ 50.00"),
    )

    val profileData = listOf(
        Profile(id = 1, title = "My orders", description = "Already have 10 orders"),
        Profile(id = 2, title = "Shipping Address", description = "03 Addresses"),
        Profile(id = 3, title = "Payment Method", description = "You have 2 Cards"),
        Profile(id = 4, title = "My reviews", description = "Reviews for 5 items"),
        Profile(id = 5, title = "Setting", description = "Notification, Password, FAQ, Contact")
    )

    val favoriteItems = listOf(
        FavoriteItem(img = R.drawable.img_coffe_table, title = "Coffee Table", amount = " $ 50.00"),
        FavoriteItem(img = R.drawable.img_chair, title = "Coffee Chair", amount = " $ 20.00"),
        FavoriteItem(img = R.drawable.img_minimal_stand, title = "Minimal Stand", amount = " $ 25.00"),
        FavoriteItem(img = R.drawable.img_simple_desk, title = "Minimal Desk", amount = " $ 50.00"),
        FavoriteItem(img = R.drawable.img_black_simple_lamp, title = "Minimal Lamp", amount = " $ 12.00"),
    )

    val cartItems = listOf(
        CartItem(img = R.drawable.img_minimal_stand, title = "Minimal Stand", amount = "$ 25.00"),
        CartItem(img = R.drawable.img_coffe_table, title = "Coffee Table", amount = "$ 20.00"),
        CartItem(img = R.drawable.img_simple_desk, title = "Minimal Desk", amount = "$ 50.00")
    )

}