package com.example.weizhunon.Utills;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Boolean flag;
    private String msg = "准确数据根据登录用户token确认";
    private Integer status = 200;
    private Object data;
    public R(Boolean flags) {
        this.flag = flags;
    }
    public R(Object data) {
        this.flag = true;
        this.data = data;
    }

    public R message(String string) {
        this.msg = string;
        return this;
    }
    public R status(Integer integer) {
        this.status = integer;
        return this;
    }
}
