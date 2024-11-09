package io.luan.bank.application.impl

import io.luan.bank.application.RegistrationService
import io.luan.bank.repository.SalesRepRepo
import io.luan.bank.repository.UserRepo
import io.luan.bank.types.Address
import io.luan.bank.types.Name
import io.luan.bank.types.PhoneNumber
import io.luan.bank.types.User
import io.luan.bank.types.UserId
import kotlin.random.Random

class RegistrationServiceImpl : RegistrationService {
    override fun register(
        name: Name,
        phone: PhoneNumber,
        address: Address
    ): Boolean {
        val rep = SalesRepRepo().findRep(phone.getAreaCode())

        val user = User(
            userId = UserId(1L),
            name = name,
            phone = phone,
            address = address,
            repId = rep?.repId,
        )

        UserRepo().saveUser(user)
        return true
    }

}