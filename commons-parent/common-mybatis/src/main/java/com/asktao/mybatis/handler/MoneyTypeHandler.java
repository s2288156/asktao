package com.asktao.mybatis.handler;

import com.asktao.lib.util.RmbMoneyUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wcy
 */
@MappedTypes(Money.class)
@MappedJdbcTypes({JdbcType.DECIMAL})
public class MoneyTypeHandler extends BaseTypeHandler<Money> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Money parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getAmount());
    }

    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        final String money = rs.getString(columnName);
        return StringUtils.isBlank(money) && rs.wasNull() ? null : RmbMoneyUtil.parseMoney(money);
    }

    @Override
    public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        final String money = rs.getString(columnIndex);
        return StringUtils.isBlank(money) && rs.wasNull() ? null : RmbMoneyUtil.parseMoney(money);
    }

    @Override
    public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        final String money = cs.getString(columnIndex);
        return StringUtils.isBlank(money) && cs.wasNull() ? null : RmbMoneyUtil.parseMoney(money);
    }

}