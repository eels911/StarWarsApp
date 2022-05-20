package com.example.core.paging;

interface PageKeyRepository<T : Any> {

    fun getItems(): Listing<T>
}