package com.myproject.activitytrackerservice.service;

import com.myproject.activitytrackerservice.domain.dto.UserActivityRequest;
import com.myproject.activitytrackerservice.domain.entity.UserActivity;
import com.myproject.activitytrackerservice.repository.UserActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialClob;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserActivityService {
    @Autowired
    private UserActivityRepository userActivityRepository;

    public void saveUserActivity(UserActivityRequest userActivityRequest) throws Exception {
        log.info("Begin save audit trail for request id [{}]", userActivityRequest.getRequestId());
        UserActivity userActivity = new UserActivity();
        userActivity.setPhoneNumber(userActivityRequest.getPhoneNumber());
        userActivity.setActivityName(userActivityRequest.getActivityName());
        userActivity.setJsonRequest(new SerialClob(userActivityRequest.getJsonResponse().toCharArray()));
        userActivity.setJsonResponse(new SerialClob(userActivityRequest.getJsonResponse().toCharArray()));
        userActivity.setRequestId(userActivityRequest.getRequestId());
        userActivity.setStatus(userActivity.getStatus());
        userActivity.setCreatedDate(userActivityRequest.getCreatedDate());
    }

    public List<UserActivityRequest> getUserActivity(String phoneNumber) {
        List<UserActivity> userActiviyList = userActivityRepository.findByPhoneNumberOrderByCreatedDate(phoneNumber)
                .orElse(new ArrayList<>());
        return userActiviyList.stream()
            .map(userActivity -> {
                // to remove
                UserActivityRequest userActivityRequest = new UserActivityRequest();
                BeanUtils.copyProperties(userActivity, userActivityRequest);
                return userActivityRequest;
            }).collect(Collectors.toList());
    }

}
