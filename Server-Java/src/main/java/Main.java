import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(8080)
                    .addService(new LoginService())
                    .addService(new PostsService())
                    .addService(new ChatHistoryService())
                    .addService(new MessagingService())
                    .addService(new ImagesService())
                    .addService(new SearchAndChatService())
                    .build();

            server.start();
            System.out.println("Server started at " + server.getPort());

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
