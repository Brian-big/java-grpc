package com.brianbig.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class AddressBookServerServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8888)
                .addService(new AddressBookServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
