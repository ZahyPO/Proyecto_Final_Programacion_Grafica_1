package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author zalis
 */
public class E_Maceta {

    GL gl;
    float x, y, z;
    float w, h, p;
    float r, g, b;
    float ry;

    public E_Maceta(GL gl, float x, float y, float z, float w, float h, float p, float ry, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.r = r;
        this.g = g;
        this.b = b;
        this.ry = ry;
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glColor3f(this.r - 0.1f, this.g - 0.1f, this.b - 0.1f);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScalef(this.w, this.h, this.p);

        gl.glBegin(GL.GL_QUADS);
        //CARA FRONTAL

        gl.glVertex3f(-1, 1, -1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(-1, -1, -1);
        //Cara Trasera
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);

        //Cara Lateral Izquierda
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(-1, 1, -1);
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(-1, -1, 1);

        //Cara Lateral Derecha
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -1);

        //Cara Inferior
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(-1, -1, -1);

        gl.glColor3f(this.r, this.g, this.b);
        //Cara Superior
        gl.glVertex3f(1, 0.2f, -1);
        gl.glVertex3f(1, 0.2f, 1);
        gl.glVertex3f(-1, 0.2f, 1);
        gl.glVertex3f(-1, 0.2f, -1);

        gl.glEnd();

        gl.glPopMatrix();
    }

}
