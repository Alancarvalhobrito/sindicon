package sindicon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.io.DataInputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext ctx = SpringApplication.run(AppConfiguration.class, args);

        DataInputStream reader = new DataInputStream(System.in);
        do {
            char key = reader.readChar();
            if (key == 'q') {
                break;
            }
            sleep(1000);
        } while (true);
        SpringApplication.exit(ctx);
    }
}