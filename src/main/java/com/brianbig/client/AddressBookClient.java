package com.brianbig.client;

import com.brianbig.grpc_java.AddressBookServiceGrpc;
import com.brianbig.grpc_java.Person;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AddressBookClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .build();
        AddressBookServiceGrpc.AddressBookServiceBlockingStub stub = AddressBookServiceGrpc.newBlockingStub(channel);
        Person response = stub.addPerson(
                Person.newBuilder()
                        .setName("Michael")
                        .setEmail("Samuel")
                        .addPhones(Person.PhoneNumber.newBuilder().setNumber("098767563").build())
                        .build());

        System.out.println(response);
    }
}
