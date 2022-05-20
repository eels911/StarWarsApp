package com.example.core.util
/**
 * Represents a network bound resource. Each subclass represents the resource's state:
 * - [Loading]: the resource is being retrieved from network.
 * - [Success]: the resource has been retrieved (available in [Success.data] field)
 * - [Error]: the resource retrieving has failed (throwable available in [Error.message] field)
 */
sealed class Resource<out R> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T?) : Resource<T>()
    data class Error(val message: String?) : Resource<Nothing>()
}