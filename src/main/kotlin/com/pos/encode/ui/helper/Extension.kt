package com.pos.encode.ui.helper

val String.valid: Boolean
    get() = isNotBlank()

val String ?.empty: Boolean
    get() = isNullOrBlank()