package com.gxu.sp04.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.BitSet;

/**
 * @author caoyuyi
 */
@MappedJdbcTypes(JdbcType.BLOB)
@MappedTypes(value = BitSet.class)
public class BlobTypeHandler extends BaseTypeHandler<BitSet> {
    /**
     * 数据插入数据库时调用此方法
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BitSet parameter, JdbcType jdbcType) throws SQLException {
        ps.setBytes(i, parameter.toByteArray());
    }


    /**
     * 从数据库中读取数据时调用此方法
     */
    @Override
    public BitSet getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Blob blob = rs.getBlob(columnName);
        return swapBlobToBitSet(blob);
    }

    @Override
    public BitSet getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Blob blob = rs.getBlob(columnIndex);
        return swapBlobToBitSet(blob);
    }

    /**
     * 读取方法同上，方法重载
     */
    @Override
    public BitSet getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Blob blob = cs.getBlob(columnIndex);
        return swapBlobToBitSet(blob);
    }

    private BitSet swapBlobToBitSet(Blob blob) throws SQLException {
        byte[] returnValue = null;
        if (null != blob) {
            returnValue = blob.getBytes(1, (int) blob.length());
        }
        try {
            //将取出的流对象转为utf-8的字符串对象
            return BitSet.valueOf(returnValue);
        } catch (Exception e) {
            throw new RuntimeException("Blob Encoding Error!");
        }
    }
}

