package io.luan.bank.repository;

import io.luan.bank.domain.entity.Account
import io.luan.bank.types.AccountId
import io.luan.bank.types.AccountNumber
import io.luan.bank.types.UserId

interface AccountRepository {
    fun find(id: AccountId): Account?
    fun find(accountNumber: AccountNumber): Account?
    fun find(userId: UserId): Account?
    fun save(account: Account): Account
}