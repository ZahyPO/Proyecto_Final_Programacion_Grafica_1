package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class E_Banca {

    GL gl;
    float x, y, z;
    float w, h, p;
    float r, g, b;
    float ry;

    E_Tablas asiento, respaldar;
    P_Cilindro pata1, pata2;

    public E_Banca(GL gl, float x, float y, float z, float w, float h, float p, float ry, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.r = r;
        this.g = g;
        this.b = b;

        this.ry = ry;

        this.asiento = new E_Tablas(gl, 0f, 0.5f, 0, 5f, 0.15f, 0.5f, 0, 0, 0, 7);
        this.respaldar = new E_Tablas(gl, 0f, 1.25f, -0.5f, 5f, 0.15f, 0.25f, 90, 0, 0, 7);

        this.pata1 = new P_Cilindro(gl, -1, 0f, -0.5f, 0.1f, 0.1f, 1f, 0, 0, 0, r, g, b, 0.5f, 0.5f);
        this.pata2 = new P_Cilindro(gl, -1, -0f, 0.5f, 0.1f, 0.1f, 0.5f, 0, 0, 0, r, g, b, 0.5f, 0.5f);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glScaled(w, h, p);

        this.asiento.Dibuja();
        this.respaldar.Dibuja();

        this.pata1.x = -this.pata1.x;
        this.pata2.x = -this.pata2.x;
        this.pata1.Dibuja();
        this.pata2.Dibuja();

        this.pata1.x = -this.pata1.x;
        this.pata2.x = -this.pata2.x;
        this.pata1.Dibuja();
        this.pata2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }
}
