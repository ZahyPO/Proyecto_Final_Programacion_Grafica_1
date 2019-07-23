package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */

public class E_Bicicleta {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    float r, g, b;

//    P_Cuadrado suelo;
    P_Dona llanta1, llanta2;

    P_Cilindro tubo1, tubo2, tubo3, tubo4, tubo5, tubo6, tubo7, tubo8;

    P_Esfera pedal1, pedal2;

    P_Esfera asiento;

    public E_Bicicleta(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz) {
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

        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();

//        this.suelo = new P_Cuadrado(gl, 0, 0f, 0, 1, 1, 90, 0, 0, 1, 1, 0);
        this.llanta1 = new P_Dona(gl, -.4f, 0.22f, 0, 0.3f, 0.3f, 0.2f, 0, 0, 0, 1, 1, 1, 0.1f, 0.7f);
        this.llanta2 = new P_Dona(gl, .4f, 0.17f, 0, 0.25f, 0.25f, 0.2f, 0, 0, 0, 1, 1, 1, 0.1f, 0.7f);
//        this.llanta1 = new P_Dona(gl, -.4f, 0.22f, 0, 0.3f, 0.3f, 0.2f, 0, 0, 0, 0, 0, 0, 0.1f, 0.7f);
//        this.llanta2 = new P_Dona(gl, .4f, 0.17f, 0, 0.25f, 0.25f, 0.2f, 0, 0, 0, 0, 0, 0, 0.1f, 0.7f);
        this.tubo1 = new P_Cilindro(gl, -.4f, .2f, 0.03f, 0.15f, 0.15f, 0.5f, 0, 35, 0, r, g, b, 0.1, 0.1);
        this.tubo2 = new P_Cilindro(gl, .1f, .2f, 0.03f, 0.15f, 0.15f, 0.3f, 0, 25, 0, r, g, b, 0.1, 0.1);
        this.tubo3 = new P_Cilindro(gl, .4f, .2f, 0.03f, 0.15f, 0.15f, 0.3f, 0, -45, 0, r, g, b, 0.1, 0.1);
        this.tubo4 = new P_Cilindro(gl, .1f, .2f, 0.03f, 0.15f, 0.15f, 0.3f, 0, 90, 0, r, g, b, 0.1, 0.1);
        this.tubo5 = new P_Cilindro(gl, -.25f, .4f, 0.03f, 0.15f, 0.15f, 0.45f, 0, 90, 0, r, g, b, 0.1, 0.1);
        this.tubo6 = new P_Cilindro(gl, .12f, .2f, 0.03f, 0.15f, 0.15f, 0.43f, 0, -65, 0, r, g, b, 0.1, 0.1);
        this.tubo7 = new P_Cilindro(gl, -.1f, .6f, -0.1f, 0.15f, 0.15f, 0.2f, 90, 0, 0, r + 0.2f, g + .2f, b + .2f, 0.1, 0.1);

        this.asiento = new P_Esfera(gl, .23f, .5f, 0, .1f, .05f, .1f, 0, 0, 0, 0.8f, 0.8f, 0.6f);
    }

    public void Dibuja(boolean est) {
        gl.glPushMatrix();

        if (est) {
            girallantas();
        }

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(rx, 1, 0, 0);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glRotatef(rz, 0, 0, 1);
        gl.glScalef(this.w, this.h, this.p);

//        this.suelo.Dibuja();
        this.llanta1.Dibuja();
        this.llanta2.Dibuja();

        this.tubo1.Dibuja();
        this.tubo2.Dibuja();
        this.tubo3.Dibuja();
        this.tubo4.Dibuja();
        this.tubo5.Dibuja();
        this.tubo6.Dibuja();
        this.tubo7.Dibuja();

        asiento.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

    void girallantas() {
        this.llanta1.rz += 2;
        this.llanta2.rz += 2;
    }

    public void movimiento_Bicicleta_Principa() {
        this.x += .03;
        if (this.x > 50) {
            this.x = -50;
        }
        if (x >= -31.8 && x <= -29.7) {
            rz = -27;
            this.y += .015;
        }
        if (x >= -29.67 && x <= -20) {
            rz = 0;
            this.y = 1.4f;
        }
        if (x >= -19.97 && x <= -16.84) {
            rz = 25;
            this.y -= .012;
        }
        if (x >= -16.81 && x <= 18.2) {
            rz = 0;
            this.y = .1f;
        }
        if (x <= 33 && x >= 29.7) {
            rz = 24;
            this.y -= .01;
        }
        if (x <= 29.67 && x >= 20.66) {
            rz = 0;
            this.y = 1.4f;
        }
        if (x <= 20.63 && x >= 18.23) {
            rz = -25;
            this.y += .017;
        }
        if (x <= 50 && x >= 33.3) {
            rz = 0;
            this.y = .1f;
        }
    }

}
