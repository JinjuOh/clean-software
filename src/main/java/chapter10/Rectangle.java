package chapter10;

import java.awt.*;

public class Rectangle {
    private Point itsTopLeft;
    private double itsWidth;
    private double itsHeight;

    public double getItsWidth() {
        return itsWidth;
    }

    public void setItsWidth(double itsWidth) {
        this.itsWidth = itsWidth;
    }

    public double getItsHeight() {
        return itsHeight;
    }

    public void setItsHeight(double itsHeight) {
        this.itsHeight = itsHeight;
    }
}

class Square extends Rectangle {
    @Override
    public void setItsWidth(double itsWidth) {
        super.setItsWidth(itsWidth);
        super.setItsHeight(itsWidth);
    }

    @Override
    public void setItsHeight(double itsHeight) {
        super.setItsHeight(itsHeight);
        super.setItsWidth(itsHeight);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setItsWidth(5);
        r.setItsHeight(4);
    }
}