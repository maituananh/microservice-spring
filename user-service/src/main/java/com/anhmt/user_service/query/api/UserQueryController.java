package com.anhmt.user_service.query.api;

import com.anhmt.user_service.query.api.response.UserQueryResponse;
import com.anhmt.user_service.query.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserQueryController {

    private final UserQueryService userQueryService;

    @GetMapping
    public ResponseEntity<List<UserQueryResponse>> getAll() {
        return ResponseEntity.ok(userQueryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQueryResponse> getUserDetail(@PathVariable UUID id) {
        return ResponseEntity.ok(userQueryService.getUserDetail(id));
    }
}
