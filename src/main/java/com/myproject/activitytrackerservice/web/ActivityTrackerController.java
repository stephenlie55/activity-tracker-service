package com.myproject.activitytrackerservice.web;

import com.myproject.activitytrackerservice.domain.dto.UserActivityRequest;
import com.myproject.activitytrackerservice.domain.entity.UserActivity;
import com.myproject.activitytrackerservice.service.UserActivityService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/api/activitytracker")
@Slf4j
public class ActivityTrackerController {

    @Autowired
    private UserActivityService userActivityService;

    @ApiOperation(value = "get user IgnoreCase by UserAuthentication.getUserIgnoreCase.username")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserActivityRequest> getUserActivity(@PathVariable String phoneNumber, HttpServletRequest request, HttpServletResponse response) {
        log.info("Inside method getUserActivity with parameter {}", phoneNumber);
        return userActivityService.getUserActivity(phoneNumber);
    }
}
