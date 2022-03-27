package com.myproject.activitytrackerservice.jmsClient;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.activitytrackerservice.domain.dto.UserActivityRequest;
import com.myproject.activitytrackerservice.service.UserActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class ActivityTrackerJmsListener {

    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private ObjectMapper objectMapper;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "${user.activity.topic}", containerFactory = "jmsListenerContainerFactory")
    public void receiveAuditTrail(String jsonJMSMessage) {
        try {

            log.info("Begin to receive user activity, detail activity [{}]", jsonJMSMessage);
            userActivityService.saveUserActivity(objectMapper.readValue(jsonJMSMessage, UserActivityRequest.class));

            getLatch().countDown();
        } catch (Exception ex) {
            log.error("Exception happened when receive audit trail, data [{}] ", jsonJMSMessage, ex);
        }
        log.info("End receive audit trail");
    }

}
