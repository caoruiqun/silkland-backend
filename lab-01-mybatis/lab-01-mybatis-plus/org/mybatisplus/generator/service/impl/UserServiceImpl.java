package org.mybatisplus.generator.service.impl;

import org.mybatisplus.generator.entity.User;
import org.mybatisplus.generator.mapper.UserMapper;
import org.mybatisplus.generator.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caoruiqun
 * @since 2023-06-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
