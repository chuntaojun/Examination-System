package com.tensor.org.dao.service;

import com.tensor.org.api.dao.log.NoticeDao;
import com.tensor.org.dao.mapper.log.NoticeLogPOMapper;

import javax.annotation.Resource;

public class LogNoticeDaoImpl implements NoticeDao {

    @Resource private NoticeLogPOMapper noticeLogPOMapper;



}
