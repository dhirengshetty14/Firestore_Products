package com.projs.templatesetup.domain.usecases

import com.projs.templatesetup.domain.model.Product
import com.projs.templatesetup.domain.model.ProductsApp
import com.projs.templatesetup.domain.repo.IProductRepo
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val repo: IProductRepo
) {
    operator fun  invoke(product: Product)=repo.addProduct(product)
}