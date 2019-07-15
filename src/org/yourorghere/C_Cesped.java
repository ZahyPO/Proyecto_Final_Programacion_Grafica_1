package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class C_Cesped {

    GL gl;
    float x, y, z;
    float w, h, p;

    E_Arreglo_Cesped arb_1, arb_2, arb_3, arb_4, arb_5;
//    E_Arreglo_Cesped arb_6, arb_7, arb_8, arb_9, arb_10;
//    E_Arreglo_Cesped arb_11, arb_12;

    P_Cuadrado suelo;

    public C_Cesped(GL gl, float x, float y, float z, float w, float h, float p) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;

        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 90, 0, 0, 1, 1, 0);

        this.arb_1 = new E_Arreglo_Cesped(gl, -0.5f, 0, -0.5f, 1f, 0.01f, 1f, 100, 100, 0.02f, 0.02f);

    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glScaled(w, h, p);

        this.arb_1.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
