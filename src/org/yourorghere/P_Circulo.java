package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class P_Circulo {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    float r, g, b;

    public P_Circulo(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(this.w, this.h, this.p);

        gl.glBegin(gl.GL_POLYGON);

        for (int i = 0; i < 20; i++) {

            float x = (float) Math.cos(i * 2 * Math.PI / 20);
            float y = (float) Math.sin(i * 2 * Math.PI / 20);
            gl.glVertex2d(1 * x, 1 * y);
        }
        gl.glEnd();

        gl.glPopMatrix();
    }

    public void DibujaFilo() {
        gl.glPushMatrix();

        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(this.w, this.h, this.p);

        gl.glBegin(gl.GL_POINTS);
        gl.glPointSize(2);

        for (int i = 0; i < 70; i++) {

            float x = (float) Math.cos(i * 2 * Math.PI / 70);
            float y = (float) Math.sin(i * 2 * Math.PI / 70);
            gl.glVertex2d(1 * x, 1 * y);
        }

        gl.glEnd();

        gl.glPopMatrix();
    }

    public void DibujaMedio() {
        gl.glPushMatrix();

        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(this.w, this.h, this.p);

        gl.glBegin(gl.GL_POLYGON);

        for (int i = 55; i <= 95; i++) {

            float x = (float) Math.cos(i * 2 * Math.PI / 100);
            float y = (float) Math.sin(i * 2 * Math.PI / 100);
            gl.glVertex2d(1 * x, 1 * y);
        }

        gl.glEnd();

        gl.glPopMatrix();
    }

}
