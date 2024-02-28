package ru.avem.viewmodels.products

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avem.data.remote.service.product.ProductService
import ru.avem.data.remote.dto.product.ProductRequest
import ru.avem.data.remote.dto.product.ProductResponse
import ru.avem.enums.Category

class EditProductScreenVM(
    private val productResponse: ProductResponse,
    private val navigator: Navigator
) : ScreenModel {

    private val scope = CoroutineScope(Dispatchers.IO)
    private val service = ProductService.create()

    val categoryList = listOf(
        Category.TEST_EQUIPMENT,
        Category.AUTOMOTIVE_ELECTROMECHANICS,
        Category.DEVICES,
        Category.TRAINING_DEMONSTRATION_STANDS,
        Category.HYDRAULIC_EQUIPMENT,
        Category.MEASURING_SYSTEMS,
        Category.OTHER_EQUIPMENT
    )
    val category = mutableStateOf(categoryList.first())

    val name = mutableStateOf(productResponse.name)
    val description = mutableStateOf(productResponse.description)
    val characteristic = mutableStateOf(productResponse.characteristic)
    val specification = mutableStateOf(productResponse.specification)
    val additionally = mutableStateOf(productResponse.additionally)
    val subcategory = mutableStateOf(productResponse.subcategory)
    val images = mutableStateOf<List<String>?>(productResponse.images)

    fun editProduct(){
        scope.launch {
            service.updateProduct(
                id = productResponse.id,
                productRequest = ProductRequest(
                    name = name.value,
                    description = description.value,
                    characteristic = characteristic.value,
                    specification = specification.value,
                    additionally = additionally.value,
                    category = category.value.index,
                    subcategory = subcategory.value,
                    images = if (images.value == null) emptyList() else images.value!!
                )
            )
            navigator.pop()
        }
    }

}