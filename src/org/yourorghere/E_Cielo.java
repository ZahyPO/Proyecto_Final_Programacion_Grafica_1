package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class E_Cielo {

    GL gl;
    float x, y, z;
    float w, h, d;

    float r1, g1, b1;
    float r2, g2, b2;

    P_Esfera luna, sol;

    public E_Cielo(GL gl, float x, float y, float z, float w, float h, float p) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = p;
        this.luna = new P_Esfera(gl, 0, .4f, 0, .05f, .05f, .05f, 0, 0, 0, 1, 1, 1);
        this.sol = new P_Esfera(gl, 0, -1.2f, 0, .05f, .05f, .05f, 0, 0, 0, 1, 1, 0);
//        this.luna = new P_Esfera(gl, 0, .4f, 0, .05f, .05f, .05f, 0, 0, 0, 1, 1, 0);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        estado();

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glScalef(this.w, this.h, this.d);

        gl.glBegin(GL.GL_QUADS);

        //CARA FRONTAL
        gl.glColor3f(r1, g1, b1);
        gl.glVertex3f(-1.5f, 1.5f, -1.5f);
        gl.glVertex3f(1.5f, 1.5f, -1.5f);
        gl.glColor3f(r2, g2, b2);
        gl.glVertex3f(1.5f, -1.5f, -1.5f);
        gl.glVertex3f(-1.5f, -1.5f, -1.5f);
        //Cara Trasera
        gl.glColor3f(r1, g1, b1);
        gl.glVertex3f(1.5f, 1.5f, 1.5f);
        gl.glVertex3f(-1.5f, 1.5f, 1.5f);
        gl.glColor3f(r2, g2, b2);
        gl.glVertex3f(-1.5f, -1.5f, 1.5f);
        gl.glVertex3f(1.5f, -1.5f, 1.5f);

        //Cara Lateral Izquierda
        gl.glColor3f(r1, g1, b1);
        gl.glVertex3f(-1.5f, 1.5f, 1.5f);
        gl.glVertex3f(-1.5f, 1.5f, -1.5f);
        gl.glColor3f(r2, g2, b2);
        gl.glVertex3f(-1.5f, -1.5f, -1.5f);
        gl.glVertex3f(-1.5f, -1.5f, 1.5f);

        //Cara Lateral Derecha
        gl.glColor3f(r1, g1, b1);
        gl.glVertex3f(1.5f, 1.5f, -1.5f);
        gl.glVertex3f(1.5f, 1.5f, 1.5f);
        gl.glColor3f(r2, g2, b2);
        gl.glVertex3f(1.5f, -1.5f, 1.5f);
        gl.glVertex3f(1.5f, -1.5f, -1.5f);

        //Cara Superior
        gl.glColor3f(r1, g1, b1);
        gl.glVertex3f(1.5f, 1.5f, -1.5f);
        gl.glVertex3f(1.5f, 1.5f, 1.5f);
        gl.glVertex3f(-1.5f, 1.5f, 1.5f);
        gl.glVertex3f(-1.5f, 1.5f, -1.5f);

        //Cara Inferior
        gl.glColor3f(r2, g2, b2);
        gl.glVertex3f(1.5f, -1.5f, -1.5f);
        gl.glVertex3f(1.5f, -1.5f, 1.5f);
        gl.glVertex3f(-1.5f, -1.5f, 1.5f);
        gl.glVertex3f(-1.5f, -1.5f, -1.5f);

        gl.glEnd();

        luna.gira();

        luna.Dibuja();
        sol.Dibuja();

        gl.glPopMatrix();
    }

    public void estado() {
        if (Proyecto_Final.estado) {
            this.r1 = r1 + 0.0001f;
            this.g1 = g1 + 0.005f;
            this.b1 = b1 + 0.01f;

        } else {
            this.r1 = r1 - 0.0001f;
            this.g1 = g1 - 0.005f;
            this.b1 = b1 - 0.01f;
        }

        if (Proyecto_Final.estado) {
            this.r2 = r2 + 0.01f;
            this.g2 = g2 + 0.005f;
            this.b2 = b2 + 0.0001f;
        } else {
            this.r2 = r2 - 0.01f;
            this.g2 = g2 - 0.005f;
            this.b2 = b2 - 0.0001f;
        }
    }
}
