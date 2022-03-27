package com.myproject.activitytrackerservice.repository;

import com.myproject.activitytrackerservice.domain.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    Optional<List<UserActivity>> findByPhoneNumberOrderByCreatedDate(String phoneNumber);

}
