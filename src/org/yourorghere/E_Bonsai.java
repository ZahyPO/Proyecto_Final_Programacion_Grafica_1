package org.yourorghere;

import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class E_Bonsai {

    GL gl;
    float x, y, z;
    float w, h, p;
    float r, g, b;
    float ry;
    int opc;

    E_Base base;

    E_Maceta maceta;

    E_Arbol_1_Piramide arbol1;
    E_Arbol_2_Esfera arbol2;
    E_Arbol_3_Dodecahedro arbol3;

    public E_Bonsai(GL gl, float x, float y, float z, float w, float h, float p, float ry, float r, float g, float b, int opc) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.p = p;
        this.r = r;
        this.g = g;
        this.b = b;
        this.ry = ry;
        this.opc = opc;

        this.base = new E_Base(gl, 0, 0, 0, 1, 0.3f, 1, 0, r, g, b);

        this.maceta = new E_Maceta(gl, 0, 0.3f, 0, 0.5f, 0.05f, 0.5f, 0, 0.6f, 0.3f, 0);

        switch (opc) {
            case 1:
                this.arbol1 = new E_Arbol_1_Piramide(gl, 0, 0.3f, 0, 2.5f, 0.3f, 2.5f, 0, 0, 0);
                break;
            case 2:
                this.arbol2 = new E_Arbol_2_Esfera(gl, 0, 0.3f, 0, 2.5f, 0.3f, 2.5f, 0, 0, 0);
                break;
            case 3:
                this.arbol3 = new E_Arbol_3_Dodecahedro(gl, 0, 0.3f, 0, 2.5f, 0.3f, 2.5f, 0, 0, 0);
                break;
        }
    }

    public void Dibuja() {
        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.ry, 0, 1, 0);

        gl.glScaled(w, h, p);

        this.base.Dibuja();
        this.maceta.Dibuja();

        switch (opc) {
            case 1:
                this.arbol1.Dibuja();
                break;
            case 2:
                this.arbol2.Dibuja();
                break;
            case 3:
                this.arbol3.Dibuja();
                break;
        }

        gl.glEnd();

        gl.glPopMatrix();
    }

}
