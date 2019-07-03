package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class C_Caminos {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;

    E_Tablas caminop1, caminop2, camino_parq_pnin, caminoJC;

    E_Tablas camino_canch_pnin, camino_canch_prin, camino_canch_perros, camino_canch_jc;

    E_Tablas puente1, puente2, puente3;

    E_Banca banca1, banca2, banca3, banca4, banca5, banca6, banca7, banca8, banca9, banca10;

    P_Cilindro tubo1, tubo2, tubo3;
    P_Cilindro pasamanos1, pasamanos2, pasamanos3;

    public C_Caminos(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;

        this.caminop1 = new E_Tablas(gl, -0.7f, 0, 0, 2.7f, 0.02f, 0.035f, 0, 0, 0, 20);
        this.caminop2 = new E_Tablas(gl, 0.67f, 0, 0, 2.7f, 0.02f, 0.035f, 0, 0, 0, 20);
        this.caminoJC = new E_Tablas(gl, 0f, 0, -0.75f, 3.2f, 0.02f, 0.025f, 0, 0, 0, 30);
        this.camino_parq_pnin = new E_Tablas(gl, 0.8f, 0f, -0.1f, 2.4f, 0.02f, 0.02f, 0, 90, 0, 10);
        this.camino_canch_pnin = new E_Tablas(gl, 0f, 0f, 0.8f, 2.6f, 0.02f, 0.03f, 0, 0, 0, 15);
        this.camino_canch_prin = new E_Tablas(gl, -0.3f, 0f, 0.4f, 2.9f, 0.02f, 0.02f, 0, 90, 0, 20);
        this.camino_canch_perros = new E_Tablas(gl, -0.7f, 0f, -0.02f, 2.1f, 0.02f, 0.02f, 0, 90, 0, 10);
        this.camino_canch_jc = new E_Tablas(gl, -0.45f, 0f, -0.35f, 2.7f, 0.02f, 0.02f, 0, 90, 0, 20);

        this.puente1 = new E_Tablas(gl, 0.015f, 0.07f, 0, 1.95f, 0.015f, 0.05f, 0, 0, 0, 19);
        this.puente2 = new E_Tablas(gl, -0.23f, 0.033f, 0, 1.16f, 0.01f, 0.05f, 0, 0, 35, 9);
        this.puente3 = new E_Tablas(gl, 0.27f, 0.04f, 0, 1.25f, 0.01f, 0.05f, 0, 0, -25, 10);

        this.banca1 = new E_Banca(gl, -0.3f, 0, -0.5f, 0.02f, 0.02f, 0.02f, 45, 1, 1, 1);
        this.banca2 = new E_Banca(gl, 0.4f, 0, -0.55f, 0.02f, 0.02f, 0.02f, -45, 1, 1, 1);
        this.banca3 = new E_Banca(gl, 0.2f, 0, 0.7f, 0.02f, 0.02f, 0.02f, -135, 1, 1, 1);
        this.banca4 = new E_Banca(gl, 0.6f, 0, -0.1f, 0.02f, 0.02f, 0.02f, 0, 1, 1, 1);
        this.banca5 = new E_Banca(gl, 0.6f, 0, 0.1f, 0.02f, 0.02f, 0.02f, 180, 1, 1, 1);
        this.banca6 = new E_Banca(gl, 0.7f, 0, -0.3f, 0.02f, 0.02f, 0.02f, 90, 1, 1, 1);
        this.banca7 = new E_Banca(gl, -0.61f, 0, -0.22f, 0.02f, 0.02f, 0.02f, 0, 1, 1, 1);
        this.banca8 = new E_Banca(gl, -0.2f, 0, 0.7f, 0.02f, 0.02f, 0.02f, 135, 1, 1, 1);
        this.banca9 = new E_Banca(gl, -0.8f, 0, -0.22f, 0.02f, 0.02f, 0.02f, 0, 1, 1, 1);
        this.banca10 = new E_Banca(gl, -0.4f, 0, 0.1f, 0.02f, 0.02f, 0.02f, 180, 1, 1, 1);


        this.tubo1 = new P_Cilindro(gl, -0.17f, 0.07f, 0.045f, 0.02f, 0.02f, 0.04f, 0, 0, 0, 0.4f, 0.4f, 0.4f, 0.1, 0.1);
        this.tubo2 = new P_Cilindro(gl, 0.35f, 0, 0.045f, 0.02f, 0.02f, 0.04f, 0, 35, 0, 0.4f, 0.4f, 0.3f, 0.1, 0.1);
        this.tubo3 = new P_Cilindro(gl, -0.27f, 0, 0.045f, 0.02f, 0.02f, 0.04f, 0, -25, 0, 0.4f, 0.4f, 0.3f, 0.1, 0.1);

        this.pasamanos1 = new P_Cilindro(gl, -0.18f, 0.11f, 0.045f, 0.02f, 0.02f, 0.4f, 0, 90, 0, 0, 0.1f, 0.1f, 0.2, 0.2);
        this.pasamanos2 = new P_Cilindro(gl, -0.3f, 0.027f, 0.045f, 0.02f, 0.02f, 0.14f, 0, 55, 0, 0, 0.1f, 0.1f, 0.2, 0.2);
        this.pasamanos3 = new P_Cilindro(gl, 0.38f, 0.04f, 0.045f, 0.02f, 0.02f, 0.165f, 0, -65, 0, 0, 0.1f, 0.1f, 0.2, 0.2);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.caminop1.Dibuja();
        this.caminop2.Dibuja();

        this.caminoJC.Dibuja();

        this.camino_parq_pnin.Dibuja();

        this.camino_canch_pnin.Dibuja();

        this.camino_canch_prin.Dibuja();

        this.camino_canch_perros.Dibuja();

        this.camino_canch_jc.Dibuja();

        this.puente1.Dibuja();
        this.puente2.Dibuja();
        this.puente3.Dibuja();

        this.banca1.Dibuja();
        this.banca2.Dibuja();
        this.banca3.Dibuja();
        this.banca4.Dibuja();
        this.banca5.Dibuja();
        this.banca6.Dibuja();
        this.banca7.Dibuja();
        this.banca8.Dibuja();
        this.banca9.Dibuja();
        this.banca10.Dibuja();

        this.tubo1.x = -0.17f;

        for (int i = 0; i < 21; i++) {
            this.tubo1.z = -this.tubo1.z;
            tubo1.Dibuja();
            this.tubo1.z = -this.tubo1.z;
            tubo1.Dibuja();

            this.tubo1.x = this.tubo1.x + 0.019f;
        }

        this.tubo3.x = -0.27f;
        this.tubo3.y = 0f;

        for (int i = 0; i < 6; i++) {
            this.tubo3.z = -this.tubo3.z;
            tubo3.Dibuja();
            this.tubo3.z = -this.tubo3.z;
            tubo3.Dibuja();

            this.tubo3.x = this.tubo3.x + 0.019f;
            this.tubo3.y = this.tubo3.y + 0.013f;
        }

        this.tubo2.x = 0.35f;
        this.tubo2.y = 0.01f;

        for (int i = 0; i < 8; i++) {
            this.tubo2.z = -this.tubo2.z;
            tubo2.Dibuja();
            this.tubo2.z = -this.tubo2.z;
            tubo2.Dibuja();

            this.tubo2.x = this.tubo2.x - 0.019f;
            this.tubo2.y = this.tubo2.y + 0.008f;
        }

        pasamanos1.z = -pasamanos1.z;
        pasamanos2.z = -pasamanos2.z;
        pasamanos3.z = -pasamanos3.z;
        pasamanos1.Dibuja();
        pasamanos2.Dibuja();
        pasamanos3.Dibuja();
        pasamanos1.z = -pasamanos1.z;
        pasamanos2.z = -pasamanos2.z;
        pasamanos3.z = -pasamanos3.z;
        pasamanos1.Dibuja();
        pasamanos2.Dibuja();
        pasamanos3.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
