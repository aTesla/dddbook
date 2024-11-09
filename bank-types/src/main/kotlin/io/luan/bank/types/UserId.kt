package io.luan.bank.types

data class UserId(val id: Long) {
    init {
        require(id > 0L)
    }
}