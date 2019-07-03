package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class E_Base {

    GL gl;
    float x, y, z;
    float w, h, p;
    float r, g, b;
    float ry;

    P_Cubo base1, base2, tronco;

    public E_Base(GL gl, float x, float y, float z, float w, float h, float p, float r, float g, float b, float ry) {
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

        this.base1 = new P_Cubo(gl, 0, 0.1f, 0, 1, 0.1f, 1, 0, 0, 0, r, g, b);
        this.tronco = new P_Cubo(gl, 0, 0.5f, 0, 0.7f, 0.3f, 0.7f, 0, 0, 0, r, g, b);
        this.base2 = new P_Cubo(gl, 0, 0.9f, 0, 1, 0.1f, 1, 0, 0, 0, r, g, b);

    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.base1.Dibuja();
        this.base2.Dibuja();
        this.tronco.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
