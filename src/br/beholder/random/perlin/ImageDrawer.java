/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.random.perlin;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author lite
 */
public class ImageDrawer {
    public Image generateImage(Color[][] colors){
        int w = colors.length;
        int h = colors[0].length;
        BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                image.setRGB(i, j, colors[i][j].getRGB());
            }
        }
        return  image;
    }
}
