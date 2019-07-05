package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Zay
 */
public class E_Carro {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    float ryy = 0;
    float r, g, b;

    boolean avanza = true;
    int cont = 0;

    E_Maceta balde;

    P_Cilindro tubo1, tubo2;
    P_Cubo cara;
    P_Trapecio cara1, ventanas;
    P_Esfera faro1, faro2;
    P_Cuadrado techo;
    P_Dona llanta1, llanta2;

//    P_Cuadrado suelo;
    public E_Carro(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz, float r, float g, float b) {
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

//        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 90, 0, 0, 1f, 0.4f, 0.2f);
        this.techo = new P_Cuadrado(gl, -0.2f, 0.68f, 0, 0.2f, 0.3f, 90, 0, 0, 0, 0, 0);

        this.balde = new E_Maceta(gl, -0.3f, 0.3f, 0, 0.3f, 0.15f, 0.3f, 0, r, g, b);

        this.cara = new P_Cubo(gl, 0.4f, 0.3f, 0, 0.4f, 0.15f, 0.3f, 0, 0, 0, r, g, b);
        this.cara = new P_Cubo(gl, 0.4f, 0.3f, 0, 0.4f, 0.15f, 0.3f, 0, 0, 0, r, g, b);

        this.cara1 = new P_Trapecio(gl, 0.35f, 0.55f, 0, 0.35f, 0.13f, 0.27f, 0, 0, 0, r, g, b);
        this.ventanas = new P_Trapecio(gl, 0.36f, 0.55f, 0, 0.35f, 0.12f, 0.28f, 0, 0, 0, 0.5f, 0.6f, 1f);

        this.faro1 = new P_Esfera(gl, 0.8f, 0.35f, -0.15f, 0.05f, 0.05f, 0.05f, 0, 0, 0, 1, 1, 0);
        this.faro2 = new P_Esfera(gl, 0.8f, 0.35f, 0.15f, 0.05f, 0.05f, 0.05f, 0, 0, 0, 1, 1, 0);

        this.tubo1 = new P_Cilindro(gl, -0.38f, 0.36f, 0.26f, 0.2f, 0.2f, 0.32f, 0, 0, 0, 1, 1, 1, 0.1f, 0.1f);
        this.tubo2 = new P_Cilindro(gl, -0.38f, 0.36f, -0.26f, 0.2f, 0.2f, 0.32f, 0, 0, 0, 1, 1, 1, 0.1f, 0.1f);

        this.llanta1 = new P_Dona(gl, -0.3f, 0.17f, 0.35f, 0.15f, 0.15f, 0.15f, 0, 0, 0, 0, 0, 0, 0.6f, 0.8f);
        this.llanta2 = new P_Dona(gl, 0.4f, 0.17f, 0.35f, 0.15f, 0.15f, 0.15f, 0, 0, 0, 0, 0, 0, 0.6f, 0.8f);
    }

    public void Dibuja(boolean mover, int opcavan) {

        gl.glPushMatrix();
        if (mover) {
            subeybaja(opcavan);
            gira();
        }

        gl.glTranslatef(x, y, z);
        gl.glRotatef(rx, 1, 0, 0);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glRotatef(rz, 0, 0, 1);

        gl.glScalef(w, h, p);

//        suelo.Dibuja();
        balde.Dibuja();
        cara.Dibuja();
        cara1.Dibuja();
        faro1.Dibuja();
        faro2.Dibuja();
        techo.Dibuja();
        tubo1.Dibuja();
        tubo2.Dibuja();
        ventanas.Dibuja();

        llanta1.z = -llanta1.z;
        llanta1.Dibuja();
        llanta1.z = -llanta1.z;
        llanta1.Dibuja();
        llanta2.z = -llanta2.z;
        llanta2.Dibuja();
        llanta2.z = -llanta2.z;
        llanta2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

    void requisitos() {

        if (cont <= 40) {
            cont++;
        } else {
            cont = -40;
            avanza = !avanza;
        }
    }

    void subeybaja(int opc) {
        requisitos();
        if (opc == 1) {
            if (avanza) {
                this.z = this.z + 0.05f;
            } else {
                this.z = this.z - 0.05f;
            }
        } else {
            if (avanza) {
                this.x = this.x + 0.05f;
            } else {
                this.x = this.x - 0.05f;
            }
        }

    }

    void gira() {

        this.llanta1.ry += 1;
    }
}
