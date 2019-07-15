package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Perrito {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;
    float ryy = 0;

    boolean gira = true;
    int cont = 0;

    P_Cuadrado suelo1, suelo2;

    P_Cilindro pata1, pata2, pata3, pata4, cuerpo, cola;
    P_Esfera cabeza, hocico;
    P_Circulo orejai, orejad;

    public E_Perrito(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;

        this.ry = ry;

        this.suelo1 = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 90, 0, 0, 1f, 0.4f, 0.2f);
        this.suelo2 = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 0, 0, 0, 1f, 0.4f, 0.2f);

        this.pata1 = new P_Cilindro(gl, .25f, 0f, .1f, 0.1f, 0.1f, .3f, 0, 0, 0, .5f, .3f, .1f, 0.3f, 0.3f);
        this.pata2 = new P_Cilindro(gl, .25f, 0f, -.1f, 0.1f, 0.1f, .3f, 0, 0, 0, .5f, .3f, .1f, 0.3f, 0.3f);
        this.pata3 = new P_Cilindro(gl, -.35f, 0f, -.1f, 0.1f, 0.1f, .3f, 0, 0, 0, .5f, .3f, .1f, 0.3f, 0.3f);
        this.pata4 = new P_Cilindro(gl, -.35f, 0f, .1f, 0.1f, 0.1f, .3f, 0, 0, 0, .5f, .3f, .1f, 0.3f, 0.3f);

        this.cuerpo = new P_Cilindro(gl, -.4f, .35f, .0f, 0.15f, 0.15f, .7f, 0, 90, 0, .5f, .3f, .1f, 0.7f, 0.7f);

        this.cola = new P_Cilindro(gl, -.4f, .35f, 0, .2f, .2f, .2f, 0, -45, 0, .7f, .5f, .0f, .1f, .1f);

        this.cabeza = new P_Esfera(gl, .43f, .5f, .0f, 0.15f, 0.15f, .15f, 0, 90, 0, .6f, .3f, .0f);
        this.hocico = new P_Esfera(gl, .55f, .47f, .0f, 0.09f, 0.09f, .09f, 0, 90, 0, .7f, .5f, .0f);

        this.orejad = new P_Circulo(gl, .4f, .56f, .15f, .05f, .1f, .1f, -45, 0, 0, .7f, .5f, .0f);
        this.orejai = new P_Circulo(gl, .4f, .56f, -.15f, .05f, .1f, .1f, 45, 0, 0, .7f, .5f, .0f);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gira();
        giratodo();

        gl.glTranslatef(x, y, z);

        gl.glRotatef(ry, 0, 1, 0);
        gl.glScalef(w, h, p);

//        suelo1.Dibuja();
//        suelo2.Dibuja();

        pata1.Dibuja();
        pata2.Dibuja();
        pata3.Dibuja();
        pata4.Dibuja();

        cuerpo.Dibuja();
        cabeza.Dibuja();
        hocico.Dibuja();
        cola.Dibuja();

        orejad.Dibuja();
        orejai.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

    void gira() {
        this.cola.rx = this.cola.rx + 0.9f;
    }
    
    void giratodo() {

        this.ryy = this.ryy + 0.3f;

        gl.glRotatef(ryy, 0, 1, 0);
        gl.glTranslatef(x, y, z);
    }
}
