package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Zay
 */
public class C_Parque_Perritos {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;

    P_Cuadrado suelo;
    P_Cubo borde1, borde2;

    E_Jueg_1_Perros juego_1_1, juego_1_2, juego_1_3;

    E_Jueg_2_Perros juego_2_1, juego_2_2, juego_2_3;

    P_Cilindro juego_3_1, juego_3_2;
    
    E_Perrito perro1,perro2;

    public C_Parque_Perritos(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;

        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1f, 1f, 90, 0, 0, 0, 0, 0);

        this.borde1 = new P_Cubo(gl, 1, 0.07f, 0f, 0.015f, 0.06f, 1, 0, 0, 0, 0.8f, 1, 1);
        this.borde2 = new P_Cubo(gl, 0, 0.07f, 1f, 1f, 0.07f, 0.015f, 0, 0, 0, 0.8f, 1, 1);

        this.juego_1_1 = new E_Jueg_1_Perros(gl, 0, 0f, 0f, 0.2f, 0.2f, 0.1f, 180);
        this.juego_1_2 = new E_Jueg_1_Perros(gl, 0.7f, 0f, 0.7f, 0.2f, 0.2f, 0.1f, 45);
        this.juego_1_3 = new E_Jueg_1_Perros(gl, -0.7f, 0f, -0.7f, 0.2f, 0.2f, 0.1f, 45);

        this.juego_2_1 = new E_Jueg_2_Perros(gl, 0.7f, 0, -0.7f, 0.1f, 0.15f, 0.2f, -45);
        this.juego_2_2 = new E_Jueg_2_Perros(gl, -0.7f, 0, 0.7f, 0.1f, 0.15f, 0.2f, -45);
        this.juego_2_3 = new E_Jueg_2_Perros(gl, 0f, 0, -0.7f, 0.1f, 0.15f, 0.2f, 0);

        this.juego_3_1 = new P_Cilindro(gl, 0.3f, 0.04f, -0.3f, 0.1f, 0.1f, 0.3f, 0, 90, 0, 0.5f, 0.3f, 0.9f, 0.5f, 0.5f);
        this.juego_3_2 = new P_Cilindro(gl, -0.7f, 0.04f, 0.3f, 0.1f, 0.1f, 0.3f, 0, 90, 0, 0.2f, 1, 0.6f, 0.5f, 0.5f);
        
        this.perro1 = new E_Perrito(gl, 0.3f, 0, 0, .1f, .1f, .1f, 0);
        this.perro2 = new E_Perrito(gl, 0.1f, 0, 0, .2f, .2f, .2f, 0);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.suelo.Dibuja();

        this.borde1.x = -this.borde1.x;
        this.borde1.Dibuja();
        this.borde1.x = -this.borde1.x;
        this.borde1.Dibuja();

        this.borde2.z = -this.borde2.z;
        this.borde2.Dibuja();
        this.borde2.z = -this.borde2.z;
        this.borde2.Dibuja();

        this.juego_1_1.Dibuja();
        this.juego_1_2.Dibuja();
        this.juego_1_3.Dibuja();

        this.juego_2_1.Dibuja();
        this.juego_2_2.Dibuja();
        this.juego_2_3.Dibuja();

        this.juego_3_1.Dibuja();
        this.juego_3_2.Dibuja();
        
        this.perro1.Dibuja();
        this.perro2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
