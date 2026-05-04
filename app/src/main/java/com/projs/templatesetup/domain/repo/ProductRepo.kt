package com.projs.templatesetup.domain.repo

import com.projs.templatesetup.data.FirestorDataSource
import com.projs.templatesetup.domain.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepo @Inject constructor(
    private val ds: FirestorDataSource
): IProductRepo {
    override fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun addProduct(product: Product): Flow<Result<Unit>> {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: String): Flow<Result<Unit>> {
        TODO("Not yet implemented")
    }
}