package com.tensor.org.exam.service.exam.impl;

import com.tensor.org.api.dao.enpity.notice.NoticePackage;
import com.tensor.org.exam.service.exam.ExamCorrectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service
public class ExamCorrectServiceImpl implements ExamCorrectService {

    @Override
    public void update(Observable o, Object arg) {
        correctPaper((NoticePackage) arg);
    }

    /**
     * 试卷批改
     * @param noticePackage
     */
    private void correctPaper(NoticePackage noticePackage) {
    }

}
