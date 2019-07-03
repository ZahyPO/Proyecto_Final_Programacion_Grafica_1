package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Lago {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;

    P_Circulo base, agua;
    P_Esfera montaña1, montaña2, piedra1, piedra2;

    E_Barco barquito;

    public E_Lago(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz) {
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

        this.base = new P_Circulo(gl, 0, 0.001f, 0, 2f, 2f, 2f, 90, 0, 0, 0.5f, 0.3f, 0.1f);
        this.agua = new P_Circulo(gl, 0, 0.005f, 0, 1.8f, 1.8f, 0.9f, 90, 0, 0, 0.2f, 0.3f, 0.4f);
        this.montaña1 = new P_Esfera(gl, 0.4f, 0f, 0, 0.7f, 0.3f, 0.5f, 0, 0, 0, 0.5f, 0.7f, 0.2f);
        this.montaña2 = new P_Esfera(gl, -0.2f, 0f, 0, 0.7f, 0.2f, 0.3f, 0, 0, 0, 0.5f, 0.5f, 0.2f);
        this.piedra1 = new P_Esfera(gl, 0, 0f, 0, 0.05f, 0.03f, 0.05f, 0, 0, 0, 0.7f, 0.7f, 0.7f);
        this.piedra2 = new P_Esfera(gl, 0, 0f, 0, 0.04f, 0.04f, 0.04f, 0, 0, 0, 0.5f, 0.5f, 0.5f);
        
         this.barquito = new E_Barco(gl, -0.4f, 0, -0.4f, 0.1f, 0.15f, 0.1f, 0, 0, 0, 0, 0.7f, 0.5f);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);

        gl.glScalef(this.w, this.h, this.p);

        for (int i = 0; i < 50; i++) {
            float xx = 2 * (float) Math.cos(i * 2 * Math.PI / 50);
            float yy = 2 * (float) Math.sin(i * 2 * Math.PI / 50);
            this.piedra1.x = xx;
            this.piedra1.z = yy;
            this.piedra1.Dibuja();
        }
        for (int i = 0; i < 70; i++) {
            float xx = 1.85f * (float) Math.cos(i * 2 * Math.PI / 70);
            float yy = 1.95f * (float) Math.sin(i * 2 * Math.PI / 70);
            this.piedra2.x = xx;
            this.piedra2.z = yy;
            this.piedra2.Dibuja();
        }

        this.base.Dibuja();
        this.montaña1.Dibuja();
        this.agua.Dibuja();
        this.montaña2.Dibuja();
        
        this.barquito.gira();
        this.barquito.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

}
