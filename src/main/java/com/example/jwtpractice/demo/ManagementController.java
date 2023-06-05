package com.example.jwtpractice.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
public class ManagementController {
    @GetMapping
    @PreAuthorize("hasAnyAuthority('admin:read','management:read')")
    public String get(){
        return "GET:: management controller";
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('admin:create','management:create')")
    public String post(){
        return "POST:: management controller";
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('admin:update','management:update')")
    public String put(){
        return "PUT:: management controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('admin:delete','management:delete')")
    public String delete(){
        return "DELETE:: management controller";
    }
}
