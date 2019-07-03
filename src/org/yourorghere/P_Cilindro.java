package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author fing.labcom
 */
public class P_Cilindro {

    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    float r, g, b;

    double rs, ri;
    GL gl;

    public P_Cilindro(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz, float r, float g, float b, double rs, double ri) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = d;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
        this.rs = rs;
        this.ri = ri;
    }

    public void Dibuja() {
        GLU glu = new GLU();
        gl.glPushMatrix();
        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);

        gl.glRotatef(-90, 1, 0, 0);

        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
//        gl.glTranslatef(this.x, this.y, this.z);
        gl.glScalef(this.w, this.h, this.p);

        GLUquadric cilindro = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(cilindro, GLU.GLU_FILL);
        glu.gluCylinder(cilindro, ri, rs, 1, 7, 7);

        gl.glEnd();

        gl.glPopMatrix();
    }

}
