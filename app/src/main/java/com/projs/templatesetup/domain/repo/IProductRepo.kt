package com.projs.templatesetup.domain.repo

import com.projs.templatesetup.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface IProductRepo {
    fun getProducts(): Flow<List<Product>>
    fun addProduct(product: Product): Flow<Result<Unit>>
    fun deleteProduct(id: String): Flow<Result<Unit>>
}