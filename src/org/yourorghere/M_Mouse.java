package org.yourorghere;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseMotionListener;


/*
 * @author fing.labcom
 */
public class M_Mouse implements MouseListener, MouseMotionListener {

    public M_Mouse() {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int y = e.getY();
        System.out.println(y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println(e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isMetaDown()) {
            Proyecto_Final.vistx = Proyecto_Final.vistx + 1;
        } else {
            Proyecto_Final.vistx = Proyecto_Final.vistx - 1;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}
