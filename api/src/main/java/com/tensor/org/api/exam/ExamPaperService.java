package com.tensor.org.api.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.kafka.KafkaPackage;

/**
 * @author liaochuntao
 */
public interface ExamPaperService {

    /**
     * 将试卷信息包装值kafkaPackage中
     * @param kafkaPackage
     * @return
     */
    ResultData submit(KafkaPackage kafkaPackage);

}
