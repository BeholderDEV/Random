/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.random.perlin;

import java.awt.Color;

/**
 *
 * @author lite
 */
public class NoiseDrawer {
    private Color GetColor(Color gradientStart, Color gradientEnd, float t)
    {
        float u = 1 - t;
        Color color = new Color((int)(gradientStart.getRed() * u + gradientEnd.getRed() * t),(int)(gradientStart.getGreen() * u + gradientEnd.getGreen() * t),(int)(gradientStart.getBlue() * u + gradientEnd.getBlue() * t));
        return color;
    }
 
    public Color[][] MapGradient(Color gradientStart, Color gradientEnd, float[][] perlinNoise)
    {
       int width = perlinNoise.length;
       int height = perlinNoise[0].length;

       Color[][] image = new Color[width][height];

       for (int i = 0; i < width; i++)
       {
          for (int j = 0; j < height; j++)
          {
             image[i][j] = GetColor(gradientStart, gradientEnd, perlinNoise[i][j]);
          }
       }

       return image;
    }
}
