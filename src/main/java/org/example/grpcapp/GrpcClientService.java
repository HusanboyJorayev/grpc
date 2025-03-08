package org.example.grpcapp;


import com.example.grpc.UserRequest;
import com.example.grpc.UserResponse;
import com.example.grpc.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient(sortInterceptors = true,value = "userService")
    private UserServiceGrpc.UserServiceBlockingStub userServiceStub;


    public String getUserInfo(String userId) {
        UserRequest request = UserRequest.newBuilder().setUserId(userId).build();
        UserResponse response = userServiceStub.getUserInfo(request);
        return "User: " + response.getName() + ", Age: " + response.getAge();
    }
}

