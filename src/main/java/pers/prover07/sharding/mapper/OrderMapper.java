package pers.prover07.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pers.prover07.sharding.model.Order;
import pers.prover07.sharding.vo.OrderVo;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select({"SELECT o.id as order_id, SUM(oi.price * oi.count) as price", "FROM t_order o JOIN t_order_item oi ON o.id = oi.order_id", "GROUP BY o.id"})
    List<OrderVo> queryOrderItem();

}
