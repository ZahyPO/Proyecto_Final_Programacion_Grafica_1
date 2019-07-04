package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Columpio {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;
    float r, g, b;

    P_Cilindro tubo1, tubo2, tubo3, tubop;

    P_Dona asiento;

    public E_Columpio(GL gl, float x, float y, float z, float w, float h, float p, float ry, float r, float g, float b) {
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

        this.tubo1 = new P_Cilindro(gl, -1, -0.01f, -0.69f, 0.1f, 0.1f, 1f, 45, 0, 0, r - 0.2f, g - 0.2f, b - 0.2f, 0.5f, 0.5f);
        this.tubo2 = new P_Cilindro(gl, -1, -0.01f, 0.69f, 0.1f, 0.1f, 1f, -45, 0, 0, r + 0.2f, g + 0.2f, b + 0.2f, 0.5f, 0.5f);
        this.tubo3 = new P_Cilindro(gl, -1, 0.2f, -0.35f, 0.1f, 0.1f, 0.75f, 90, 0, 0, r, g, b, 0.5f, 0.5f);

        this.tubop = new P_Cilindro(gl, -1, 0.69f, 0, 0.1f, 0.1f, 2, 0, 90, 0, r, g, b, 0.5f, 0.5f);

        this.asiento = new P_Dona(gl, -0.5f, 0.2f, 0, 0.1f, 0.1f, 0.1f, 90, 0, 0, 0.4f, 0.3f, 0, 0.25f, 1.5f);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glColor3f(this.r, this.g, this.b);//Color 
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

        this.tubo1.x = -this.tubo1.x;
        this.tubo2.x = -this.tubo2.x;
        this.tubo3.x = -this.tubo3.x;
        this.tubo1.Dibuja();
        this.tubo2.Dibuja();
        this.tubo3.Dibuja();

        this.tubo1.x = -this.tubo1.x;
        this.tubo2.x = -this.tubo2.x;
        this.tubo3.x = -this.tubo3.x;
        this.tubo1.Dibuja();
        this.tubo2.Dibuja();
        this.tubo3.Dibuja();

        this.tubop.Dibuja();

        this.asiento.x = -this.asiento.x;
        this.asiento.Dibuja();
        this.asiento.x = -this.asiento.x;
        this.asiento.Dibuja();

        gl.glBegin(gl.GL_LINES);//Inicio de la creacion//Tipo 

        gl.glVertex3d(0.65f, this.asiento.y, this.asiento.z);
        gl.glVertex3d(0.65f, this.tubop.y, this.asiento.z);

        gl.glVertex3d(-0.65f, this.asiento.y, this.asiento.z);
        gl.glVertex3d(-0.65f, this.tubop.y, this.asiento.z);

        gl.glVertex3d(0.35f, this.asiento.y, this.asiento.z);
        gl.glVertex3d(0.35f, this.tubop.y, this.asiento.z);

        gl.glVertex3d(-0.35f, this.asiento.y, this.asiento.z);
        gl.glVertex3d(-0.35f, this.tubop.y, this.asiento.z);

        gl.glEnd();

        gl.glEnd();

        gl.glPopMatrix();

    }

}
