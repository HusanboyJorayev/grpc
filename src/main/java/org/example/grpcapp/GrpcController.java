package org.example.grpcapp;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class GrpcController {

    private final GrpcClientService grpcClientService;

    public GrpcController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @GetMapping("/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        return grpcClientService.getUserInfo(userId);
    }
}

