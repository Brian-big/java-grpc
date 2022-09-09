package com.brianbig.server;

import com.brianbig.grpc_java.AddressBookServiceGrpc;
import com.brianbig.grpc_java.Person;
import io.grpc.stub.StreamObserver;

public class AddressBookServiceImpl extends AddressBookServiceGrpc.AddressBookServiceImplBase {
    @Override
    public void addPerson(Person request, StreamObserver<Person> responseObserver) {
        System.out.println("Request: " +  request);
        System.out.println("saving person object");
        responseObserver.onNext(
                Person.newBuilder()
                        .setEmail(request.getEmail())
                        .setName(request.getName())
                        .build());
        System.out.println("saving done");
        responseObserver.onCompleted();
    }
}
