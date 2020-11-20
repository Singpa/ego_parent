package com.ego.dubbo.service;

import com.ego.pojo.Manager;

public interface ManagerDubboService {

    Manager selectManagerByUsername(String username);
}