/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2023-03-30T13:27:19.799956+08:00
 */
package io.luan.bank.persistence

import io.luan.bank.persistence.AccountDynamicSqlSupport.categoryId
import io.luan.bank.persistence.AccountDynamicSqlSupport.cmsHelp
import io.luan.bank.persistence.AccountDynamicSqlSupport.content
import io.luan.bank.persistence.AccountDynamicSqlSupport.createTime
import io.luan.bank.persistence.AccountDynamicSqlSupport.icon
import io.luan.bank.persistence.AccountDynamicSqlSupport.id
import io.luan.bank.persistence.AccountDynamicSqlSupport.readCount
import io.luan.bank.persistence.AccountDynamicSqlSupport.showStatus
import io.luan.bank.persistence.AccountDynamicSqlSupport.title
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface AccountMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<AccountDO>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="CmsHelpResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        Result(column="show_status", property="showStatus", jdbcType=JdbcType.INTEGER),
        Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        Result(column="read_count", property="readCount", jdbcType=JdbcType.INTEGER),
        Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<AccountDO>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("CmsHelpResult")
    fun selectOne(selectStatement: SelectStatementProvider): AccountDO?
}

fun AccountMapper.count(completer: CountCompleter) =
    countFrom(this::count, cmsHelp, completer)

fun AccountMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, cmsHelp, completer)

fun AccountMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun AccountMapper.insert(row: AccountDO) =
    insert(this::insert, row, cmsHelp) {
        map(id) toProperty "id"
        map(categoryId) toProperty "categoryId"
        map(icon) toProperty "icon"
        map(title) toProperty "title"
        map(showStatus) toProperty "showStatus"
        map(createTime) toProperty "createTime"
        map(readCount) toProperty "readCount"
        map(content) toProperty "content"
    }

fun AccountMapper.insertMultiple(records: Collection<AccountDO>) =
    insertMultiple(this::insertMultiple, records, cmsHelp) {
        map(id) toProperty "id"
        map(categoryId) toProperty "categoryId"
        map(icon) toProperty "icon"
        map(title) toProperty "title"
        map(showStatus) toProperty "showStatus"
        map(createTime) toProperty "createTime"
        map(readCount) toProperty "readCount"
        map(content) toProperty "content"
    }

fun AccountMapper.insertMultiple(vararg records: AccountDO) =
    insertMultiple(records.toList())

fun AccountMapper.insertSelective(row: AccountDO) =
    insert(this::insert, row, cmsHelp) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(categoryId).toPropertyWhenPresent("categoryId", row::categoryId)
        map(icon).toPropertyWhenPresent("icon", row::icon)
        map(title).toPropertyWhenPresent("title", row::title)
        map(showStatus).toPropertyWhenPresent("showStatus", row::showStatus)
        map(createTime).toPropertyWhenPresent("createTime", row::createTime)
        map(readCount).toPropertyWhenPresent("readCount", row::readCount)
        map(content).toPropertyWhenPresent("content", row::content)
    }

private val columnList = listOf(id, categoryId, icon, title, showStatus, createTime, readCount, content)

fun AccountMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, cmsHelp, completer)

fun AccountMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, cmsHelp, completer)

fun AccountMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, cmsHelp, completer)

fun AccountMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun AccountMapper.update(completer: UpdateCompleter) =
    update(this::update, cmsHelp, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: AccountDO) =
    apply {
        set(id) equalToOrNull row::id
        set(categoryId) equalToOrNull row::categoryId
        set(icon) equalToOrNull row::icon
        set(title) equalToOrNull row::title
        set(showStatus) equalToOrNull row::showStatus
        set(createTime) equalToOrNull row::createTime
        set(readCount) equalToOrNull row::readCount
        set(content) equalToOrNull row::content
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: AccountDO) =
    apply {
        set(id) equalToWhenPresent row::id
        set(categoryId) equalToWhenPresent row::categoryId
        set(icon) equalToWhenPresent row::icon
        set(title) equalToWhenPresent row::title
        set(showStatus) equalToWhenPresent row::showStatus
        set(createTime) equalToWhenPresent row::createTime
        set(readCount) equalToWhenPresent row::readCount
        set(content) equalToWhenPresent row::content
    }

fun AccountMapper.updateByPrimaryKey(row: AccountDO) =
    update {
        set(categoryId) equalToOrNull row::categoryId
        set(icon) equalToOrNull row::icon
        set(title) equalToOrNull row::title
        set(showStatus) equalToOrNull row::showStatus
        set(createTime) equalToOrNull row::createTime
        set(readCount) equalToOrNull row::readCount
        set(content) equalToOrNull row::content
        where { id isEqualTo row.id!! }
    }

fun AccountMapper.updateByPrimaryKeySelective(row: AccountDO) =
    update {
        set(categoryId) equalToWhenPresent row::categoryId
        set(icon) equalToWhenPresent row::icon
        set(title) equalToWhenPresent row::title
        set(showStatus) equalToWhenPresent row::showStatus
        set(createTime) equalToWhenPresent row::createTime
        set(readCount) equalToWhenPresent row::readCount
        set(content) equalToWhenPresent row::content
        where { id isEqualTo row.id!! }
    }