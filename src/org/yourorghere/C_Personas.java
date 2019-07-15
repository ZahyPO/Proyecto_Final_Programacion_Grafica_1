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

    E_Persona p1, p2, p3, p4, p5, p6, p7, p8, p9;

    public C_Personas(GL gl, float x, float y, float z, float w, float h, float p) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;

        this.suelo = new P_Cuadrado(gl, 0, 1, 0, 1, 1, 90, 0, 0, 1, 1, 0);

        this.p1 = new E_Persona(gl, -0.7f, 0.27f, 0.7f, 0.05f, 0.25f, 0.05f, 0, 0, 0, "parado", 1);
        this.p2 = new E_Persona(gl, -0.7f, 0.27f, 0.8f, 0.05f, 0.25f, 0.05f, 0, 135, 0, "parado", 2);
        this.p3 = new E_Persona(gl, -0.6f, 0.27f, 0.75f, 0.05f, 0.25f, 0.05f, 0, -45, 0, "parado", 2);
        this.p4 = new E_Persona(gl, -0.65f, 0.28f, 0.91f, 0.05f, 0.25f, 0.05f, 0, 180, 0, "sentado", 2);
        this.p5 = new E_Persona(gl, 0f, 0.12f, 0.64f, 0.05f, 0.25f, 0.05f, 0, 180, 0, "suelo", 2);
        this.p6 = new E_Persona(gl, 0.47f, 0.18f, -0.53f, 0.05f, 0.25f, 0.05f, 0, -45, 0, "sentado", 2);
        this.p7 = new E_Persona(gl, -0.72f, 0.18f, -0.2f, 0.05f, 0.25f, 0.05f, 0, 0, 0, "sentado", 2);
        this.p8 = new E_Persona(gl, 0.47f, 0.18f, 0.5f, 0.02f, 0.15f, 0.02f, 0, -45, 0, "parado", 1);
        this.p9 = new E_Persona(gl, 0.8f, 0.31f, 0.5f, 0.02f, 0.15f, 0.02f, 0, 180, 0, "suelo", 2);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glScaled(w, h, p);

//        this.suelo.Dibuja();
        p1.Dibuja();
        p2.Dibuja();
        p3.Dibuja();
        p4.Dibuja();
        p5.Dibuja();
        p6.Dibuja();
        p7.Dibuja();
        p8.Dibuja();
        p9.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }
}
