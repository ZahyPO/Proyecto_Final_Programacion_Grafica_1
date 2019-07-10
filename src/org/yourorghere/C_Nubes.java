package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class C_Nubes {

    ArrayList<E_Nube> nubes1 = new ArrayList<E_Nube>();
    ArrayList<E_Nube> nubes2 = new ArrayList<E_Nube>();
    ArrayList<E_Nube> nubes3 = new ArrayList<E_Nube>();
    ArrayList<E_Nube> nubes4 = new ArrayList<E_Nube>();

    GL gl;
    float x, y, z;
    float w, h, d;
    int n, m;
    float a, b;

    float xr, yr, zr;

    P_Cuadrado suelo;

    public C_Nubes(GL gl, float x, float y, float z, float w, float h, float d, int n, float a, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.n = n;
        this.a = a;

        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 90, 0, 0, 1f, 0.4f, 0.2f);

        for (int i = 0; i < n; i++) {

            xr = (float) Math.random() - 1;
            yr = (float) Math.random() - 1;
            zr = (float) Math.random() - 1;

            nubes1.add(new E_Nube(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, 0, 0));

        }

        for (int i = 0; i < n; i++) {

            xr = (float) Math.random();
            yr = (float) Math.random() - 1;
            zr = (float) Math.random() - 1;

            nubes2.add(new E_Nube(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, -45, 0));

        }
        for (int i = 0; i < n; i++) {

            xr = (float) Math.random();
            yr = (float) Math.random() - 1;
            zr = (float) Math.random();

            nubes3.add(new E_Nube(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, 90, 0));

        }
        for (int i = 0; i < n; i++) {

            xr = (float) Math.random() - 1;
            yr = (float) Math.random() - 1;
            zr = (float) Math.random();

            nubes4.add(new E_Nube(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, 45, 0));
        }

    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslatef(x, y, z);
        gl.glScalef(w, h, d);

//        suelo.DibujaEstrellas();
        for (E_Nube v : nubes1) {
            v.Dibuja();
        }
        for (E_Nube v : nubes2) {
            v.Dibuja();
        }
        for (E_Nube v : nubes3) {
            v.Dibuja();
        }
        for (E_Nube v : nubes4) {
            v.Dibuja();
        }

        gl.glEnd();

        gl.glPopMatrix();
    }

}
