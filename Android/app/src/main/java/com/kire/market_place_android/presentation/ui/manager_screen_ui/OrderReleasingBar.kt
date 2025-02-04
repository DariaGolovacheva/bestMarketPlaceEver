package com.kire.market_place_android.presentation.ui.manager_screen_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme

import com.kire.test.R

/**
 * By Michael Gontarev (KiREHwYE)*/
@Composable
fun OrderReleasingBar(
    roundedCornerShape: RoundedCornerShape =
        RoundedCornerShape(
            topStart = 18.dp,
            topEnd = 18.dp,
            bottomEnd = 18.dp
        ),
    paddingValues: PaddingValues = PaddingValues(20.dp),
    onClick: () -> Unit = { }
){

    var orderCode by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(roundedCornerShape)
            .background(ExtendedTheme.colors.profileBar)
            .padding(paddingValues),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = stringResource(id = R.string.ordering_title),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.order_code_input_suggestion),
                fontWeight = FontWeight.W300,
                fontSize = 15.sp,
                color = Color.Black
            )

            BasicTextField(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .height(28.dp)
                    .width(84.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White),
                value = orderCode,
                onValueChange = {
                    orderCode = it
                },

                textStyle = LocalTextStyle.current.copy(
                    color = Color.Black,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        if (orderCode.isEmpty())
                            Text(
                                text = stringResource(id = R.string.order_code_hint),
                                fontWeight = FontWeight.W400,
                                fontSize = 9.sp,
                                color = Color.Gray,
                            )
                        innerTextField()
                    }
                }
            )

            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
                tint = ExtendedTheme.colors.redAccent,
                modifier = Modifier
                    .size(18.dp)
                    .pointerInput(Unit){
                        detectTapGestures {
                            onClick()
                        }
                    }
            )
        }
    }
}