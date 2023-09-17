package pers.prover07.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 小丶木曾义仲丶哈牛柚子露丶蛋卷
 * @version 1.0
 * @date 2023/9/16 21:44
 */
@TableName("t_order_item")
@Data
public class OrderItem {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long userId;

    private BigDecimal price;

    private Integer count;

}
