package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Persona {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;
    String opc;
    int opccab;

    P_Cubo cubo;

    P_Cilindro cuello, torax, brazoI, brazoD, antebrazoI, antebrazoD, piernaI, piernaD, pantorrillaI, pantorrillaD;
    P_Esfera cabeza, cabello, manoI, manoD, pieI, pieD, cadera;

    P_Circulo sonrisa, ojoI, ojoD;

    public E_Persona(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz, String opc, int opccab) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;

        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();

        this.opc = opc;
        this.opccab = opccab;

        this.cubo = new P_Cubo(gl, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1);

        this.cabeza = new P_Esfera(gl, 0, .73f, 0, .2f, .22f, .2f, 0, 0, 0, 1f, 0.8f, 0.3f);
        if (opccab == 1) {
            this.cabello = new P_Esfera(gl, 0, .75f, -0.05f, .22f, .24f, .22f, 0, 0, 0, 1, 1, 0);
        } else {
            this.cabello = new P_Esfera(gl, 0, .75f, -0.05f, .22f, .24f, .22f, 0, 0, 0, 0, 0, 0);

        }

        this.cuello = new P_Cilindro(gl, 0, .4f, 0, .2f, .2f, .15f, 0, 0, 0, 1f, 0.8f, 0.3f, 0.3f, 0.3f);

        this.torax = new P_Cilindro(gl, 0, 0, 0, .4f, .4f, .4f, 0, 0, 0, r, g, b, 0.4f, 0.4f);

        this.brazoD = new P_Cilindro(gl, 0.1f, .37f, 0, .2f, .2f, .5f, 0, 150, 0, r, g, b, 0.3f, 0.2f);
        this.brazoI = new P_Cilindro(gl, -0.1f, .37f, 0, .2f, .2f, .5f, 0, -150, 0, r, g, b, 0.3f, 0.2f);

        this.antebrazoD = new P_Cilindro(gl, .3f, -.05f, 0, 0.2f, 0.2f, .25f, 120, -45, 0, 1f, 0.8f, 0.3f, 0.15f, 0.15f);
        this.antebrazoI = new P_Cilindro(gl, -.3f, -.05f, 0, 0.2f, 0.2f, .25f, 120, 45, 0, 1f, 0.8f, 0.3f, 0.15f, 0.15f);

        this.manoD = new P_Esfera(gl, .1f, -.15f, .15f, .05f, .05f, .05f, 0, 0, 0, 1f, 0.8f, 0.3f);
        this.manoI = new P_Esfera(gl, -.1f, -.15f, .15f, .05f, .05f, .05f, 0, 0, 0, 1f, 0.8f, 0.3f);

        this.cadera = new P_Esfera(gl, 0, -0.15f, 0, .2f, .2f, .1f, 0, 0, 0, r, g, b);

        this.sonrisa = new P_Circulo(gl, 0, .7f, .19f, .1f, .1f, .1f, 0, 0, 0, 1, 1, 1);
        this.ojoI = new P_Circulo(gl, 0.07f, .75f, .19f, .05f, .05f, .05f, 0, 0, 180, 0, 0, 0);
        this.ojoD = new P_Circulo(gl, -0.07f, .75f, .19f, .05f, .05f, .05f, 0, 0, 180, 0, 0, 0);

        if ("sentado".equals(opc)) {
            this.piernaD = new P_Cilindro(gl, .1f, -.3f, 0, .2f, .2f, .3f, 110, 0, 0, r, g, b, 0.3f, 0.2f);
            this.piernaI = new P_Cilindro(gl, -.1f, -.3f, 0, .2f, .2f, .3f, 110, 0, 0, r, g, b, 0.2f, 0.2f);

            this.pantorrillaD = new P_Cilindro(gl, .1f, -.67f, 0.25f, .2f, .2f, .3f, 0, 0, 0, r, g, b, 0.2f, 0.2f);
            this.pantorrillaI = new P_Cilindro(gl, -.1f, -.67f, 0.25f, .2f, .2f, .3f, 0, 0, 0, r, g, b, 0.2f, 0.2f);

            this.pieD = new P_Esfera(gl, .1f, -.7f, .3f, 0.05f, 0.05f, 0.1f, 0, 0, 0, r, g, b);
            this.pieI = new P_Esfera(gl, -.1f, -.7f, .3f, 0.05f, 0.05f, 0.1f, 0, 0, 0, r, g, b);
        }
        if ("parado".equals(opc)) {
            this.piernaD = new P_Cilindro(gl, .1f, -.7f, 0, .2f, .2f, .45f, 0, 0, 0, 1f, 0.8f, 0.3f, 0.3f, 0.2f);
            this.piernaI = new P_Cilindro(gl, -.1f, -.7f, 0, .2f, .2f, .45f, 0, 0, 0, 1f, 0.8f, 0.3f, 0.3f, 0.2f);

            this.pantorrillaD = new P_Cilindro(gl, .1f, -1f, 0, .2f, .2f, .3f, 0, 0, 0, r, g, b, 0.2f, 0.2f);
            this.pantorrillaI = new P_Cilindro(gl, -.1f, -1f, 0, .2f, .2f, .3f, 0, 0, 0, r, g, b, 0.2f, 0.2f);

            this.pieD = new P_Esfera(gl, .1f, -1f, 0.1f, 0.05f, 0.05f, 0.1f, 0, 0, 0, r, g, b);
            this.pieI = new P_Esfera(gl, -.1f, -1f, 0.1f, 0.05f, 0.05f, 0.1f, 0, 0, 0, r, g, b);
        }
        if ("suelo".equals(opc)) {
            this.piernaD = new P_Cilindro(gl, .1f, -.3f, 0, .2f, .2f, .3f, 130, 0, 0, r, g, b, 0.3f, 0.2f);
            this.piernaI = new P_Cilindro(gl, -.1f, -.3f, 0, .2f, .2f, .3f, 130, 0, 0, r, g, b, 0.2f, 0.2f);

            this.pantorrillaD = new P_Cilindro(gl, .1f, -.45f, -0.07f, .2f, .2f, .3f, 100, 0, 0, 1f, 0.8f, 0.3f, 0.2f, 0.2f);
            this.pantorrillaI = new P_Cilindro(gl, -.1f, -.45f, -0.07f, .2f, .2f, .3f, 100, 0, 0, 1f, 0.8f, 0.3f, 0.2f, 0.2f);

            this.pieD = new P_Esfera(gl, .1f, -.5f, -.1f, 0.05f, 0.05f, 0.1f, 90, 0, 0, r, g, b);
            this.pieI = new P_Esfera(gl, -.1f, -.5f, -.1f, 0.05f, 0.05f, 0.1f, 90, 0, 0, r, g, b);
        }

    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);

        gl.glScalef(this.w, this.h, this.d);

//        this.cubo.Dibuja();
        cabeza.Dibuja();
        cabello.Dibuja();
        sonrisa.DibujaMedio();
        ojoI.DibujaMedio();
        ojoD.DibujaMedio();

        this.cuello.Dibuja();

        this.torax.Dibuja();

        this.brazoD.Dibuja();
        this.brazoI.Dibuja();

        this.antebrazoD.Dibuja();
        this.antebrazoI.Dibuja();

        this.manoD.Dibuja();
        this.manoI.Dibuja();

        this.cadera.Dibuja();

        this.piernaD.Dibuja();
        this.piernaI.Dibuja();
//
        this.pantorrillaD.Dibuja();
        this.pantorrillaI.Dibuja();
//
        this.pieD.Dibuja();
        this.pieI.Dibuja();

        gl.glPopMatrix();
    }

    public void Giro() {
        this.ry += 1;
    }

}
