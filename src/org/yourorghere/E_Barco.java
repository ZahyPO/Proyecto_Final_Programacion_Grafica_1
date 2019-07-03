package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Zay
 */
public class E_Barco {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    float ryy = 0;
    float r, g, b;

    boolean gira = true;
    int cont = 0;

//    P_Cuadrado suelo;
    E_Tablas tab1, tab2, tab3, tab4, respaldo, asiento;

    P_Cilindro tubo;
    P_Esfera bolita;
    P_Triangulo bandera;

    public E_Barco(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz, float r, float g, float b) {
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
        this.tab1 = new E_Tablas(gl, -0.65f, 0.2f, 0.3f, 3f, 0.15f, 0.3f, 90, 0, 45, 3);
        this.tab2 = new E_Tablas(gl, -0.65f, 0.2f, -0.3f, 3f, 0.15f, 0.3f, 90, 0, -45, 3);
        this.tab3 = new E_Tablas(gl, 0.1f, 0.2f, -0.6f, 3f, 0.15f, 0.3f, 90, 0, 0, 3);
        this.tab4 = new E_Tablas(gl, 0.1f, 0.2f, 0.6f, 3f, 0.15f, 0.3f, 90, 0, 0, 3);

        this.respaldo = new E_Tablas(gl, 0.55f, 0.2f, -0.14f, 3.5f, 0.15f, 0.3f, 90, 0, 90, 4);
        this.asiento = new E_Tablas(gl, 0f, 0.3f, 0f, 3f, 0.15f, 0.6f, 0, 0, 0, 4);

        this.tubo = new P_Cilindro(gl, 0.5f, 0.3f, 0, 0.1f, 0.1f, 1.2f, 0, 0, 0, 1, 1, 1, 0.3f, 0.3f);

        this.bandera = new P_Triangulo(gl, 0.5f, 1.1f, 0, 0.4f, 0.4f, 0.4f, 0, 0, 0, r, g, b);

    }

    public void Dibuja() {

        gl.glPushMatrix();
        requisitos();
        rotarbandera();
        subeybaja();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(rx, 1, 0, 0);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glRotatef(rz, 0, 0, 1);

        gl.glScalef(w, h, p);

//        suelo.Dibuja();
        tab1.Dibuja();
        tab2.Dibuja();
        tab3.Dibuja();
        tab4.Dibuja();

        respaldo.Dibuja();
        asiento.Dibuja();
        tubo.Dibuja();

        bandera.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

    void requisitos() {

        if (cont <= 20) {
            cont++;
        } else {
            cont = -20;
            gira = !gira;
        }
    }

    void rotarbandera() {

        if (gira) {
            this.y = this.y + 0.0005f;
        } else {
            this.y = this.y - 0.0005f;
        }
    }

    void subeybaja() {
        requisitos();
        if (gira) {
            bandera.ry = bandera.ry + 5;
        } else {
            bandera.ry = bandera.ry - 5;
        }

    }

    void gira() {

        this.ryy = this.ryy + 0.3f;

        gl.glRotatef(ryy, 0, 1, 0);
        gl.glTranslatef(x, y, z);
    }

}
