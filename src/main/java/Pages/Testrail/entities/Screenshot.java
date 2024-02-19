package Pages.Testrail.entities;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
@Setter
public class Screenshot {

    private BufferedImage image;
    private String fileName;

    public Screenshot(BufferedImage image, String fileName) {
        this.fileName = fileName;
        this.image = image;
    }


}
