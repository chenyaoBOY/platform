package com.frog.platform.service;

import com.frog.platform.FeedbackService;
import com.frog.platform.dao.FeedbackMapper;
import com.frog.platform.entity.Feedback;
import com.frog.platform.entity.FeedbackExample;
import com.frog.platform.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public ResultUtil saveFeedback(Feedback feedback) {

        feedbackMapper.insert(feedback);

        return ResultUtil.ok();
    }

    @Override
    public List<Feedback> getList() {

        FeedbackExample ex=new FeedbackExample();
        List<Feedback> feedbacks = feedbackMapper.selectByExample(ex);
        return feedbacks;
    }
}
