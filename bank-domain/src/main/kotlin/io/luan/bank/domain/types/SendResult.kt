package io.luan.bank.domain.types

class SendResult {
    companion object {
        fun success(): SendResult {
            return SendResult()
        }
    }
}