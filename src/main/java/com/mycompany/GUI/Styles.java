/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.border.EmptyBorder;

public class Styles {
    public static final Color bgDark = new Color(43, 43, 45);  //Petrol grey, sidebar
    public static final Color bgDarkHover = new Color(76, 76, 79); 
    public static final Color bgGreyLight = new Color(238, 238, 238); //2nd lightest, for textfields
    public static final Color bgGreyDark = new Color(209, 209, 209); //3rd lightest, for textfields
    public static final Color bgLight = new Color(250, 250, 250); //Off White
    
    public static final Color fontLight = new Color(252, 252, 252);  //for dark bg, sidebar
    public static final Color fontLightHover = new Color(200, 171, 255); //lilac
    public static final Color fontGreyLight = new Color(148, 148, 148); //for disabled fields?
    public static final Color fontGreyDark = new Color(85, 88, 92); //for textfield label
    public static final Color fontDark = new Color(43, 43, 45); //Petrol grey
    
    public static final Color accentLight = new Color(112, 82, 171); //Dark Violet
    public static final Color accentLightHover = new Color(145, 108, 217); //Lilac
    public static final Color accentDark = new Color(112, 82, 171);  //Dark Violet
    public static final Color accentNotif = new Color(243, 112, 136); //Pink
    
    public static final Color btnSec = new Color(255, 255, 255); //Pink
    
    //btn
    public static final Dimension btnSize = new Dimension(150,35);
    public static final Dimension btnSize2 = new Dimension(250,35);
    
    //padding
    public static final EmptyBorder padding = new EmptyBorder(50, 20, 0, 0);
    public static final EmptyBorder paddingFull = new EmptyBorder(50, 50, 50, 50);
    public static final EmptyBorder paddingTop = new EmptyBorder(30, 0, 0, 0);
    public static final EmptyBorder paddingBottom = new EmptyBorder(0, 0, 30, 0);



    public static Font customFontMd;
    public static Font customFontSm;
    public static Font customFontXl;
    public static Font customFontL;
    
    public static Font fontTitle = new Font("Dialog", Font.BOLD, 20);
    public static Font fontTitleIt = new Font("Dialog", Font.BOLD | Font.ITALIC, 20);
    public static Font fontBtn = new Font("Dialog", Font.BOLD, 14);

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
