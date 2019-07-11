package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class C_Personas {

    GL gl;
    float x, y, z;
    float w, h, p;

    P_Cuadrado suelo;

    public C_Personas(GL gl, float x, float y, float z, float w, float h, float p) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;

        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 90, 0, 0, 1, 1, 0);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glScaled(w, h, p);

        this.suelo.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }
}
