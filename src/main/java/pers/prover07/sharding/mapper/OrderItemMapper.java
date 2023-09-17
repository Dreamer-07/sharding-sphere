package pers.prover07.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.prover07.sharding.model.OrderItem;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
