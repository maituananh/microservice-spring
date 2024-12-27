package com.anhmt.user_service.query.api;

import com.anhmt.user_service.query.api.res.UserFetchingAllRes;
import com.anhmt.user_service.query.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserQueryController {

    private final UserQueryService userQueryService;

    @GetMapping
    public ResponseEntity<List<UserFetchingAllRes>> getAll() {
        return ResponseEntity.ok(userQueryService.getAll());
    }
}
