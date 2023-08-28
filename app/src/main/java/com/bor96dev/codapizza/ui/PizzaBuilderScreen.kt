package com.bor96dev.codapizza.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.bor96dev.codapizza.R
import com.bor96dev.codapizza.model.Pizza
import com.bor96dev.codapizza.model.Topping
import com.bor96dev.codapizza.model.ToppingPlacement

@Composable
fun PizzaBuilderScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        ToppingsList(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
        )
        OrderButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

    }

}

@Composable
private fun ToppingsList(
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(Topping.values()) { topping ->

            ToppingCell(
                topping = topping,
                placement = pizza.toppings[topping],
                onClickTopping = {
                    var isOnPizza = pizza.toppings[topping] != null
                    pizza.withTopping(
                        topping = topping,
                        placement = if(isOnPizza){
                            null
                        } else {
                            ToppingPlacement.All
                        }
                    )
                })
        }
    }
}

private var pizza by mutableStateOf(Pizza())
@Composable
private fun OrderButton(
    modifier: Modifier = Modifier,
) {
    Button(onClick = { /*TODO*/ }, modifier = modifier) {
        Text(text = stringResource(id = R.string.place_order_button).toUpperCase(Locale.current))
    }
}