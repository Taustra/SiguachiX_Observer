/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Xavier Siguachi
 */
public class ThermometerPanel extends JPanel {

    private int temperature = 0;
    private final int maxTemperature = 40;
    private Color backgroundColor;

    public ThermometerPanel() {
        setPreferredSize(new Dimension(20, 50));
        this.backgroundColor = Color.WHITE;
    }

    public void setTemperature(int temperature) {
        this.temperature = Math.min(Math.max(temperature, 0), maxTemperature);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = 40;
        int height = getHeight() - 80;
        int x = (getWidth() - width) / 2;
        int y = 20;

        int arc = 20;
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(x, y, width, height, arc, arc);

        Color levelColor = getTemperatureColor(temperature);
        g2d.setColor(levelColor);

        int levelHeight = (int) ((temperature / (double) maxTemperature) * height);
        g2d.fillRoundRect(x, y + height - levelHeight, width, levelHeight, arc, arc);

        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(x, y, width, height, arc, arc);

        g.setColor(Color.BLACK);
        int numberOfMarks = 4;
        int markSpacing = height / numberOfMarks;

        for (int i = 0; i <= numberOfMarks; i++) {
            int markY = y + height - i * markSpacing;
            g.drawLine(x - 10, markY, x + width, markY);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(Integer.toString(i * 10), x - 30, markY + 5);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Temperatura: " + temperature + "°C", 10, getHeight() - 33);
    }

    private Color getTemperatureColor(int temperature) {

        int minTemp = 0;
        int maxTemp = 40;

        float ratio = (float) (temperature - minTemp) / (maxTemp - minTemp);

        int red = (int) (ratio * 255);
        int blue = (int) ((1 - ratio) * 255);
        int green = 0;

        return new Color(red, green, blue);
    }

}
