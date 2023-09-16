package pers.prover07.sharding.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 小丶木曾义仲丶哈牛柚子露丶蛋卷
 * @version 1.0
 * @date 2023/9/16 16:09
 */
@TableName("t_order")
@Data
public class Order {

    private String orderNo;

    private String username;

}
