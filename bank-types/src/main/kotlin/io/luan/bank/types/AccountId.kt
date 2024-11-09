package io.luan.bank.types

data class AccountId(val id: Long) {
    init {
        require(id > 0L)
    }
}