package org.example.grpcapp;


import com.example.grpc.UserRequest;
import com.example.grpc.UserResponse;
import com.example.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUserInfo(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        System.out.println("Received request for user: " + request.getUserId());


        UserResponse response = UserResponse.newBuilder()
                .setUserId(request.getUserId())
                .setName("John Doe")
                .setAge(25)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

