package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_SubeyBaja {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;
    float r, g, b;

    P_Cilindro tubo1, tubo2, tubop, manubrio1, manubrio2;

    P_Esfera asiento;

    public E_SubeyBaja(GL gl, float x, float y, float z, float w, float h, float p, float ry, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;
        this.r = r;
        this.g = g;
        this.b = b;

        this.tubo1 = new P_Cilindro(gl, -0.21f, -0.01f, 0, 0.1f, 0.1f, 0.3f, 0, 45, 0, r - 0.2f, g - 0.2f, b - 0.2f, 0.5f, 0.5f);
        this.tubo2 = new P_Cilindro(gl, 0.21f, -0.01f, 0, 0.1f, 0.1f, 0.3f, 0, -45, 0, r + 0.2f, g + 0.2f, b + 0.2f, 0.5f, 0.5f);

        this.tubop = new P_Cilindro(gl, 0f, 0.22f, -0.75f, 0.1f, 0.05f, 1.5f, 90, 0, 0, r, g, b, 0.5f, 0.5f);

        this.manubrio1 = new P_Cilindro(gl, 0f, 0.22f, -0.55f, 0.05f, 0.05f, 0.05f, 0, 0, 0, r - 0.2f, g, b, 0.5f, 0.5f);
        this.manubrio2 = new P_Cilindro(gl, -0.15f, 0.28f, -0.55f, 0.05f, 0.1f, 0.3f, 0, 90, 0, r - 0.2f, g - 0.2f, b, 0.3f, 0.3f);

        this.asiento = new P_Esfera(gl, 0, 0.22f, -0.8f, 0.2f, 0.05f, 0.2f, 0, 0, 0, 0.8f, 0.7f, 0.6f);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glColor3f(this.r, this.g, this.b);//Color 
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

        this.tubo1.Dibuja();
        this.tubo2.Dibuja();

        this.tubop.Dibuja();

        this.asiento.z = -this.asiento.z;
        this.asiento.Dibuja();
        this.asiento.z = -this.asiento.z;
        this.asiento.Dibuja();

        this.manubrio1.z = -this.manubrio1.z;
        this.manubrio1.Dibuja();
        this.manubrio1.z = -this.manubrio1.z;
        this.manubrio1.Dibuja();

        this.manubrio2.z = -this.manubrio2.z;
        this.manubrio2.Dibuja();
        this.manubrio2.z = -this.manubrio2.z;
        this.manubrio2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
