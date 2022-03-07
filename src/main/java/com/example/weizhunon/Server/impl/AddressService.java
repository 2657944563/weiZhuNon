package com.example.weizhunon.Server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.weizhunon.Dao.AddressDao;
import com.example.weizhunon.Dao.UserDao;
import com.example.weizhunon.Pojo.User;
import com.example.weizhunon.Server.IAddressService;
import com.example.weizhunon.Server.IUserServer;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.weizhunon.Mapper.AddressMapper;
import com.example.weizhunon.Pojo.Address;
@Service
public class AddressService extends ServiceImpl<AddressDao, Address> implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    
    public int deleteByPrimaryKey(Integer addressid) {
        return addressMapper.deleteByPrimaryKey(addressid);
    }

    
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    
    public Address selectByPrimaryKey(Integer addressid) {
        return addressMapper.selectByPrimaryKey(addressid);
    }

    
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

}
