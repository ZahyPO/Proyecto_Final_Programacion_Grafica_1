package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Arco {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;

    P_Cilindro vertical, horizontal1, horizontal2, centro;
    P_Cubo tablero;
    P_Cuadrado marco;
    P_Circulo aro;

    public E_Arco(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz) {
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
        this.vertical = new P_Cilindro(gl, 0, 0, 0, 0.02f, 0.02f, 0.4f, 0, 0, 0, 1, 1, 1, 0.5f, 0.5f);
        this.horizontal1 = new P_Cilindro(gl, 0, this.vertical.p, -0.05f, 0.02f, 0.02f, 0.15f, 90, 0, 0, 1, 1, 1, 0.5f, 0.5f);
        this.horizontal2 = new P_Cilindro(gl, -0.4f, this.vertical.p, 0, 0.02f, 0.02f, 0.8f, 90, 90, 0, 1, 1, 1, 0.5f, 0.5f);
        this.centro = new P_Cilindro(gl, 0, this.vertical.p, 0.1f, 0.02f, 0.02f, 0.2f, 0, 0, 0, 1, 1, 1, 0.5f, 0.5f);
        this.tablero = new P_Cubo(gl, 0, this.vertical.p + this.centro.p, 0.1f, 0.1f, 0.1f, 0.01f, 0, 0, 0, 1, 1, 1);
        this.marco = new P_Cuadrado(gl, 0, this.vertical.p + this.centro.p + (this.tablero.h / 4), 0.12f, 0.05f, 0.05f, 0, 0, 0, 0, 0, 0);
        this.aro = new P_Circulo(gl, 0, this.vertical.p + this.centro.p - 0.025f, 0.17f, 0.05f, 0.05f, 0.05f, 90, 0, 0, 1, 0.5f, 0.2f);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);

        gl.glScalef(this.w, this.h, this.p);

        this.vertical.x = 0.4f;
        this.vertical.z = 0.1f;
        this.horizontal2.z = this.vertical.z;
        this.horizontal1.x = this.vertical.x;
        this.vertical.Dibuja();
        this.horizontal1.Dibuja();
        this.horizontal2.Dibuja();
        this.vertical.z = -0.05f;
        this.horizontal2.z = this.vertical.z;
        this.vertical.Dibuja();
        this.horizontal2.Dibuja();
        this.vertical.x = -0.4f;
        this.horizontal1.x = this.vertical.x;
        this.vertical.Dibuja();
        this.horizontal1.Dibuja();
        this.vertical.z = 0.1f;
        this.vertical.Dibuja();

        this.centro.Dibuja();
        this.tablero.Dibuja();
        this.marco.DibujaFilo();

        this.aro.DibujaFilo();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
