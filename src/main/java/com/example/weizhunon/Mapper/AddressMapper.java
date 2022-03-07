package com.example.weizhunon.Mapper;

import com.example.weizhunon.Pojo.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    /**
     * delete by primary key
     * @param addressid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer addressid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Address record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Address record);

    /**
     * select by primary key
     * @param addressid primary key
     * @return object by primary key
     */
    Address selectByPrimaryKey(Integer addressid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Address record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Address record);
}