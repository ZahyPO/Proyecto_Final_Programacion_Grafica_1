package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Tablas {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    float ntablas;

    float anch;

    P_Cubo tabla1, tabla2;

    public E_Tablas(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz, float ntablas) {
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
        this.ntablas = ntablas;

        this.anch = w / (ntablas * 40);
        
        this.tabla1 = new P_Cubo(gl, -this.anch, 0, 0, this.anch, 0.2f, 1, 0, 0, 0, 0.5f, 0.3f, 0);
        this.tabla2 = new P_Cubo(gl, this.anch, 0, 0, this.anch, 0.3f, 1, 0, 0, 0, 0.5f, 0.2f, 0);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslatef(this.x, this.y, this.z);

        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(this.w, this.h, this.p);
        boolean rep = true;

        this.tabla1.x = -this.anch;
        this.tabla2.x = this.anch;

        this.tabla1.Dibuja();
        this.tabla2.Dibuja();

        for (int i = 1; i < ntablas; i++) {

            if (rep) {
                this.tabla1.x = this.tabla1.x + i * 2 * 2 * this.anch;
                this.tabla2.x = this.tabla2.x + i * 2 * 2 * this.anch;

            } else {
                this.tabla1.x = this.tabla1.x - i * 2 * 2 * this.anch;
                this.tabla2.x = this.tabla2.x - i * 2 * 2 * this.anch;

            }
            rep = !rep;
            this.tabla1.Dibuja();
            this.tabla2.Dibuja();
        }
        gl.glEnd();

        gl.glPopMatrix();

    }

}
