package com.frog.platform;

import com.frog.platform.entity.Feedback;
import com.frog.platform.utils.ResultUtil;

import java.util.List;

public interface FeedbackService {

    /**
     * 保存反馈内容
     */
    ResultUtil saveFeedback(Feedback feedback);

    /**
     * 获取反馈内容
     */

    List<Feedback> getList();
}
