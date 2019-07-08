package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Zay
 */
public class E_Faro {

    GL gl;
    float x, y, z;
    float w, h, p;
    float rx, ry, rz;
    
    

    public E_Faro(GL gl, float x, float y, float z, float w, float h, float p, float rx, float ry, float rz) {
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
    }
    
    
}
