package org.yourorghere;

import javax.media.opengl.GL;

/**
 * @author zalis
 */
public class E_Jueg_Casa {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;
    float r, g, b;

    P_Cilindro tubo1, tubo2, tubo3;
    P_Cubo paredes;
    P_Piramide techo;
    P_Cuadrado ventana, puerta;
    E_Tablas tablas, resbaladera;

    public E_Jueg_Casa(GL gl, float x, float y, float z, float w, float h, float p, float ry, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.ry = ry;
        this.r = r;
        this.g = g;
        this.b = b;

        this.tubo1 = new P_Cilindro(gl, 0.5f, 0, 0.5f, 0.1f, 0.1f, 0.7f, 0, 0, 0, 0.3f, 0.2f, 0, 0.5f, 0.5f);
        this.tubo2 = new P_Cilindro(gl, 1.5f, 0, 0.5f, 0.1f, 0.1f, 1.5f, 0, 0, 0, 0.3f, 0.2f, 0, 0.5f, 0.5f);
        this.tubo3 = new P_Cilindro(gl, 0.6f, 1.5f * this.tubo1.z, 0.5f, 0.1f, 0.1f, 1.8f, 0, 90, 0, 0.4f, 0.3f, 0, 0.5f, 0.5f);

        this.paredes = new P_Cubo(gl, 0, 2.5f * this.tubo1.z, 0, 1.2f * this.tubo1.x, 1.2f * this.tubo1.x, 1.2f * this.tubo1.z, 0, 0, 0, r, g, b);
        this.techo = new P_Piramide(gl, 0, 2.1f * this.tubo1.z + 2.1f * this.paredes.h, 0, 1.3f * this.tubo1.x, 1f * this.tubo1.x, 1.3f * this.tubo1.z, 0, 0, 0, r + 0.4f, g, b);

        this.ventana = new P_Cuadrado(gl, 0f, 2.5f * this.tubo1.z, this.paredes.w + 0.02f, 0.3f, 0.3f, 0, 0, 0, r, g + 0.5f, b);
        this.puerta = new P_Cuadrado(gl, this.paredes.w + 0.01f, 2.5f * this.tubo1.z, 0, 0.3f, 0.5f, 0, 90, 0, r, g + 0.5f, b);

        this.tablas = new E_Tablas(gl, 1.5f, 1.5f * this.tubo1.z, 0, 4f, 0.1f, 0.7f, 0, 0, 0, 7);
        this.resbaladera = new E_Tablas(gl, 2.5f, 0.7f * this.tubo1.z, 0, 3.2f, 0.1f, 0.7f, 0, 0, -45, 5);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glColor3f(this.r, this.g, this.b);//Color 
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glScalef(this.w, this.h, this.p);

        this.tubo1.z = -this.tubo1.z;
        this.tubo1.Dibuja();
        this.tubo1.x = -this.tubo1.x;
        this.tubo1.Dibuja();
        this.tubo1.z = -this.tubo1.z;
        this.tubo1.Dibuja();
        this.tubo1.x = -this.tubo1.x;
        this.tubo1.Dibuja();

        this.tubo2.z = -this.tubo2.z;
        this.tubo2.Dibuja();
        this.tubo2.x = this.tubo2.x + 0.7f;
        this.tubo2.Dibuja();
        this.tubo2.z = -this.tubo2.z;
        this.tubo2.Dibuja();
        this.tubo2.x = this.tubo2.x - 0.7f;
        this.tubo2.Dibuja();

        this.tubo3.z = -this.tubo3.z;
        this.tubo3.Dibuja();
        this.tubo3.y = this.tubo3.y + 0.4f;
        this.tubo3.Dibuja();
        this.tubo3.z = -this.tubo3.z;
        this.tubo3.Dibuja();
        this.tubo3.y = this.tubo3.y - 0.4f;
        this.tubo3.Dibuja();

        this.techo.Dibuja();

        this.paredes.Dibuja();

        this.ventana.z = -this.ventana.z;
        this.ventana.Dibuja();
        this.ventana.z = -this.ventana.z;
        this.ventana.Dibuja();

        this.puerta.Dibuja();
        this.tablas.Dibuja();
        this.resbaladera.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();
    }

}
