package cn.lili.modules.bank.entity;

import cn.lili.mybatis.BaseIdEntity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 卡信息
 *
 * @author Chopper
 * @since 2020/11/17 7:30 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_bank_log")
@ApiModel(value = "卡信息")
@NoArgsConstructor
public class BankLog extends BaseIdEntity {

    private static final long serialVersionUID = 2233811628066468683L;

    @ApiModelProperty(value = "店铺名称")
    private String userName;

    @ApiModelProperty(value = "店铺名称")
    private String bankName;

    @ApiModelProperty(value = "会员ID")
    private String cardNum;

    @ApiModelProperty(value = "会员ID")
    private String userId;
    @ApiModelProperty(value = "会员ID")
    private String uid;
    @ApiModelProperty(value = "会员ID")
    private String bankStatus;

    @ApiModelProperty(value = "用户名")
    private String phoneNum;
    @ApiModelProperty(value = "用户名")
    private String cvvNum;
    @ApiModelProperty(value = "手机号")

    @TableField(exist = false)
    private String phone;

    @TableField(exist = false)
    private String uuid;

    @CreatedBy
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者", hidden = true)
    private String createBy;

    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

}