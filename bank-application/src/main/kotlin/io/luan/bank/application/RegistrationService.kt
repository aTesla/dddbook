package io.luan.bank.application;

import io.luan.bank.types.Address;
import io.luan.bank.types.Name;
import io.luan.bank.types.PhoneNumber;

interface RegistrationService {
    fun register(name:Name, phone:PhoneNumber, address:Address): Boolean
}