package io.luan.bank.types;

data class User(
    val userId: UserId,
    val name: Name,
    val phone: PhoneNumber,
    val address: Address,
    val repId: RepId?,
)