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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 卡信息
 *
 * @author Chopper
 * @since 2020/11/17 7:30 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "卡信息")
@NoArgsConstructor
public class SmsLogParam extends BaseIdEntity {

    private static final long serialVersionUID = 2233811628066468683L;

    private String id;

    private String iphone;

    private List<SmsMessagesParam> messages;


}