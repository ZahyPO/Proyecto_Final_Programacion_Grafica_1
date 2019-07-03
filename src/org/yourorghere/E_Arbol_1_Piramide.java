package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Arbol_1_Piramide {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;

    P_Cubo tallo;

    P_Piramide copa1, copa2, copa3;

    public E_Arbol_1_Piramide(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;

        this.tallo = new P_Cubo(gl, 0, 0.3f, 0, 0.05f, 0.3f, 0.05f, 0, 0, 0, 0.4f, 0.2f, 0);

        this.copa1 = new P_Piramide(gl, 0, 0.8f, 0, 0.2f, 0.2f, 0.2f, 0, 0, 0, 0.4f, 0.9f, 0);
        this.copa2 = new P_Piramide(gl, 0, 1f, 0, 0.15f, 0.2f, 0.15f, 0, 0, 0, 0.4f, 0.9f, 0);
        this.copa3 = new P_Piramide(gl, 0, 1.2f, 0, 0.1f, 0.2f, 0.1f, 0, 0, 0, 0.4f, 0.9f, 0);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslatef(x, y, z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(w, h, p);

        this.tallo.Dibuja();
        this.copa1.Dibuja();
        this.copa2.Dibuja();
        this.copa3.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
