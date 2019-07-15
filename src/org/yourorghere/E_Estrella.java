package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class E_Estrella {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;

    boolean si_no = true;
    int cont = 0;

    P_Esfera centro;

    P_Hedro p1, p2, p3, p4, p5, p6, p7;

    public E_Estrella(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz) {
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

        this.centro = new P_Esfera(gl, 0, 0, 0, 0.17f, 0.17f, 0.17f, 0, 0, 0, 1, 1, 0.7f);

        this.p1 = new P_Hedro(gl, 0, 0, 0, .1f, .1f, .5f, 0, 0, 0, 1, 1, 0.3f);
        this.p2 = new P_Hedro(gl, 0, 0, 0, .1f, .1f, .5f, 180, 0, 0, 1, 1, 0.3f);
        this.p3 = new P_Hedro(gl, 0, 0, 0, .1f, .1f, .5f, 90, 0, 0, 1, 1, .5f);
        this.p4 = new P_Hedro(gl, 0, 0, 0, .1f, .1f, .5f, -90, 0, 0, 1, 1, .5f);
        this.p5 = new P_Hedro(gl, 0, 0, 0, .1f, .1f, .5f, 0, 90, 0, 1, 1, .5f);
        this.p6 = new P_Hedro(gl, 0, 0, 0, .1f, .1f, .5f, 0, -90, 0, 1, 1, .5f);

    }

    public void Dibuja() {
        gl.glPushMatrix();

        requisitos();
//        subeybaja();
        rota();
        titila();

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

//        this.suelo1.Dibuja();
//        this.suelo2.Dibuja();
        centro.Dibuja();
        p1.Dibuja();
        p2.Dibuja();
        p3.Dibuja();
        p4.Dibuja();
        p5.Dibuja();
        p6.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

    void requisitos() {

        if (cont <= 20) {
            cont++;
        } else {
            cont = -20;
            si_no = !si_no;
        }
    }

    void subeybaja() {

        if (si_no) {
            this.y = this.y + 0.05f;
        } else {
            this.y = this.y - 0.05f;
        }
    }

    void rota() {

        if (si_no) {
            this.ry = this.ry + 0.5f;
        } else {
            this.ry = this.ry - 0.5f;
        }

    }

    void titila() {

        if (si_no) {
            this.w = this.w + 0.0005f;
            this.h = this.h + 0.0005f;
            this.p = this.p + 0.0005f;
        } else {
            this.w = this.w - 0.0005f;
            this.h = this.h - 0.0005f;
            this.p = this.p - 0.0005f;
        }

    }

}
