package pers.prover07.sharding.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.prover07.sharding.mapper.DictMapper;
import pers.prover07.sharding.mapper.OrderItemMapper;
import pers.prover07.sharding.mapper.OrderMapper;
import pers.prover07.sharding.model.Dict;
import pers.prover07.sharding.model.Order;
import pers.prover07.sharding.model.OrderItem;

import java.math.BigDecimal;

/**
 * @author 小丶木曾义仲丶哈牛柚子露丶蛋卷
 * @version 1.0
 * @date 2023/9/16 20:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private DictMapper dictMapper;

    /**
     * 水平分库分片测试
     */
    @Test
    public void test_insertOrder() {
        for (int i = 0; i < 4; i++) {
            Order order = new Order();
            order.setOrderNo("1111");
            order.setAmount(new BigDecimal(100));

            orderMapper.insert(order);
        }
    }

    @Test
    public void test_selectAll() {
        System.out.println(orderMapper.selectList(null));
    }

    @Test
    public void test_selectById() {
        System.out.println(orderMapper.selectById(1703028790003363841L));
    }

    @Test
    public void test_insertOrderItem() {
        for (int i = 0; i < 4; i++) {
            Order order = new Order();
            order.setOrderNo("1111");
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);

            for (int i1 = 0; i1 < 2; i1++) {
                Long orderId = order.getId();
                OrderItem orderItem = new OrderItem();
                orderItem.setCount(i1);
                orderItem.setPrice(new BigDecimal(10));
                orderItem.setOrderId(orderId);
                orderItemMapper.insert(orderItem);
            }
        }
    }

    @Test
    public void test_selectOrderItem() {
        System.out.println(orderMapper.queryOrderItem());
    }

    @Test
    public void test_insertBroadcast() {
        Dict dict = new Dict();
        dict.setValue("测试");

        dictMapper.insert(dict);
    }

    @Test
    public void test_selectBroadcastList() {
        System.out.println(dictMapper.selectList(null));
    }

}
