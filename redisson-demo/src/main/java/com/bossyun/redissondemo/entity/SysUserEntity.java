package com.bossyun.redissondemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@TableName("sys_user")
public class SysUserEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "head_img_url")
    private String headImgUrl;

    @TableField(value = "mobile")
    private String mobile;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "enabled")
    private Integer enabled;

    @TableField(value = "type")
    private String type;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(value = "company")
    private String company;

    @TableField(value = "open_id")
    private Integer openId;

    @TableField(value = "is_del")
    private String isDel;

    @TableField(value = "tenant_id")
    private String tenant_id;

    @TableField(value = "num")
    private Integer num;
}
