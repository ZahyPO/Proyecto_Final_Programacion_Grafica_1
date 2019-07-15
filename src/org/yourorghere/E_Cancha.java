package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author Zay
 */
public class E_Cancha {

    GL gl;
    float x, y, z;
    float w, h, p;
    float ry;
    float r, g, b;

    P_Cuadrado base, filo, cancha, area, areaf;
    P_Circulo centro, centrof;
    P_Cubo grada1, grada2;
    E_Arco arco1, arco2;

    public E_Cancha(GL gl, float x, float y, float z, float w, float h, float p, float ry, float r, float g, float b) {
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
        this.base = new P_Cuadrado(gl, 0, 0.001f, 0, 1f, 0.9f, 90, 0, 0, r, g, b);
        this.filo = new P_Cuadrado(gl, 0, 0.002f, 0, 0.9f, 0.7f, 90, 0, 0, 1, 1, 1);
        this.cancha = new P_Cuadrado(gl, 0, 0.003f, 0, 0.9f, 0.7f, 90, 0, 0, 0.3f, 0.5f, 0);
        this.area = new P_Cuadrado(gl, 0.7f, 0.004f, 0, 0.2f, 0.2f, 90, 0, 0, r, g, b);
        this.areaf = new P_Cuadrado(gl, 0.7f, 0.005f, 0, 0.2f, 0.2f, 90, 0, 0, 1, 1, 1);
        this.centro = new P_Circulo(gl, 0, 0.004f, 0, 0.15f, 0.15f, 0, 90, 0, 0, r, g, b);
        this.centrof = new P_Circulo(gl, 0, 0.005f, 0, 0.15f, 0.15f, 0, 90, 0, 0, 1, 1, 1);
        this.grada1 = new P_Cubo(gl, 0, 0.05f, -0.9f, 0.05f, 0.05f, 1, 0, 90, 0, 0.3f, 0.4f, 0.4f);
        this.grada2 = new P_Cubo(gl, 0, 0.03f, -0.85f, 0.049f, 0.03f, 1, 0, 90, 0, 0.3f, 0.3f, 0.3f);

        this.arco1 = new E_Arco(gl, -0.95f, 0, 0, 0.5f, 0.5f, 0.5f, 0, 90, 0);
        this.arco2 = new E_Arco(gl, 0.95f, 0, 0, 0.5f, 0.5f, 0.5f, 0, 270, 0);
    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        gl.glColor3f(r, g, b);//Color 

        this.base.Dibuja();
        this.filo.DibujaFilo();
        this.cancha.Dibuja();

        this.area.x = 0.7f;
        this.areaf.x = 0.7f;
        this.area.Dibuja();
        this.areaf.DibujaFilo();

        this.area.x = -0.7f;
        this.areaf.x = -0.7f;
        this.area.Dibuja();
        this.areaf.DibujaFilo();
        this.centro.Dibuja();

        this.centrof.x = 0;
        this.centrof.DibujaFilo();
        this.centrof.x = 0.5f;
        this.centrof.DibujaFilo();
        this.centrof.x = -0.5f;
        this.centrof.DibujaFilo();

        this.arco1.Dibuja();
        this.arco2.Dibuja();

//        this.grada1.z = this.grada1.z;
//        this.grada2.z = this.grada2.z;
        this.grada1.Dibuja();
        this.grada2.Dibuja();
        this.grada1.z = -this.grada1.z;
        this.grada2.z = -this.grada2.z;
        this.grada1.Dibuja();
        this.grada2.Dibuja();

        gl.glEnd();

        gl.glPopMatrix();

    }

}
