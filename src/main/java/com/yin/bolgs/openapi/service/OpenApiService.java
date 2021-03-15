package com.yin.bolgs.openapi.service;

import com.yin.bolgs.common.pojo.Result;

public interface OpenApiService {
    /**
     * open api test测试
     * @return 测试数据
     */
    Result<String> test();
}
