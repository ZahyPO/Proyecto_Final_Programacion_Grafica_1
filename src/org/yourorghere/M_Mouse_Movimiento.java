package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author zalis
 */
public class M_Mouse_Movimiento implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        if (x < 250) {
            Proyecto_Final.vistx = Proyecto_Final.vistx - 0.1;
        }
        if (x > 350) {
            Proyecto_Final.vistx = Proyecto_Final.vistx + 0.1;

        }
        System.out.println(e.getY());
        if (y < 250) {
            Proyecto_Final.visty = Proyecto_Final.visty + 0.1;
        }
        if (y > 350) {
            Proyecto_Final.visty = Proyecto_Final.visty - 0.1;

        }

    }

}
