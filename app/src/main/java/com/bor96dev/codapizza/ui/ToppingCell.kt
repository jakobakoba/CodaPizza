package com.bor96dev.codapizza.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bor96dev.codapizza.model.Topping
import com.bor96dev.codapizza.model.ToppingPlacement


@Composable
fun ToppingCell(
    topping: Topping,
    placement: ToppingPlacement?,
    onClickTopping: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onClickTopping }
            .padding(vertical = 4.dp, horizontal = 16.dp)
    ) {
        Checkbox(
            checked = placement != null, onCheckedChange = { onClickTopping() }
        )

        Column(
            modifier = modifier.weight(1f, true)
                .padding(start = 4.dp)
        ) {
            Text(
                text = stringResource(id = topping.toppingName),
                style = MaterialTheme.typography.bodyLarge
            )
            if (placement != null) {
                Text(text = stringResource(id = placement.label),
                style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}