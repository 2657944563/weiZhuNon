package com.example.weizhunon.Controller;

import com.example.weizhunon.Pojo.User;
import com.example.weizhunon.Server.IUserServer;
import com.example.weizhunon.Utills.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserServer userServer;

    /**
     * 传入传入id查询对应的用户数据
     * @param id 用户id
     * @return json格式
     */
    @GetMapping("/{id}")
    public R user(@PathVariable("id")Integer id) {
        return new R(userServer.getById(1));
    }

    /**
     * 返回所有用户
     * @return json格式所有用户数据
     */
    @GetMapping("")
    public R userQuery(){
        return new R(userServer.list());
    }

    /**
     * 提供json数据，存储用户
     * @param user 用户数据
     * @return
     * 格式：
     *     {
     *         "openid": 12312332,
     *         "name": "ww",
     *         "power": 1,
     *         "phone": "12345678911"
     *     }
     */
    @PostMapping
    public R saveUser(@RequestBody User user) {
        if (user.getUserid() != null) {
            return new R(false);
        }
        userServer.save(user);
        return new R(true);
    }

    /**
     * 提交json格式数据修改数据
     * @param user 必须拥有用户id
     * @return
     * 数据格式：必须拥有userid，其他数值是修改项
     *      {
     *         "userid": 1,
     *         "name": "zs",
     *         "power": 1,
     *         "phone": "12345678911"
     *     }
     */
    @PutMapping
    public R updateUser(@RequestBody User user) {
        return new R(userServer.updateById(user));
    }


}
