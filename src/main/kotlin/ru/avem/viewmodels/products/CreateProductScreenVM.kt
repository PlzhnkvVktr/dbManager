package ru.avem.viewmodels.products

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avem.data.remote.service.product.ProductService
import ru.avem.data.remote.dto.product.ProductRequest

class CreateProductScreenVM(private val navigator: Navigator): ScreenModel {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val service = ProductService.create()

    val name = mutableStateOf("")
    val description = mutableStateOf("")
    val characteristic = mutableStateOf("")
    val specification = mutableStateOf("")
    val additionally = mutableStateOf("")
    val category = mutableStateOf(0)
    val images = mutableStateOf<List<String>?>(null)

    fun addNews() {
        scope.launch {
            service.createProduct(
                ProductRequest(
                    name = name.value,
                    description = description.value,
                    characteristic = characteristic.value,
                    specification = specification.value,
                    additionally = additionally.value,
                    category = category.value,
                    images = if (images.value == null) emptyList() else images.value!!
                )
            )
            navigator.pop()
        }
    }
}