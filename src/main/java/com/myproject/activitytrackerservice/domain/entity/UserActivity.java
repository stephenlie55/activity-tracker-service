package com.myproject.activitytrackerservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_ACTIVITY")
public class UserActivity implements Serializable {
    private static final long serialVersionUID = -6924726124959206653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 20)
    private Long id;

    @Column(name = "PHONE_NUMBER", length = 19)
    private String phoneNumber;

    @Column(name = "ACTIVITY_NAME", length = 50)
    private String activityName;

    @Column(name = "REQUEST_ID", length = 35)
    private String requestId;

    @Column(name = "STATUS", length = 1)
    private int status;

    @Lob
    @Column(name = "JSON_REQUEST", length = 35)
    private Clob jsonRequest;

    @Column(name = "JSON_RESPONSE", length = 35)
    private Clob jsonResponse;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
}
