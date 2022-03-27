package com.myproject.activitytrackerservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserActivityRequest implements Serializable {
    private static final long serialVersionUID = -3261074151511020167L;

    private String phoneNumber;
    private String activityName;
    private String requestId;
    private int status;
    private String jsonRequest;
    private String jsonResponse;
    private LocalDateTime createdDate;
}
