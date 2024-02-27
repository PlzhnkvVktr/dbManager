package ru.avem.screens.products

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.avem.composables.Header
import ru.avem.composables.common.Textarea
import ru.avem.data.remote.dto.product.ProductResponse
import ru.avem.viewmodels.products.EditProductScreenVM

class EditProductScreen(
    private val productResponse: ProductResponse
) : Screen {

    @Composable
    override fun Content() {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navigator = LocalNavigator.currentOrThrow
        val vm = rememberScreenModel { EditProductScreenVM(productResponse, navigator) }

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { Header("Редактирование информации продукта") },
            content = {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Название:",
                        fontSize = 24.sp
                    )
                    Textarea(
                        text = vm.name,
                        h = 100
                    )
                    Text(
                        text = "Описание:",
                        fontSize = 24.sp
                    )
                    Textarea(
                        text = vm.description,
                        h = 300
                    )
                    Text(
                        text = "Характеристики:",
                        fontSize = 24.sp
                    )
                    Textarea(
                        text = vm.characteristic,
                        h = 300
                    )
                    Text(
                        text = "Спецификация:",
                        fontSize = 24.sp)

                    Textarea(
                        text = vm.specification,
                        h = 300
                    )
                    Text(
                        text = "Узнать больше:",
                        fontSize = 24.sp
                    )
                    Textarea(
                        text = vm.additionally,
                        h = 300
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = vm::editProduct
                        ){
                            Text("Редактировать")
                        }
                    }
                }
            }
        )
    }
}