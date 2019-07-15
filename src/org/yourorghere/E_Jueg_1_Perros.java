package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Jueg_1_Perros {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;

    E_Tablas tabla1, tabla2;
    P_Cilindro tubo;

    public E_Jueg_1_Perros(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;

        this.tabla1 = new E_Tablas(gl, -0.35f, 0.25f, 0, 3f, 0.1f, 1f, 0, 0, 35, 10);
        this.tabla2 = new E_Tablas(gl, 0.35f, 0.25f, 0, 3f, 0.1f, 1f, 0, 0, -35, 10);

        this.tubo = new P_Cilindro(gl, 0, 0, 1, 0.1f, 0.1f, 0.7f, 0, 0, 0, 1, 1, 1, 0.3f, 0.3f);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.tabla1.Dibuja();
        this.tabla2.Dibuja();

        this.tubo.z = -this.tubo.z;
        this.tubo.Dibuja();
        this.tubo.z = -this.tubo.z;
        this.tubo.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
