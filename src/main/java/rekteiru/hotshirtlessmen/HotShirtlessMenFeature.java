package rekteiru.hotshirtlessmen;

import javax.swing.*;
import java.awt.image.BufferedImage;
public class HotShirtlessMenFeature {

    public static final int[][] imgArray =  {
            // parts of the normal skin
            { 0, 0,64,16}, // 0
            {40,16,24,48}, // 1
            { 0,52,40, 8}, // 2
            {32,60, 8, 4}, // 3
            { 4,48, 4, 4}, // 4
            {20,48, 4, 4}, // 5
            {36,48, 4, 4}, // 6
            { 0,36,16, 8}, // 7
            { 4,32, 4, 4}, // 8
            { 0,20,16, 8}, // 9
            { 4,16, 4, 4}, // 10

            // parts of the gigachad skin
            {16,16,24,32}, // 11 gigachad
            { 8,16, 4, 4}, // 12 bottomfoot left
            { 0,28,16, 4}, // 13 sidefoot left
            {24,48, 4, 4}, // 14 bottomfoot right
            {16,60,16, 4}  // 15 sidefoot right
    };

    public static BufferedImage hotshirtlessmen(BufferedImage image) {

        if (image.getWidth() != 64 || image.getHeight() != 64) {
            return image;
        } else {

            int[] skinArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

            BufferedImage finalBimg = new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);

            if (main.HOTFEETLESSMEN_TOGGLE && main.hotfeet != null) {
                finalBimg.getGraphics().drawImage(main.hotfeet.getSubimage(imgArray[12][0],imgArray[12][1],imgArray[12][2],imgArray[12][3]),imgArray[12][0],imgArray[12][1],null);
                skinArr[12] = -1;
                finalBimg.getGraphics().drawImage(main.hotfeet.getSubimage(imgArray[13][0],imgArray[13][1],imgArray[13][2],imgArray[13][3]),imgArray[13][0],imgArray[13][1],null);
                skinArr[13] = -1;
                finalBimg.getGraphics().drawImage(main.hotfeet.getSubimage(imgArray[14][0],imgArray[14][1],imgArray[14][2],imgArray[14][3]),imgArray[14][0],imgArray[14][1],null);
                skinArr[14] = -1;
                finalBimg.getGraphics().drawImage(main.hotfeet.getSubimage(imgArray[15][0],imgArray[15][1],imgArray[15][2],imgArray[15][3]),imgArray[15][0],imgArray[15][1],null);
                skinArr[15] = -1;
            }

            if (main.HOTSHIRTLESSMEN_TOGGLE && main.gigachad != null) {
                finalBimg.getGraphics().drawImage(main.gigachad,imgArray[11][0],imgArray[11][1],null);
                skinArr[11] = -1;
            }

            for (int x : skinArr) {
                if (x != -1) {
                    finalBimg.getGraphics().drawImage(GrayFilter.createDisabledImage(image.getSubimage(imgArray[x][0],imgArray[x][1],imgArray[x][2],imgArray[x][3])),imgArray[x][0],imgArray[x][1],null);
                }
            }

            return finalBimg;
        }
    }

}