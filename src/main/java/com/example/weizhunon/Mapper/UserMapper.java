package com.example.weizhunon.Mapper;

import com.example.weizhunon.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * delete by primary key
     *
     * @param userid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(User record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    /**
     * select by primary key
     *
     * @param userid primary key
     * @return object by primary key
     */
    User selectByPrimaryKey(Integer userid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(User record);
}