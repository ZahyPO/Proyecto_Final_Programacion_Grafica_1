package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Zay
 */
public class E_Faro {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;

//    P_Cuadrado suelo1, suelo2;

    P_Cilindro tubo;
    P_Cubo foco1, foco2;
    P_Piramide techo1, techo2;

    public E_Faro(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz) {
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

//        this.suelo1 = new P_Cuadrado(gl, 0, 0f, 0, 1, 1, 90, 0, 0, 1, 1, 1);
//        this.suelo2 = new P_Cuadrado(gl, 0, 0f, 0, 1, 1, 0, 0, 0, 1, 1, 1);

        this.tubo = new P_Cilindro(gl, 0, 0, 0, .3f, .3f, .7f, 0, 0, 0, .5f, .6f, .5f, 0.1, 0.1);
        this.foco1 = new P_Cubo(gl, 0, .7f, 0, .05f, .07f, .05f, 0, 0, 0, 1, 1, 0);
        this.foco2 = new P_Cubo(gl, 0, .7f, 0, .05f, .07f, .05f, 0, 45, 0, 1, 1, 0.4f);

        this.techo1 = new P_Piramide(gl, 0, .8f, 0, .06f, .045f, .06f, 0, 0, 0, .5f, .5f, .5f);
        this.techo2 = new P_Piramide(gl, 0, .8f, 0, .06f, .045f, .06f, 0, 45, 0, .5f, .5f, .5f);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

//        this.suelo1.Dibuja();
//        this.suelo2.Dibuja();

        tubo.Dibuja();
        foco1.Dibuja();
        foco2.Dibuja();
        techo1.Dibuja();
        techo2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

}
