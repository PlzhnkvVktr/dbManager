package ru.avem.viewmodels.products

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avem.data.remote.service.product.ProductService
import ru.avem.data.remote.dto.product.ProductResponse

class ProductsScreenVM : ScreenModel {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val service = ProductService.create()
    var products = mutableStateOf<List<ProductResponse>?>(null)

    suspend fun getNews() {
        products.value = service.getProducts()
    }

    fun deleteNews(id: String) {
        scope.launch {
            service.deleteProduct(id)
            getNews()
        }
    }
}