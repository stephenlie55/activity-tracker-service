package com.myproject.activitytrackerservice.services;

import com.myproject.activitytrackerservice.domain.dto.UserActivityRequest;
import com.myproject.activitytrackerservice.domain.entity.UserActivity;
import com.myproject.activitytrackerservice.repositories.UserActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialClob;

@Service
@Slf4j
public class UserActivityService {
    @Autowired
    private UserActivityRepository userActivityRepository;

    public void saveUserActivity(UserActivityRequest userActivityRequest) throws Exception {
        log.info("Begin save audit trail for request id [{}]", userActivityRequest.getRequestId());
        UserActivity userActivity = new UserActivity();
        userActivity.setUserId(userActivityRequest.getUserId());
        userActivity.setActivityName(userActivityRequest.getActivityName());
        userActivity.setJsonRequest(new SerialClob(userActivityRequest.getJsonResponse().toCharArray()));
        userActivity.setJsonResponse(new SerialClob(userActivityRequest.getJsonResponse().toCharArray()));
        userActivity.setRequestId(userActivityRequest.getRequestId());
        userActivity.setStatus(userActivity.getStatus());
        userActivity.setCreatedDate(userActivityRequest.getCreatedDate());
    }

}
