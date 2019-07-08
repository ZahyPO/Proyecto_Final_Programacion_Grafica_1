
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

    boolean gira = true;
    int cont = 0;

//    P_Cuadrado suelo;

    P_Esfera nube1, nube2, nube3;

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

//        this.suelo = new P_Cuadrado(gl, 0, 0f, 0, 1, 1, 90, 0, 0, 1, 1, 0);

        this.nube1 = new P_Esfera(gl, 0.3f, 0, 0, 0.3f, 0.2f, 0.2f, 0, 0, 0, 1, 1, 1);
        this.nube2 = new P_Esfera(gl, 0, 0, 0, 0.3f, 0.3f, 0.3f, 0, 0, 0, .95f, .95f, .95f);
        this.nube3 = new P_Esfera(gl, -0.3f, 0, 0, 0.3f, 0.2f, 0.2f, 0, 0, 0, 1, 1, 1);
    }

    public void Dibuja() {
        gl.glPushMatrix();
        
        requisitos();
        subeybaja();
        rota();

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

//        this.suelo.Dibuja();

        nube1.Dibuja();
        nube2.Dibuja();
        nube3.Dibuja();

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

    void subeybaja() {

        if (gira) {
            this.y = this.y + 0.005f;
        } else {
            this.y = this.y - 0.005f;
        }
    }

    void rota() {
        
        if (gira) {
            this.ry = this.ry + 0.05f;
        } else {
            this.ry = this.ry - 0.5f;
        }

    }
    
}
