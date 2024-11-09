/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2023-03-30T13:27:19.798718+08:00
 */
package io.luan.bank.persistence

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object AccountDynamicSqlSupport {
    val cmsHelp = CmsHelp()

    val id = cmsHelp.id

    val categoryId = cmsHelp.categoryId

    val icon = cmsHelp.icon

    val title = cmsHelp.title

    val showStatus = cmsHelp.showStatus

    val createTime = cmsHelp.createTime

    val readCount = cmsHelp.readCount

    val content = cmsHelp.content

    class CmsHelp : AliasableSqlTable<CmsHelp>("cms_help", ::CmsHelp) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val categoryId = column<Long>(name = "category_id", jdbcType = JDBCType.BIGINT)

        val icon = column<String>(name = "icon", jdbcType = JDBCType.VARCHAR)

        val title = column<String>(name = "title", jdbcType = JDBCType.VARCHAR)

        val showStatus = column<Int>(name = "show_status", jdbcType = JDBCType.INTEGER)

        val createTime = column<Date>(name = "create_time", jdbcType = JDBCType.TIMESTAMP)

        val readCount = column<Int>(name = "read_count", jdbcType = JDBCType.INTEGER)

        val content = column<String>(name = "content", jdbcType = JDBCType.LONGVARCHAR)
    }
}