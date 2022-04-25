package com.bossyun.log.service;

import com.bossyun.log.model.Audit;

/**
 * 审计日志接口
 */
public interface IAuditService {
    void save(Audit audit);
}
