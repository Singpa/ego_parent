package com.ego.dubbo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ego.dubbo.service.ManagerDubboService;
import com.ego.mapper.ManagerMapper;
import com.ego.pojo.Manager;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class ManagerDubboServiceImpl implements ManagerDubboService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Manager selectManagerByUsername(String username) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return managerMapper.selectOne(queryWrapper);
    }
}
