package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Book extends SuperObject{

    public OBJ_Book(){
        name = "Book";
        collision = true;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/book.png")));
        } catch (IOException e) {
            System.err.println("Error: Book image not found!");
            e.printStackTrace();
        }
    }
}
