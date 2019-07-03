package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class C_Parqueadero {

    GL gl;
    float x, y, z;
    float w, h, p;

    P_Cuadrado suelo, division;
    P_Cubo borde1, borde2, borde3, borde4, borde5, borde6;

    public C_Parqueadero(GL gl, float x, float y, float z, float w, float h, float p) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;

        this.suelo = new P_Cuadrado(gl, 0, 0.01f, 0, 2, 2, 90, 0, 0, 0, 0, 0);
        this.borde1 = new P_Cubo(gl, 2, 0.05f, -0.5f, 1.5f, 0.05f, 0.03f, 0, 90, 0, 0.9f, 0.8f, 0.1f);
        this.borde2 = new P_Cubo(gl, 0, 0.05f, -2, 2f, 0.05f, 0.03f, 0, 0, 0, 0.9f, 0.8f, 0.1f);
        this.borde3 = new P_Cubo(gl, 1.15f, 0.05f, 2, 0.85f, 0.05f, 0.03f, 0, 0, 0, 0.9f, 0.8f, 0.1f);
        this.borde4 = new P_Cubo(gl, -1.15f, 0.05f, 2, 0.85f, 0.05f, 0.03f, 0, 0, 0, 0.9f, 0.8f, 0.1f);
        this.borde5 = new P_Cubo(gl, -2, 0.05f, 1.15f, 0.85f, 0.05f, 0.03f, 0, 90, 0, 0.9f, 0.8f, 0.1f);
        this.borde6 = new P_Cubo(gl, -2, 0.05f, -1.15f, 0.85f, 0.05f, 0.03f, 0, 90, 0, 0.9f, 0.8f, 0.1f);
        this.division = new P_Cuadrado(gl, 1.5f, 0.02f, 1, 0.5f, 0.05f, 90, 0, 0, 0.9f, 0.9f, 0.9f);

    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslatef(this.x, this.y, this.z);

        gl.glScalef(this.w, this.h, this.p);

        this.suelo.Dibuja();
        this.borde1.Dibuja();
        this.borde2.Dibuja();
        this.borde3.Dibuja();
        this.borde4.Dibuja();
        this.borde5.Dibuja();
        this.borde6.Dibuja();

//////Probemos
        this.division.x = 1.5f;
        this.division.z = 1f;
        this.division.Dibuja();
        this.division.z = 0.5f;
        this.division.Dibuja();
        this.division.z = 0f;
        this.division.Dibuja();
        this.division.z = -0.5f;
        this.division.Dibuja();
        this.division.z = -1f;
        this.division.Dibuja();
        this.division.z = -1.5f;
        this.division.Dibuja();
        this.division.x = -1.5f;
        this.division.Dibuja();
        this.division.z = -1f;
        this.division.Dibuja();
        this.division.z = -0.5f;
        this.division.Dibuja();
        this.division.z = 0.5f;
        this.division.Dibuja();
        this.division.z = 1f;
        this.division.Dibuja();
        this.division.z = 1.5f;
        this.division.Dibuja();
        this.division.x = 0f;
        this.division.z = 1.3f;
        this.division.Dibuja();
        this.division.z = 0.8f;
        this.division.Dibuja();
        this.division.z = 0.3f;
        this.division.Dibuja();
        this.division.z = -0.2f;
        this.division.Dibuja();
        this.division.z = -0.7f;
        this.division.Dibuja();
        this.division.z = -1.3f;
        this.division.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

}
