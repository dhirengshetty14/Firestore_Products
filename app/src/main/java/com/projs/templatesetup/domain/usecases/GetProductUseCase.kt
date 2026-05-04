package com.projs.templatesetup.domain.usecases

import com.projs.templatesetup.domain.repo.IProductRepo
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repo: IProductRepo
) {
    operator fun invoke()=repo.getProducts()
}