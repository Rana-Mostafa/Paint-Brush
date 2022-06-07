package Classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Color;
import java.awt.Point;
/**
 *
 * @author Rana Mostafa
 */
public class Hand 
{
    private Point SP;
    public final int width=15,heigth=15;
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Hand() {}

    public Hand(Point SP,Color col) 
    {
        this.SP = SP;
        this.color=col;
    }

    public Point getSP() {
        return SP;
    }

    public void setSP(Point SP) {
        this.SP = SP;
    } 
}
