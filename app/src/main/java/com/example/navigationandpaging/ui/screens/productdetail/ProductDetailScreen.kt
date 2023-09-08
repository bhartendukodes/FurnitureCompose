package com.example.navigationandpaging.ui.screens.productdetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigationandpaging.R
import com.example.navigationandpaging.models.products.Product
import com.example.navigationandpaging.ui.components.AddMinusCartButton
import com.example.navigationandpaging.ui.components.MyButton
import com.example.navigationandpaging.ui.components.MyTopAppBar
import com.example.navigationandpaging.ui.theme.yellow
import com.example.navigationandpaging.ui.viewModels.ProductDetailViewModel

const val ARG_PRODUCT_ID = "productID"

const val productDetailNavRoute = "productDetailNavRoute/{$ARG_PRODUCT_ID}"

fun NavController.navigateToProductDetailScreen(
    productId: String,
    navOptions: NavOptions? = null,
) {
    navigate(
        route = productDetailNavRoute.replace("{$ARG_PRODUCT_ID}", productId),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.productDetailScreen(onBackPressed: () -> Unit) {
    composable(route = productDetailNavRoute) {

        DetailScreen(onBackPressed = onBackPressed)
    }
}

@Composable
fun DetailScreen(onBackPressed: () -> Unit, viewModel: ProductDetailViewModel = hiltViewModel()) {

    val product = viewModel.product

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item {
                TopBarWithImages(
                    onBackPressed = onBackPressed,
                    images = if (product != null) listOf(
                        product.image,
                        product.image,
                        product.image
                    ) else listOf()
                )
            }

            item {
                ProductDetail(product)
            }

            item{
                Spacer(modifier = Modifier.height(100.dp))
            }

        }

        ActionsBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onBookmarkClick = { },
            onAddToCart = {})


    }

}

@Composable
private fun ProductDetail(product: Product?) {

    var qty by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = product?.name.toString(), style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {

            Text(
                text = product?.price.toString(),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            )

            AddMinusCartButton(qty = qty,
                onAddClick = { qty += 1 },
                onMinusClick = {
                    if (qty > 0)
                        qty -= 1
                })

        }

        Spacer(modifier = Modifier.height(24.dp))

        ReviewRow()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = product?.description.toString(),
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 30.sp,
                color = Color.DarkGray.copy(0.6f)
            )
        )


    }

}

@Composable
private fun ReviewRow() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        Icon(imageVector = Icons.Filled.Star, contentDescription = "", tint = yellow)

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "4.5", style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.width(22.dp))

        Text(
            text = "(50 Reviews)", style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TopBarWithImages(onBackPressed: () -> Unit, images: List<Int>) {

    val imageBoxHeight = LocalConfiguration.current.screenHeightDp / 2

    val pagerState = rememberPagerState() {
        3
    }

    Box(modifier = Modifier.fillMaxWidth()) {


        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(imageBoxHeight.dp)
                .padding(start = 30.dp)
                .clip(RoundedCornerShape(bottomStart = 55.dp))
        ) {

            val image = images[it]

            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            (images.indices).forEach {
                val isSelected = it == pagerState.currentPage

                Divider(
                    thickness = 4.dp,
                    modifier = Modifier
                        .width(20.dp)
                        .clip(MaterialTheme.shapes.medium),
                    color = if (isSelected) Color.Black else Color.LightGray
                )

                Spacer(modifier = Modifier.width(6.dp))
            }
        }

        IconButton(
            onClick = onBackPressed,
            modifier = Modifier
                .padding(16.dp)
                .statusBarsPadding()
                .shadow(4.dp, shape = MaterialTheme.shapes.medium, clip = false)
                .background(color = Color.White, shape = MaterialTheme.shapes.medium)
        ) {
            Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = null)
        }

    }

}

@Composable
private fun ActionsBottomBar(
    modifier: Modifier,
    onBookmarkClick: () -> Unit,
    onAddToCart: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .navigationBarsPadding()
            .padding(bottom = 16.dp)
    ) {


        Icon(
            imageVector = Icons.Outlined.BookmarkBorder,
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .background(color = Color.LightGray.copy(0.5f), shape = MaterialTheme.shapes.medium)
                .clip(MaterialTheme.shapes.medium)
                .clickable {
                    onBookmarkClick()
                }
                .padding(18.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.width(16.dp))

        MyButton(
            text = "Add to Cart", modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            onAddToCart()
        }

    }
}
