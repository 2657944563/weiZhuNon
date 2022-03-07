package com.example.weizhunon.Controller;

import com.example.weizhunon.Pojo.Address;
import com.example.weizhunon.Server.impl.AddressService;
import com.example.weizhunon.Utills.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressContreoller {
    @Autowired
    AddressService addressService;

    /**
     * 查询当前用户已经提交的收货地址
     * @return
     */
    @GetMapping()
    public R allAddresses() {
        /**
         * do：通过redis对比token获取redis存储的用户id，通过id返回对应的地址
         */
        return new R(addressService.list());
    }

    /**
     * 提交用户地址
     * @param address
     * @return
     * 格式:
     * {
     *     "flag": true,
     *     "data": null,
     *     "msg": "准确数据根据登录用户token确认"
     * }
     */
    @PostMapping
    public R saveAddress(@RequestBody Address address) {
        if (address.getAddressid() != null) {
            return new R(false);
        }
        return new R(addressService.save(address));
    }

}
