package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int mapTileNum [][];

    public TileManager (GamePanel gp){

        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/maps/map_ver_2.txt");
    }

    public void getTileImage () {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass1.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water_o.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass_101.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads the map

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));      //read the text file

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

                String line = br.readLine(); //read line of text

                while (col < gp.maxScreenCol) {

                    String numbers[] = line.split(" "); //splits the string around matches of the given regular expression //split the string at space

                    int num = Integer.parseInt(numbers[col]); //string to integer

                    mapTileNum[col][row] = num;
                    col++;
                } if (col==gp.maxScreenCol){
                    col = 0;
                    row++;
                }


            }

            br.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


        public void draw(Graphics2D g2){

        int col =0;
        int row = 0;
        int x = 0;
        int y = 0;

        while((col<gp.maxScreenCol) && (row < gp.maxScreenRow)){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x+= gp.tileSize;

            if (col==gp.maxScreenCol){
                col = 0;
                x= 0;
                row++;
                y += gp.tileSize;
            }

        }
        }

}




