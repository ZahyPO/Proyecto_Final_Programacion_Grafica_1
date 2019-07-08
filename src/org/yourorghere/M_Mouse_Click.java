package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * @author zahy
 */
public class M_Mouse_Click implements MouseListener {

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

}
