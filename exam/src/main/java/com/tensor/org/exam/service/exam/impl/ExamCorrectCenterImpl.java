package com.tensor.org.exam.service.exam.impl;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.exam.service.exam.ExamCorrectCenter;
import com.tensor.org.exam.service.exam.ExamCorrectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Observable;

/**
 * 试卷批改中心
 * 仅仅作为试卷批改任务的分发通知
 * @author liaochuntao
 */
@Slf4j
@Component
@Service
public class ExamCorrectCenterImpl extends Observable implements ExamCorrectCenter {

    @Autowired private ExamCorrectService examCorrectService;

    @PostConstruct
    public void addObserver() {
        addObserver(examCorrectService);
    }

    /**
     * 发布批改试卷任务
     * @param noticePackage
     * @return
     */
    @Override
    public ResultData publishWork(NoticePackage noticePackage) {
        setChanged();
        notifyObservers(noticePackage);
        return null;
    }
}
