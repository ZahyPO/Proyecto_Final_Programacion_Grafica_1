package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class C_Parqueadero {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;

    P_Cuadrado suelo, division;
    P_Cubo borde1, borde2, borde3, borde4, borde5, borde6;

    E_Carro carro1, carro2, carro3, carro4, carro5, carro6, carro7;

    public C_Parqueadero(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;

        this.suelo = new P_Cuadrado(gl, 0, 0.01f, 0, 2, 2, 90, 0, 0, 0.1f, 0.1f, 0.1f);
        this.borde1 = new P_Cubo(gl, 2, 0.05f, -0.5f, 1.5f, 0.05f, 0.03f, 0, 90, 0, 0.9f, 0.8f, 0.1f);
        this.borde2 = new P_Cubo(gl, 0, 0.05f, -2, 2f, 0.05f, 0.03f, 0, 0, 0, 0.9f, 0.8f, 0.1f);
        this.borde3 = new P_Cubo(gl, 1.15f, 0.05f, 2, 0.85f, 0.05f, 0.03f, 0, 0, 0, 0.9f, 0.8f, 0.1f);
        this.borde4 = new P_Cubo(gl, -1.15f, 0.05f, 2, 0.85f, 0.05f, 0.03f, 0, 0, 0, 0.9f, 0.8f, 0.1f);
        this.borde5 = new P_Cubo(gl, -2, 0.05f, 1.15f, 0.85f, 0.05f, 0.03f, 0, 90, 0, 0.9f, 0.8f, 0.1f);
        this.borde6 = new P_Cubo(gl, -2, 0.05f, -1.15f, 0.85f, 0.05f, 0.03f, 0, 90, 0, 0.9f, 0.8f, 0.1f);
        this.division = new P_Cuadrado(gl, 1.5f, 0.02f, 1, 0.5f, 0.05f, 90, 0, 0, 0.9f, 0.9f, 0.9f);

        this.carro1 = new E_Carro(gl, -1.47f, 0, -0.75f, 0.45f, 0.45f, 0.4f, 0, 0, 0, 0.9f, 0.2f, 0.1f);
        this.carro2 = new E_Carro(gl, 1.47f, 0, -0.25f, 0.45f, 0.45f, 0.4f, 0, 0, 0, 0.9f, 0.2f, 0.7f);
        this.carro3 = new E_Carro(gl, 1.47f, 0, -1.75f, 0.45f, 0.45f, 0.4f, 0, 180, 0, 0.9f, 0.5f, 0.1f);
        this.carro4 = new E_Carro(gl, 0f, 0, 0.55f, 0.45f, 0.45f, 0.4f, 0, 180, 0, 0.5f, 0.2f, 0.1f);
        this.carro5 = new E_Carro(gl, 0, 0, -1.05f, 0.45f, 0.45f, 0.4f, 0, 0, 0, 0.7f, 0.2f, 0.7f);
        this.carro6 = new E_Carro(gl, 0.75f, 0, -1f, 0.45f, 0.45f, 0.4f, 0, 90, 0, 0.9f, 0.2f, 0.1f);
        this.carro7 = new E_Carro(gl, -1.3f, 0, 1.8f, 0.45f, 0.45f, 0.4f, 0, 0, 0, 0.4f, 0.2f, 0.8f);

    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

        this.suelo.Dibuja();
        this.borde1.Dibuja();
        this.borde2.Dibuja();
        this.borde3.Dibuja();
        this.borde4.Dibuja();
        this.borde5.Dibuja();
        this.borde6.Dibuja();

//////Probemos
        this.division.x = 1.5f;
        this.division.z = 1f;
        this.division.Dibuja();
        this.division.z = 0.5f;
        this.division.Dibuja();
        this.division.z = 0f;
        this.division.Dibuja();
        this.division.z = -0.5f;
        this.division.Dibuja();
        this.division.z = -1f;
        this.division.Dibuja();
        this.division.z = -1.5f;
        this.division.Dibuja();
        this.division.x = -1.5f;
        this.division.Dibuja();
        this.division.z = -1f;
        this.division.Dibuja();
        this.division.z = -0.5f;
        this.division.Dibuja();
        this.division.z = 0.5f;
        this.division.Dibuja();
        this.division.z = 1f;
        this.division.Dibuja();
        this.division.z = 1.5f;
        this.division.Dibuja();
        this.division.x = 0f;
        this.division.z = 1.3f;
        this.division.Dibuja();
        this.division.z = 0.8f;
        this.division.Dibuja();
        this.division.z = 0.3f;
        this.division.Dibuja();
        this.division.z = -0.2f;
        this.division.Dibuja();
        this.division.z = -0.7f;
        this.division.Dibuja();
        this.division.z = -1.3f;
        this.division.Dibuja();

        carro1.Dibuja(false, 1);
        carro2.Dibuja(false, 1);
        carro3.Dibuja(false, 1);
        carro4.Dibuja(false, 1);
        carro5.Dibuja(false, 1);
        carro6.Dibuja(true, 1);
        carro7.Dibuja(true, 2);

        gl.glEnd();

        gl.glPopMatrix();

    }

}
