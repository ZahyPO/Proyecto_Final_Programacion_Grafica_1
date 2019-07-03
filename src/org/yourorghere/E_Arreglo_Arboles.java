package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/*
 * @author zalis
 */
public class E_Arreglo_Arboles {

    ArrayList<E_Arbol_1_Piramide> bosquesillo1 = new ArrayList<E_Arbol_1_Piramide>();
    ArrayList<E_Arbol_2_Esfera> bosquesillo2 = new ArrayList<E_Arbol_2_Esfera>();
    ArrayList<E_Arbol_3_Dodecahedro> bosquesillo3 = new ArrayList<E_Arbol_3_Dodecahedro>();
    GL gl;
    float x, y, z;
    float w, h, d;
    int n, m;
    float a, b;
    int opc;

    public E_Arreglo_Arboles(GL gl, float x, float y, float z, float w, float h, float d, int n, int m, float a, float b, int opc) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.n = n;
        this.m = m;
        this.a = a;
        this.b = b;
        this.opc = opc;
        switch (opc) {
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        bosquesillo1.add(new E_Arbol_1_Piramide(gl, (x + a * i), 0, (z + b * j), a, 1, b, 0, 0, 0));
                    }

                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        bosquesillo2.add(new E_Arbol_2_Esfera(gl, (x + a * i), 0, (z + b * j), a, 1, b, 0, 0, 0));
                    }

                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        bosquesillo3.add(new E_Arbol_3_Dodecahedro(gl, (x + a * i), 0, (z + b * j), a, 1, b, 0, 0, 0));
                    }

                }
                break;
        }

    }

    public void Dibuja() {

        gl.glPushMatrix();

        gl.glTranslatef(x, y, z);
        gl.glScalef(w, h, d);

        switch (opc) {
            case 1:
                for (E_Arbol_1_Piramide v : bosquesillo1) {
                    v.Dibuja();
                }
                break;
            case 2:
                for (E_Arbol_2_Esfera v : bosquesillo2) {
                    v.Dibuja();
                }
                break;
            case 3:
                for (E_Arbol_3_Dodecahedro v : bosquesillo3) {
                    v.Dibuja();
                }
                break;
        }

        gl.glEnd();

        gl.glPopMatrix();
    }
}
