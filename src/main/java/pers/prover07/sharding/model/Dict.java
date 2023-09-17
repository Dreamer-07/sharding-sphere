package pers.prover07.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 小丶木曾义仲丶哈牛柚子露丶蛋卷
 * @version 1.0
 * @date 2023/9/17 9:47
 */
@TableName("t_dict")
@Data
public class Dict {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String value;

}
