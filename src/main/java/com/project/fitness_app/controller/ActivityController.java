package com.project.fitness_app.controller;

import com.project.fitness_app.dto.ActivityRequest;
import com.project.fitness_app.dto.ActivityResponse;
import com.project.fitness_app.service.ActivityService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(
            @Valid @RequestBody ActivityRequest request
    ) {
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(
            @Parameter(description = "ID of the user")
            @RequestHeader(value = "X-User-ID") String userId
    ) {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
