package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

//Padilla O. Zahyta
public class Proyecto_Final implements GLEventListener {

    P_Cuadrado suelo;

    static float a = 0;

    C_Lago lago;
    C_Parqueadero parqueadero;
    C_Canchas cancha;
    C_Parque_Niños parque_niño;
    C_Jardin_Chino jardin;
    C_Caminos caminos;
    C_Parque_Perritos Parq_Perritos;
    C_Arboles arboles;
    C_Cesped cesped;
            
    

    static double camx = -100;
//    static double camy = 70;
    static double camy = 600;
    static double camz = 100;
    
    static double vistx = 0;
    static double visty = 0;
    static double vistz = 0;

    M_Teclado mt;
    M_Mouse mm;

    public static void main(String[] args) {
        Frame frame = new Frame("Proyecto Final");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Proyecto_Final());
        frame.add(canvas);
        frame.setSize(700, 700);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        gl.glEnable(GL.GL_DEPTH_TEST);

        this.mt = new M_Teclado(); //Quitamos el static
        drawable.addKeyListener(mt);
        
        this.mm = new M_Mouse();
        drawable.addMouseListener(mm);

//******************************************************************************************************************************************************************************************
        this.suelo = new P_Cuadrado(gl, 0, -0.1f, 0, 250, 200, 90, 0, 0, 0.1f, 0.4f, 0.2f);
        this.lago = new C_Lago(gl, 0, 0, -40, 40, 50, 50);
        this.parqueadero = new C_Parqueadero(gl, 190, 0, -140, 30, 30, 30);
        this.cancha = new C_Canchas(gl, -160, 0.0f, 110, 80, 80, 80, 90);
        this.parque_niño = new C_Parque_Niños(gl, 150, 0.05f, 100, 70, 70, 70, 0);
        this.jardin = new C_Jardin_Chino(gl, 0, 0.1f, -160, 80, 40, 80, 0);
        this.Parq_Perritos = new C_Parque_Perritos(gl, -170, 0.1f, -100, 50, 50, 50, 0);
        this.caminos = new C_Caminos(gl, 0, 0f, 0, 240, 190, 190, 0);
        this.arboles = new C_Arboles(gl, 0, 0, 0, 250, 200, 200);
//        this.cesped = new C_Cesped(gl, 0, 0, 0, 250, 200, 200);
        

//******************************************************************************************************************************************************************************************
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 800);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        GLU glu = new GLU();

        glu.gluLookAt(camx, camy, camz, vistx, visty, vistz, 0, 1, 0);

        gl.glBegin(gl.GL_LINES);//Inicio de la creacion//Tipo 
        gl.glLineWidth(2);

        gl.glVertex3d(0, 1000, 0);
        gl.glVertex3d(0, -1000, 0);

        gl.glVertex3d(1000, 0, 0);
        gl.glVertex3d(-1000, 0, 0);

        gl.glVertex3d(0, 0, 1000);
        gl.glVertex3d(0, 0, -1000);

        gl.glEnd();

        //******************************************************************************************************************************************************************************************
        this.suelo.Dibuja();
        this.lago.Dibuja();
        this.parqueadero.Dibuja();
        this.cancha.Dibuja();
        this.parque_niño.Dibuja();
        this.jardin.Dibuja();
        this.Parq_Perritos.Dibuja();
        this.caminos.Dibuja();
        this.arboles.Dibuja();
//        this.cesped.Dibuja();
        

        //******************************************************************************************************************************************************************************************
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
