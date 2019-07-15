package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
 * @author zahy
 */
public class M_Mouse implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isMetaDown()) {
            Proyecto_Final.vistz = Proyecto_Final.vistz + 1;
        } else {
            Proyecto_Final.vistz = Proyecto_Final.vistz - 1;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    @Override
    public void mouseMoved(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        if (x < 250) {
            Proyecto_Final.vistx = Proyecto_Final.vistx - 1;
        }
        if (x > 350) {
            Proyecto_Final.vistx = Proyecto_Final.vistx + 1;

        }

        if (y < 250) {
            Proyecto_Final.visty = Proyecto_Final.visty + 1;
        }
        if (y > 350) {
            Proyecto_Final.visty = Proyecto_Final.visty - 1;

        }

    }

}
