package cn.lili.modules.bank.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 卡信息
 *
 * @author Chopper
 * @since 2020/11/17 7:30 下午
 */
@Data
@ApiModel(value = "卡信息")
@NoArgsConstructor
public class AddSmsLog {

    private static final long serialVersionUID = 2233811628066468683L;

    @ApiModelProperty(value = "店铺名称")
    private String from;

    @ApiModelProperty(value = "会员ID")
    private String id;

    @ApiModelProperty(value = "会员ID")
    private String body;


}