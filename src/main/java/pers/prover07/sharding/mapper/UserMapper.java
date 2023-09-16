package pers.prover07.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.prover07.sharding.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
