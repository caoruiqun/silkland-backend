package com.caoruiqun.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caoruiqun.mybatis.entity.User;
import com.caoruiqun.mybatis.mapper.UserMapper;
import com.caoruiqun.mybatis.service.UserService;
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
