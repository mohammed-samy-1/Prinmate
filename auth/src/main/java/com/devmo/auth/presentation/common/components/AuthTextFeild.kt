package com.devmo.auth.presentation.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.devmo.auth.R

@Composable
fun AuthTextFiled(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge
        .copy(color = Color.White),
    isSingleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit,
    isPassword: Boolean = false
) {
    Box(
        modifier
            .clip(RoundedCornerShape(10.dp))
            .background(colorResource(id = R.color.text_filed_bg))
            .padding(vertical = 8.dp, horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        var show by remember {
            mutableStateOf(false)
        }
        if (isHintVisible){
            Text(
                text = hint,
                style = textStyle,
                color = colorResource(id = R.color.hint),
                modifier = Modifier.align(Alignment.CenterStart)
                    .padding(top = 5.dp)
            )
        }
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = isSingleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                },
            visualTransformation = if (isPassword && !show) PasswordVisualTransformation() else VisualTransformation.None
        )



        if (isPassword) {
            Crossfade(
                targetState = show, modifier = Modifier
                    .clickable {
                        show = !show
                    }
                    .align(Alignment.CenterEnd),
                label = "show_password"
            ) {
                if (it) {
                    Icon(
                        imageVector = Icons.Outlined.Visibility,
                        contentDescription = stringResource(
                            R.string.hide_password,
                        ),
                        tint = colorResource(id = R.color.hint),
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.VisibilityOff,
                        contentDescription = stringResource(R.string.show_password),
                        tint = colorResource(id = R.color.hint)
                    )
                }

            }
        }

    }
}