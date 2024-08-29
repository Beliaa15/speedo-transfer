package com.belia.speedotransfer.ui.onboarding_screen

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP500
import com.belia.speedotransfer.ui.theme.RedP75
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreenDesign(
    image: Int,
    @StringRes title: Int,
    @StringRes description: Int,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.wrapContentHeight(),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = title),
            contentScale = ContentScale.Fit,
            modifier = modifier
                .size(320.dp)
        )

        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = 3,
            modifier = modifier.padding(16.dp),
            activeColor = RedP300,
            inactiveColor = RedP75,
            indicatorWidth = 16.dp,
            indicatorHeight = 16.dp,
            spacing = 8.dp
        )

        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier.padding(16.dp),
            color = GrayG900
        )
        Text(
            text = stringResource(id = description),
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            color = GrayG900
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    val pagerState = rememberPagerState(
        pageCount = { 3 }
    )
    OnBoardingScreenDesign(
        image = R.drawable.loading_rafiki,
        title = R.string.payment,
        description = R.string.confirmation_description,
        pagerState = pagerState
    )
}