package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Zay
 */
public class C_Lago {

    GL gl;
    float x, y, z;
    float w, h, p;
    E_Lago lago1;

    E_Lago lago2, lago3;

    E_Barco barquito1, barquito2, barquito3, barquito4, barquito5;

    public C_Lago(GL gl, float x, float y, float z, float w, float h, float p) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;

        this.lago1 = new E_Lago(gl, 0, 0, 0, 0.5f, 1f, 1, 0, 0, 0);
        this.lago2 = new E_Lago(gl, 0, 0, 0, 0.5f, 1f, 1, 0, 90, 0);
        this.lago3 = new E_Lago(gl, -2f, 0, 0, 0.5f, 1f, 1, 0, 90, 0);

        this.barquito1 = new E_Barco(gl, -0.7f, 0, -0.7f, 0.1f, 0.15f, 0.1f, 0, 0, 0, 1, 0, 1);
        this.barquito2 = new E_Barco(gl, -3.55f, 0, -0.3f, 0.1f, 0.15f, 0.1f, 0, 180, 0, 0.7f, 0, 1);
        this.barquito3 = new E_Barco(gl, -3.6f, 0, -0.1f, 0.1f, 0.15f, 0.1f, 0, 180, 0, 0, 0.5f, 1);
        this.barquito4 = new E_Barco(gl, -3.6f, 0, 0.1f, 0.1f, 0.15f, 0.1f, 0, 180, 0, 0, 0.3f, 1);
        this.barquito5 = new E_Barco(gl, -3.55f, 0, 0.3f, 0.1f, 0.15f, 0.1f, 0, 180, 0, 0, 0, 1);

    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslatef(this.x, this.y, this.z);

        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

        this.lago1.Dibuja();
        this.lago2.Dibuja();
        this.lago3.Dibuja();

        this.barquito1.Dibuja();
        this.barquito2.Dibuja();
        this.barquito3.Dibuja();
        this.barquito4.Dibuja();
        this.barquito5.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

}
