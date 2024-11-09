package io.luan.bank.persistence

import java.util.*

data class AccountDO(
    var id: Long? = null,
    var categoryId: Long? = null,
    var icon: String? = null,
    var title: String? = null,
    var showStatus: Int? = null,
    var createTime: Date? = null,
    var readCount: Int? = null,
    var content: String? = null
)