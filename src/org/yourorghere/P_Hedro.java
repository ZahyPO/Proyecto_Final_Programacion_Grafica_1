package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/*
 * @author Zay
 */
public class P_Hedro {

    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    float r, g, b;
    GL gl;
    GLUT glut = new GLUT();
    GLU glu = new GLU();

    public P_Hedro(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz, float r, float g, float b) {
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
        this.gl = gl;

    }

    public void Dibuja() {

        gl.glPushMatrix();
        gl.glColor3f(r, g, b);
        gl.glTranslatef(x, y, z);
        gl.glRotatef(-90, 1, 0, 0);
        gl.glRotatef(45, 0, 0, 1);
        gl.glRotatef(rx, 1, 0, 0);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glRotatef(rz, 0, 0, 1);
        gl.glScalef(w, h, p);

        GLUquadric cilindro = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(cilindro, GLU.GLU_FILL);
        glu.gluCylinder(cilindro, 1, 0, 1, 4, 4);

        gl.glEnd();

        gl.glPopMatrix();
    }

}
