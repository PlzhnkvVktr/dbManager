package ru.avem.viewmodels.products

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avem.data.remote.service.product.ProductService
import ru.avem.data.remote.dto.product.ProductResponse
import ru.avem.enums.Category

class ProductsScreenVM : ScreenModel {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val service = ProductService.create()
    var products = mutableStateOf<List<ProductResponse>?>(null)

    val categoryList = listOf(
        Category.TEST_EQUIPMENT,
        Category.AUTOMOTIVE_ELECTROMECHANICS,
        Category.DEVICES,
        Category.TRAINING_DEMONSTRATION_STANDS,
        Category.HYDRAULIC_EQUIPMENT,
        Category.MEASURING_SYSTEMS,
        Category.OTHER_EQUIPMENT
    )
    suspend fun getProductsByCategory(category: Int = 1) {
        products.value = service.getProductsByCategory(category)
    }

    suspend fun getProducts() {
        products.value = service.getProducts()
    }

    fun deleteNews(id: String) {
        scope.launch {
            service.deleteProduct(id)
            getProducts()
        }
    }
}