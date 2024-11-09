package io.luan.bank.repository.impl

import io.luan.bank.persistence.converter.toAccount
import io.luan.bank.persistence.converter.toAccountDO
import io.luan.bank.domain.entity.Account
import io.luan.bank.persistence.*
import io.luan.bank.repository.AccountRepository
import io.luan.bank.types.AccountId
import io.luan.bank.types.AccountNumber
import io.luan.bank.types.UserId

//class AccountRepositoryImpl(private val accountMapper: AccountMapper) : AccountRepository {
class AccountRepositoryImpl() : AccountRepository {
    private lateinit var accountMapper: AccountMapper
    override fun find(id: AccountId): Account? {
        val accountDO = accountMapper.selectByPrimaryKey(id.id)
        return accountDO?.toAccount()
    }

    override fun find(accountNumber: AccountNumber): Account? {
        val accountDO = accountMapper.selectOne() { accountNumber.number }
        return accountDO?.toAccount()
    }

    override fun find(userId: UserId): Account? {
        val accountDO = accountMapper.selectOne { userId.id }
        return accountDO?.toAccount()
    }

    override fun save(account: Account): Account {
        val accountDO = account.toAccountDO()
        if (account.id == AccountId(-1L)) {
            accountMapper.insert(accountDO)
        } else {
            accountMapper.update {
                updateAllColumns(accountDO)
            }
        }
        return accountDO.toAccount()
    }
}