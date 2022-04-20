package com.work.found.core.base.extensions

import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : Any> Any.takeAs(kClass: KClass<T>) = this as T

@Suppress("UNCHECKED_CAST")
fun <T> Any.takeAs(clazz: Class<T>) = this as T

@Suppress("UNCHECKED_CAST")
inline fun <reified T: Any> Any.takeAs() = this as T