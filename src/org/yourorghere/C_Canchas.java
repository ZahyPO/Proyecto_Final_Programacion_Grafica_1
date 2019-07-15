package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Zay
 */
public class C_Canchas {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;

    E_Cancha cancha1, cancha2, cancha3, cancha4;

    public C_Canchas(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;

        this.cancha1 = new E_Cancha(gl, -0.5f, 0, -0.5f, 0.5f, 0.5f, 0.5f, 90, 0.2f, 0.4f, 0.6f);
        this.cancha2 = new E_Cancha(gl, -0.5f, 0, 0.5f, 0.5f, 0.5f, 0.5f, 90, 0.2f, 0.4f, 0.6f);
        this.cancha3 = new E_Cancha(gl, 0.5f, 0, -0.5f, 0.5f, 0.5f, 0.5f, 90, 0.4f, 0f, 0f);
        this.cancha4 = new E_Cancha(gl, 0.5f, 0, 0.5f, 0.5f, 0.5f, 0.5f, 90, 0.4f, 0f, 0f);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.cancha1.Dibuja();
        this.cancha2.Dibuja();
        this.cancha3.Dibuja();
        this.cancha4.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

}
