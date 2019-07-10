package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class C_Estrellas {

    ArrayList<E_Estrella> estrellas1 = new ArrayList<E_Estrella>();
    ArrayList<E_Estrella> estrellas2 = new ArrayList<E_Estrella>();
    ArrayList<E_Estrella> estrellas3 = new ArrayList<E_Estrella>();
    ArrayList<E_Estrella> estrellas4 = new ArrayList<E_Estrella>();

    GL gl;
    float x, y, z;
    float w, h, d;
    int n, m;
    float a, b;

    float xr, yr, zr;

    P_Cuadrado suelo;

    public C_Estrellas(GL gl, float x, float y, float z, float w, float h, float d, int n, float a, float b) {
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
            System.out.println(xr);
            estrellas1.add(new E_Estrella(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, 0, 0));

        }

        for (int i = 0; i < n; i++) {

            xr = (float) Math.random();
            yr = (float) Math.random() - 1;
            zr = (float) Math.random() - 1;
            System.out.println(xr);
            estrellas2.add(new E_Estrella(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, 0, 0));

        }
        for (int i = 0; i < n; i++) {

            xr = (float) Math.random();
            yr = (float) Math.random() - 1;
            zr = (float) Math.random();
            System.out.println(xr);
            estrellas3.add(new E_Estrella(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, 0, 0));

        }
        for (int i = 0; i < n; i++) {

            xr = (float) Math.random() - 1;
            yr = (float) Math.random() - 1;
            zr = (float) Math.random();
            System.out.println(xr);
            estrellas4.add(new E_Estrella(gl, xr, yr, zr, a / 2, 1f, b / 2, 0, 0, 0));

        }

    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslatef(x, y, z);
        gl.glScalef(w, h, d);

//        suelo.Dibuja();
        for (E_Estrella v : estrellas1) {
            v.Dibuja();
        }
        for (E_Estrella v : estrellas2) {
            v.Dibuja();
        }
        for (E_Estrella v : estrellas3) {
            v.Dibuja();
        }
        for (E_Estrella v : estrellas4) {
            v.Dibuja();
        }

        gl.glEnd();

        gl.glPopMatrix();
    }

}
