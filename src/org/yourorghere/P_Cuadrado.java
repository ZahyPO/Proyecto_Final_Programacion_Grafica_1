package org.yourorghere;

import javax.media.opengl.GL;

/**
 * @author Zay
 */
public class P_Cuadrado {
    
    GL gl;
    float x, y, z;
    float w, h;
    float rx, ry, rz;
    float r, g, b;
    
    public P_Cuadrado(GL gl, float x, float y, float z, float w, float h, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void Dibuja() {
        
        gl.glPushMatrix();
        
        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScaled(w, h, 0);
        
        gl.glColor3f(r, g, b);//Color 
        gl.glBegin(gl.GL_QUADS);//Inicio de la creacion//Tipo 

        gl.glVertex2d(1, 1);
        gl.glVertex2d(1, -1);
        gl.glVertex2d(-1, -1);
        gl.glVertex2d(-1, 1);
        
        gl.glEnd();
        gl.glPopMatrix();
        
    }

    public void DibujaFilo() {
        
        gl.glPushMatrix();
        
        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScaled(w, h, 0);
        
        gl.glColor3f(r, g, b);//Color 
        
        gl.glBegin(gl.GL_LINES);//Inicio de la creacion//Tipo 
        gl.glLineWidth(2);

        gl.glVertex2d(1, 1);
        gl.glVertex2d(1, -1);
        
        gl.glVertex2d(1, -1);
        gl.glVertex2d(-1, -1);
        
        gl.glVertex2d(-1, -1);
        gl.glVertex2d(-1, 1);
        
        gl.glVertex2d(-1, 1);
        gl.glVertex2d(1, 1);
        
        gl.glEnd();
        
        gl.glPopMatrix();
        
    }
    
    public void gira() {
        rz += 1;
    }
}
