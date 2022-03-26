package com.myproject.activitytrackerservice.repositories;

import com.myproject.activitytrackerservice.domain.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

}
