package images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

public class ResizeImage {

    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    public static void main(String[] args) {
        try {
            BufferedImage originalImage = ImageIO.read(new File("/Users/marcinpastwa/Desktop/colDiag.png"));
            int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
            BufferedImage resizeImageJpg = resizeImage(originalImage, type);
            ImageIO.write(resizeImageJpg, "jpg", new File("/Users/marcinpastwa/Desktop/colDiagRes.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }
}
