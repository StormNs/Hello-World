/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author hoanglong
 */
public class EclipsePanel extends javax.swing.JPanel {

    Point p1 = null;
    Point p2 = null;
    Color color;
    Color test;
    Boolean type;
    boolean flag;
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<Color> mau = new ArrayList<Color>();
    private ArrayList type2 = new ArrayList();

    public EclipsePanel(boolean type, Color color) {
        initComponents();
        this.color = color;
        this.type = type;
    }

    public void makeType(boolean type) {
        this.type = type;
        //type2.add(type);
    }

    public void makeColor(Color color) {
        this.color = color;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p1 = evt.getPoint();
        points.add(p1);
        mau.add(color);
        type2.add(type);
        flag = type;
        test = color;
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        p2 = evt.getPoint();
        points.add(p2);
        mau.add(color);
        type2.add(type);
        p1 = null;
    }//GEN-LAST:event_formMouseReleased
    int left;
    int top;
    int height;
    int width;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        p2 = evt.getPoint();

        left = 0;
        if (p1.x < p2.x) {
            left = p1.x;
        } else {
            left = p2.x;
        }
        top = p1.y < p2.y ? p1.y : p2.y;
        width = p1.x - p2.x;
        if (width < 0) {
            width = -width;
        }
        height = p1.y - p2.y;
        if (height < 0) {
            height = -height;
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (points.size() >= 2) {
            for (int i = 0; i < points.size() - 2; i++) {
                if (i % 2 == 0) {
                    g.setColor(mau.get(i));
                    Point p3 = points.get(i);
                    Point p4 = points.get(i + 1);
                    int left2 = p3.x < p4.x ? p3.x : p4.x;
                    int top2 = p3.y < p4.y ? p3.y : p4.y;
                    int width2 = p3.x - p4.x;
                    if (width2 < 0) {
                        width2 = -width2;
                    }
                    int height2 = p3.y - p4.y;
                    if (height2 < 0) {
                        height2 = -height2;
                    }
                    //type2.get(i);
                    if ((boolean) type2.get(i) == true) {
                        g.drawOval(left2, top2, width2, height2);
                        // g.drawOval(left, top, width, height);
                    } else {
                        g.fillOval(left2, top2, width2, height2);
                        //g.fillOval(left, top, width, height);
                    }
                }
            }
        }
        System.out.println(points.size());
        g.setColor(test);
        if (flag == true) {
            g.drawOval(left, top, width, height);
        } else {
            g.fillOval(left, top, width, height);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
