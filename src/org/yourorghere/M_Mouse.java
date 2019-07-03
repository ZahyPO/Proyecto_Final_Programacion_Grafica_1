package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
 * @author fing.labcom
 */
public class M_Mouse implements MouseListener, MouseMotionListener {

    public M_Mouse() {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isMetaDown()) {
            Proyecto_Final.vistz = Proyecto_Final.vistz + 1;
        } else {
            Proyecto_Final.vistz = Proyecto_Final.vistz - 1;
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
