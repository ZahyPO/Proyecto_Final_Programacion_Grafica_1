package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author fing.labcom
 */
public class M_Teclado implements KeyListener {

    public M_Teclado() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            Proyecto_Final.camx = -10;
            Proyecto_Final.camy = 60;
            Proyecto_Final.camz = 10;

        }
        if (e.getKeyChar() == '2') {
            Proyecto_Final.camx = 0;
            Proyecto_Final.camy = 4;
            Proyecto_Final.camz = 7;

        }
        if (e.getKeyChar() == '3') {
            Proyecto_Final.camx = 10;
            Proyecto_Final.camy = 3;
            Proyecto_Final.camz = 10;

        }
        if (e.getKeyChar() == '4') {

            int r = 30;

            Proyecto_Final.a = Proyecto_Final.a + 0.01f;
            
            Proyecto_Final.camx = r * Math.cos(Proyecto_Final.a);;
            Proyecto_Final.camz = r * Math.sin(Proyecto_Final.a);
        }
        if (e.getKeyChar() == '5') {

            Proyecto_Final.camx = 0;
            Proyecto_Final.camy = 12;
            Proyecto_Final.camz = 1;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Proyecto_Final.camx += 1;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Proyecto_Final.camx -= 1;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Proyecto_Final.camy += 1;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Proyecto_Final.camy -= 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            Proyecto_Final.camz -= 1;
        }

        if (e.getKeyCode() == KeyEvent.VK_Z) {
            Proyecto_Final.camz += 1;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
