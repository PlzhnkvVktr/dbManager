package ru.avem.screens.products

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.launch
import ru.avem.composables.*
import ru.avem.composables.common.NavButton
import ru.avem.enums.Category
import ru.avem.viewmodels.products.ProductsScreenVM

class ProductsScreen() : Screen {

    @Composable
    override fun Content() {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navigator = LocalNavigator.currentOrThrow
        val vm = rememberScreenModel { ProductsScreenVM() }
        val scope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            vm.getProductsByCategory()
        }

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { Header("Список продукции") },
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            drawerContent = { Drawer { vm.getProductsByCategory() } },
            drawerShape = object : Shape {
                override fun createOutline(
                    size: Size,
                    layoutDirection: LayoutDirection,
                    density: Density
                ): Outline {
                    return Outline.Rectangle(
                        Rect(
                            offset = Offset.Zero,
                            size = Size(
                                width = 480f,
                                height = Float.MAX_VALUE
                            )
                        )
                    )
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(.1f)
                        ) {
                            NavButton(
                                action = {
                                    scope.launch {
                                        if (scaffoldState.drawerState.isClosed) {
                                            scaffoldState.drawerState.open()
                                        } else {
                                            scaffoldState.drawerState.close()
                                        }
                                    }
                                         },
                                imageVector = Icons.Filled.Menu,
                                color = Color.Black
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(.8f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = Category.getCurrentCategory().title,
                                style = MaterialTheme.typography.h4
                            )
                        }
                    }

                    if (vm.products.value == null) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize(.5f)
                        )
                    } else {
                        LazyColumn {
                            items(vm.products.value!!) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .padding(15.dp)
                                        .border(1.dp, Color.LightGray)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(.95f)
                                            .fillMaxHeight()
                                            .border(1.dp, Color.LightGray)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = it.name,
                                                fontSize = 20.sp,
                                                modifier = Modifier
                                                    .padding(top = 15.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(20.dp))
                                        Text(
                                            text = it.description,
                                            fontSize = 14.sp,
                                            modifier = Modifier
                                                .padding(start = 5.dp)
                                        )
                                    }
                                    ItemPanel(
                                        delete = { vm.deleteNews(it.id) },
                                        edit = { navigator.push(EditProductScreen(it)) }
                                    )
                                }
                            }
                        }
                    }
                }
            },
            bottomBar = {
                ItemsScreenBottomBar { navigator.push(CreateProductScreen()) }
            }
        )
    }
}

