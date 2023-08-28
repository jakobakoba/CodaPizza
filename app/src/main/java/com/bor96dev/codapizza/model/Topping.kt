package com.bor96dev.codapizza.model

import androidx.annotation.StringRes
import com.bor96dev.codapizza.R

enum class Topping (
    @StringRes val toppingName: Int
        ){
    Basil(
        toppingName = R.string.topping_basil
    ),
    MushRoom(
        toppingName = R.string.topping_mushroom
    ),
    Olive(
        toppingName = R.string.topping_olive
    ),
    Peppers(
        toppingName = R.string.topping_peppers
    ),
    Pepperoni(
        toppingName = R.string.topping_pepperoni
    ),
    Pineapple(
        toppingName = R.string.topping_pineapple
    )
}