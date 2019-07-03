package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class E_Arreglo_Cesped {

    ArrayList<P_Piramide> Cesped = new ArrayList<P_Piramide>();

    GL gl;
    float x, y, z;
    float w, h, d;
    int n, m;
    float a, b;

    public E_Arreglo_Cesped(GL gl, float x, float y, float z, float w, float h, float d, int n, int m, float a, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.n = n;
        this.m = m;
        this.a = a;
        this.b = b;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Cesped.add(new P_Piramide(gl, (x + a * i), 0, (z + b * j), a, 1, b, 0, 0, 0, 0.4f, 0.9f, 0));
            }
        }
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslatef(x, y, z);
        gl.glScalef(w, h, d);

        for (P_Piramide v : Cesped) {
            v.Dibuja();
        }

        gl.glEnd();

        gl.glPopMatrix();
    }
}
