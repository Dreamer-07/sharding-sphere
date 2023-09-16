package pers.prover07.sharding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.prover07.sharding.mapper.OrderMapper;
import pers.prover07.sharding.mapper.UserMapper;
import pers.prover07.sharding.model.Order;
import pers.prover07.sharding.model.User;

import java.util.List;

/**
 * @author 小丶木曾义仲丶哈牛柚子露丶蛋卷
 * @version 1.0
 * @date 2023/9/16 15:18
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/list")
    public List<Order> queryList() {
        return orderMapper.selectList(null);
    }

}
