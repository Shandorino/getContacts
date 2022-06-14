package com.odsstudio.contactsbook.data.model

sealed class Icon(
    open val id: Int,
    open val title: String,
) {
    data class Active(
        override val id: Int,
        override val title: String,
    ): Icon(id, title)

    data class Disable(
        override val id: Int,
        override val title: String,
    ): Icon(id, title)
}
