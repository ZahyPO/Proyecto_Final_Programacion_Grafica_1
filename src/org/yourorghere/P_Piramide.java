package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class P_Piramide {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;

    public P_Piramide(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = p;
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

        gl.glScalef(this.w, this.h, this.d);

        gl.glBegin(GL.GL_QUADS);
        //BASE
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(-1, -1, 1);

        gl.glEnd();

        gl.glBegin(GL.GL_TRIANGLES);
        //Cara Lateral Derecha
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(-1, -1, -1);

        //Cara Lateral Izquierda
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(1, -1, -1);

        //Cara  atras
        gl.glColor3f(this.r + 0.2f, this.g + 0.2f, this.b + 0.2f);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(-1, -1, -1);

        //Cara  delante
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(-1, -1, 1);
//        this.rx = rx + 0.8f;
//        this.ry = ry + 0.8f;
//        this.rz = rz + 0.8f;
        gl.glEnd();

        gl.glPopMatrix();
    }

}
