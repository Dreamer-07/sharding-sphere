package pers.prover07.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 小丶木曾义仲丶哈牛柚子露丶蛋卷
 * @version 1.0
 * @date 2023/9/16 16:09
 */
@TableName("t_order")
@Data
public class Order {

    /**
     * 如果没有配置 sharding-sphere-jdbc 的分布式序列，就自动递增
     * 如果配置了 sharding-sphere-jdbc 的分布式序列，就会采用 sharding-sphere-jdbc 的分布式序列
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String orderNo;

    @TableField(exist = false)
    private String username;

    private BigDecimal amount;

}
