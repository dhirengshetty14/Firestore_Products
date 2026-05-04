package com.projs.templatesetup.data

import com.google.firebase.firestore.FirebaseFirestore
import com.projs.templatesetup.domain.model.Product
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirestorDataSource @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    fun getProducts(): Flow<List<Product>> = callbackFlow {
        val listener = firestore.collection("products")
            .addSnapshotListener { snapshot, error ->

                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                val list = snapshot?.documents?.map {
                    Product(
                        id = it.id,
                        title = it.getString("title") ?: "",
                        price = it.getDouble("price") ?: 0.0,
                        category = it.getString("category") ?: ""
                    )
                } ?: emptyList()

                trySend(list)
            }

        awaitClose { listener.remove() }
    }

    fun addProduct(product: Product): Flow<Result<Unit>> = callbackFlow {

        val data = mapOf(
            "title" to product.title,
            "price" to product.price,
            "category" to product.category
        )

        val task = firestore.collection("products").add(data)

        task.addOnSuccessListener {
            trySend(Result.success(Unit))
            close()
        }

        task.addOnFailureListener {
            trySend(Result.failure(it))
            close(it)
        }

        awaitClose { }
    }
}