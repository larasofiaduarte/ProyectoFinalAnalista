/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Styles {
    public static final Color bgDark = new Color(43, 43, 45);  
    public static final Color bgDarkHover = new Color(76, 76, 79); 
    public static final Color bgGreyLight = new Color(238, 238, 238);
    public static final Color bgGreyDark = new Color(229, 229, 229);
    public static final Color bgLight = new Color(250, 250, 250);
    public static final Color fontLight = new Color(230, 230, 230);  
    public static final Color fontLightHover = new Color(255, 255, 255); 
    public static final Color fontGreyLight = new Color(178, 182, 190);
    public static final Color fontGreyDark = new Color(88, 94, 106);
    public static final Color accentLight = new Color(112, 82, 171);
    public static final Color accentLightHover = new Color(145, 108, 217); 
    public static final Color accentDark = new Color(102, 67, 51);  
    public static final Color fontDark = new Color(43, 43, 45);
    public static final Color accentNotif = new Color(243, 112, 136);
    


    public static Font customFontMd;
    public static Font customFontSm;
    public static Font customFontXl;
    public static Font customFontL;

    static {
        try {
            File fontFile = new File("src/main/resources/fonts/AestheticRegular-8M5dM.ttf");
            customFontMd = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(18f);
            customFontSm = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(8f);
            customFontXl = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(58f);
            
            
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}
