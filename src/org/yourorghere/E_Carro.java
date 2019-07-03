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

    boolean gira = true;
    int cont = 0;

    E_Maceta balde;
    P_Cilindro tubo1,tubo2;
    P_Cubo cara;
    P_Trapecio cara1;
    P_Esfera faro1, faro2;

    P_Cuadrado suelo;

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

        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 90, 0, 0, 1f, 0.4f, 0.2f);
        this.balde = new E_Maceta(gl, -0.5f, 0.3f, 0, 0.5f, 0.15f, 0.3f, 0, r, g, b);
        this.cara = new P_Cubo(gl, 0.4f, 0.3f, 0, 0.4f, 0.15f, 0.3f, 0, 0, 0, r, g, b);
        this.cara = new P_Cubo(gl, 0.4f, 0.3f, 0, 0.4f, 0.15f, 0.3f, 0, 0, 0, r, g, b);
        this.cara1 = new P_Trapecio(gl, 0.35f, 0.6f, 0, 0.35f, 0.15f, 0.3f, 0, 0, 0, r, g, b);
        this.faro1 = new P_Esfera(gl, 0.8f, 0.35f, -0.15f, 0.05f, 0.05f, 0.05f, 0, 0, 0, 1, 1, 0);
        this.faro2 = new P_Esfera(gl, 0.8f, 0.35f, 0.15f, 0.05f, 0.05f, 0.05f, 0, 0, 0, 1, 1, 0);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslatef(x, y, z);
        gl.glRotatef(rx, 1, 0, 0);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glRotatef(rz, 0, 0, 1);

        gl.glScalef(w, h, p);

        suelo.Dibuja();
        balde.Dibuja();
        cara.Dibuja();
        cara1.Dibuja();
        faro1.Dibuja();
        faro2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }
}
