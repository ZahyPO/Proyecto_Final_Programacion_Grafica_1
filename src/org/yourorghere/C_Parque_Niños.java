package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class C_Parque_Niños {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;

    P_Cuadrado suelo;

    E_Jueg_Casa casa1, casa2, casa3, casa4, casa5;

    P_Esfera juego21, juego22, juego23;

    E_Columpio columpio1, columpio2, columpio3, columpio4;

    E_SubeyBaja subeybaja1, subeybaja2, subeybaja3, subeybaja4, subeybaja5, subeybaja6, subeybaja7;

    P_Cubo borde1, borde2;

    public C_Parque_Niños(GL gl, float x, float y, float z, float w, float h, float p, float ry) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;

        this.suelo = new P_Cuadrado(gl, 0, 0, 0, 1, 1, 90, 0, 0, 0, 0, 0);

        this.casa1 = new E_Jueg_Casa(gl, 0, 0, 0, 0.1f, 0.1f, 0.1f, 0, 0.2f, 0.5f, 0.7f);
        this.casa2 = new E_Jueg_Casa(gl, -0.8f, 0, -0.7f, 0.1f, 0.1f, 0.1f, 270, 0.5f, 0.5f, 0.7f);
        this.casa3 = new E_Jueg_Casa(gl, 0.8f, 0, -0.7f, 0.1f, 0.1f, 0.1f, 235, 0.5f, 0.1f, 0.7f);
        this.casa4 = new E_Jueg_Casa(gl, -0.8f, 0, 0.7f, 0.1f, 0.1f, 0.1f, 45, 0.2f, 0.5f, 0.1f);
        this.casa5 = new E_Jueg_Casa(gl, 0.8f, 0, 0.7f, 0.1f, 0.1f, 0.1f, 180, 0.1f, 0.5f, 0.7f);

        this.juego21 = new P_Esfera(gl, 0.8f, 0.01f, -0.2f, 0.1f, 0.1f, 0.1f, 90, 0, 0, 0f, 0.3f, 0.4f);
        this.juego22 = new P_Esfera(gl, -0.8f, 0.01f, 0f, 0.1f, 0.1f, 0.1f, 90, 0, 0, 0f, 0.6f, 0.1f);
        this.juego23 = new P_Esfera(gl, 0f, 0.01f, 0.8f, 0.1f, 0.1f, 0.1f, 90, 0, 0, 0.4f, 0.2f, 0.1f);

        this.columpio1 = new E_Columpio(gl, 0f, 0, -0.8f, 0.1f, 0.2f, 0.1f, 0, 0.1f, 0.5f, 0.7f);
        this.columpio2 = new E_Columpio(gl, -0.4f, 0, -0.8f, 0.1f, 0.2f, 0.1f, 0, 0.7f, 1f, 0.1f);
        this.columpio3 = new E_Columpio(gl, 0.8f, 0, 0.3f, 0.1f, 0.2f, 0.1f, 90, 0.9f, 0.1f, 0.2f);
        this.columpio4 = new E_Columpio(gl, -0.4f, 0, 0.8f, 0.1f, 0.2f, 0.1f, 0, 0.5f, 0.4f, 0.2f);

        this.subeybaja1 = new E_SubeyBaja(gl, -0.4f, 0f, -0.2f, 0.1f, 0.2f, 0.1f, 90, 0.7f, 0.7f, 0.2f);
        this.subeybaja2 = new E_SubeyBaja(gl, -0.4f, 0f, 0f, 0.1f, 0.2f, 0.1f, 90, 0.7f, 0.5f, 0.2f);
        this.subeybaja3 = new E_SubeyBaja(gl, -0.4f, 0f, 0.2f, 0.1f, 0.2f, 0.1f, 90, 0.5f, 0.7f, 0.2f);
        this.subeybaja5 = new E_SubeyBaja(gl, 0, 0f, 0.4f, 0.1f, 0.2f, 0.1f, 0, 0.4f, 0.2f, 0.2f);
        this.subeybaja6 = new E_SubeyBaja(gl, 0.2f, 0f, 0.4f, 0.1f, 0.2f, 0.1f, 0, 0.8f, 0.7f, 0.5f);
        this.subeybaja7 = new E_SubeyBaja(gl, -0.2f, 0f, 0.4f, 0.1f, 0.2f, 0.1f, 0, 0.7f, 0.7f, 0.7f);

        this.borde1 = new P_Cubo(gl, 1, 0.03f, 0f, 0.03f, 0.03f, 1, 0, 0, 0, 0.8f, 1, 1);
        this.borde2 = new P_Cubo(gl, 0, 0.03f, 1f, 1f, 0.03f, 0.03f, 0, 0, 0, 0.8f, 1, 1);
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.suelo.Dibuja();

        this.casa1.Dibuja();
        this.casa2.Dibuja();
        this.casa3.Dibuja();
        this.casa4.Dibuja();
        this.casa5.Dibuja();

        this.juego21.DibujaMalla();
        this.juego22.DibujaMalla();
        this.juego23.DibujaMalla();

        this.columpio1.Dibuja();
        this.columpio2.Dibuja();
        this.columpio3.Dibuja();
        this.columpio4.Dibuja();

        this.subeybaja1.Dibuja();
        this.subeybaja2.Dibuja();
        this.subeybaja3.Dibuja();

        this.subeybaja5.z = -this.subeybaja5.z;
        this.subeybaja6.z = -this.subeybaja6.z;
        this.subeybaja7.z = -this.subeybaja7.z;
        this.subeybaja5.Dibuja();
        this.subeybaja6.Dibuja();
        this.subeybaja7.Dibuja();

        this.subeybaja5.z = -this.subeybaja5.z;
        this.subeybaja6.z = -this.subeybaja6.z;
        this.subeybaja7.z = -this.subeybaja7.z;
        this.subeybaja5.Dibuja();
        this.subeybaja6.Dibuja();
        this.subeybaja7.Dibuja();

        this.borde1.x = -this.borde1.x;
        this.borde1.Dibuja();
        this.borde1.x = -this.borde1.x;
        this.borde1.Dibuja();

        this.borde2.z = -this.borde2.z;
        this.borde2.Dibuja();
        this.borde2.z = -this.borde2.z;
        this.borde2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
