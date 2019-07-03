package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class C_Jardin_Chino {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;

    P_Cuadrado suelo;

    E_Bonsai bonsai1, bonsai2, bonsai3, bonsai4, bonsai5, bonsai6, bonsai7;

    public C_Jardin_Chino(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;

        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1f, 0.2f, 90, 0, 0, 0, 0, 0);

        this.bonsai1 = new E_Bonsai(gl, -0.9f, 0, 0, 0.04f, 0.4f, 0.04f, 0f, 0.2f, 0.2f, 0.1f, 3);
        this.bonsai2 = new E_Bonsai(gl, -0.6f, 0, 0, 0.04f, 0.4f, 0.04f, 0f, 0.3f, 0.2f, 0.2f, 2);
        this.bonsai3 = new E_Bonsai(gl, -0.3f, 0, 0, 0.04f, 0.4f, 0.04f, 0f, 0.4f, 0.2f, 0.3f, 1);
        this.bonsai4 = new E_Bonsai(gl, 0f, 0, 0, 0.04f, 0.4f, 0.04f, 0.2f, 0.5f, 0.2f, 0.4f, 3);
        this.bonsai5 = new E_Bonsai(gl, 0.3f, 0, 0, 0.04f, 0.4f, 0.04f, 0f, 0.6f, 0.2f, 0.5f, 1);
        this.bonsai6 = new E_Bonsai(gl, 0.6f, 0, 0, 0.04f, 0.4f, 0.04f, 0f, 0.7f, 0.2f, 0.6f, 2);
        this.bonsai7 = new E_Bonsai(gl, 0.9f, 0, 0, 0.04f, 0.4f, 0.04f, 0f, 0.8f, 0.2f, 0.7f, 3);

    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.suelo.Dibuja();

        this.bonsai1.Dibuja();
        this.bonsai2.Dibuja();
        this.bonsai3.Dibuja();
        this.bonsai4.Dibuja();
        this.bonsai5.Dibuja();
        this.bonsai6.Dibuja();
        this.bonsai7.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
