package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends SuperObject{

    public OBJ_Door(){
        name = "Door";
        collision = true;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/black_tile_obj.png")));
        } catch (IOException e) {
            System.err.println("Error: Door image not found!");
            e.printStackTrace();
        }
    }
}
