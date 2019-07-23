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

///////Grafico los elementos completos C_
    C_Lago lago1, lago2;
    C_Parqueadero parqueadero1, parqueadero2;
    C_Canchas cancha1, cancha2;
    C_Jardin_Chino jardin1, jardin2;

    C_Caminos caminos1, caminos2;
    C_Parque_Perritos Parq_Perritos1, Parq_Perritos2;
    C_Parque_Niños parque_niño1, parque_niño2;

    C_Arboles arboles1, arboles2;
    C_Personas personas1, personas2;

    C_Estrellas estrellitas;
    C_Nubes nubes;
    C_Cielo cielo;

    E_Bicicleta personaje;
////

//    C_Cesped cesped;
//// Variables de camara
    static double camx = 0;
    static double camy = 1;
    static double camz = 20;

    static double vistx = 0;
    static double visty = 0;
    static double vistz = 0;

    float a = 0;
    static int num_cam = 1;
    int r;
////

//// Variables para el cambio de estado del dia y la noche
    static boolean estado = true; ///dia noche
    static int contador;          ///variable que cuenta el avance 
    static int limite = 100;      ///cantidad máxima
////

//// Manejadores de teclado y mouse
    M_Teclado mt;
    M_Mouse mm;
////

    public static void main(String[] args) {
        Frame frame = new Frame("Proyecto Final Zahyta Padilla Orrala");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Proyecto_Final());
        frame.add(canvas);
        frame.setSize(1000, 500);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    @Override
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

    @Override
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        gl.glEnable(GL.GL_DEPTH_TEST);

//////  Manejadores de teclado y mouse
        this.mt = new M_Teclado();
        drawable.addKeyListener(mt);

        this.mm = new M_Mouse();
        drawable.addMouseListener(mm);
        drawable.addMouseMotionListener(mm);

//******************************************************************************************************************************************************************************************
// creo los objetos, los completos, el tamaño del suelo es 50
// el resto de objetos de acuerdo a lo necesario
//******************************************************************************************************************************************************************************************
        this.suelo = new P_Cuadrado(gl, 0, -0.1f, 0, 50, 20, 90, 0, 0, 0.1f, 0.4f, 0.2f);

        this.lago1 = new C_Lago(gl, 25, 0, -4, 4, 5, 5, 90);
        this.parqueadero1 = new C_Parqueadero(gl, 44, 0, -14, 3, 3, 3, 0);
        this.cancha1 = new C_Canchas(gl, 9f, 0.0f, 11, 8, 15, 8, 90);
        this.parque_niño1 = new C_Parque_Niños(gl, 40, 0.05f, 10, 7, 7, 7, 0);
        this.jardin1 = new C_Jardin_Chino(gl, 25, 0.1f, -16, 8, 4, 8, 0);
        this.Parq_Perritos1 = new C_Parque_Perritos(gl, 8f, 0.1f, -10, 5, 5, 5, 0);
        this.caminos1 = new C_Caminos(gl, 25, 0f, 0, 24, 19, 19, 0);
        this.arboles1 = new C_Arboles(gl, 25, 0, 0, 25, 25, 20, false);
        this.personas1 = new C_Personas(gl, 25, 0, 0, 20, 2.5f, 20);

        this.lago2 = new C_Lago(gl, -25, 0, 4, 4, 5, 3, 270);
        this.parqueadero2 = new C_Parqueadero(gl, -44, 0, -14, 3, 3, 3, 90);
        this.cancha2 = new C_Canchas(gl, -9f, 0.0f, 11, 8, 8, 8, 270);
        this.parque_niño2 = new C_Parque_Niños(gl, -40, 0.05f, 10, 7, 7, 7, 0);
        this.jardin2 = new C_Jardin_Chino(gl, -25, 0.1f, -16, 8, 4, 8, 180);
        this.Parq_Perritos2 = new C_Parque_Perritos(gl, -7f, 0.1f, -12f, 5, 5, 3.5f, 0);
        this.caminos2 = new C_Caminos(gl, -25, 0f, 0, 24, 19, 19, 0);
        this.arboles2 = new C_Arboles(gl, -25, 0, 0, 25, 20, 20, true);
        this.personas2 = new C_Personas(gl, -25, 0, 0, 20, 2.5f, 20);

        this.cielo = new C_Cielo(gl, 0, 10, 0, 90, 40, 50);
        this.estrellitas = new C_Estrellas(gl, 0, 25, 0, 50, 1, 20, 30, .07f, .07f);
        this.nubes = new C_Nubes(gl, 0, 25, 0, 50, 5, 20, 20, .3f, .3f);
        this.personaje = new E_Bicicleta(gl, -35, .1f, 0, 1, 1, 1, 0, 180, 0);
//******************************************************************************************************************************************************************************************
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    @Override
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
        glu.gluPerspective(45.0f, h, 1.0, 300);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        GLU glu = new GLU();

//        ///Ejes guia, x, y, z
//        gl.glBegin(GL.GL_LINES);//Inicio de la creacion//Tipo 
//        gl.glLineWidth(2);
//
//        gl.glVertex3d(0, 100, 0);
//        gl.glVertex3d(0, -100, 0);
//
//        gl.glVertex3d(100, 0, 0);
//        gl.glVertex3d(-100, 0, 0);
//
//        gl.glVertex3d(0, 0, 100);
//        gl.glVertex3d(0, 0, -100);
//
//        gl.glEnd();
//******************************************************************************************************************************************************************************************
/* Coloco los if para cada camara;*/
//******************************************************************************************************************************************************************************************
        this.personaje.movimiento_Bicicleta_Principa();

        if (num_cam == 1) {
            glu.gluLookAt(personaje.x, personaje.y, personaje.z - 2, personaje.x, personaje.y, personaje.z, 0, 1, 0);
        }
        if (num_cam == 2) {

            /*Cámara panorámica*/
            camx = -85;
            camy = 15;
            camz = 45;
            vistx = -20;
            visty = 10;

            glu.gluLookAt(camx, camy, camz, vistx, visty, vistz, 0, 1, 0);
        }
        if (num_cam == 3) {

            /* Cámara que es controlada por teclado la posicion
            y por mouse la vista*/
            glu.gluLookAt(camx, camy, camz, vistx, visty, vistz, 0, 1, 0);
        }
        if (num_cam == 4) {

            /*Cámara que gira al rededor de un objeto*/
            r = 17;
            a = a + 0.005f;

            camx = r * Math.cos(a);
            camz = r * Math.sin(a);

            glu.gluLookAt(lago1.x + camx, 7, camz, lago1.x, 0, lago1.z + 4, 0, 1, 0);
        }
        if (num_cam == 5) {

            /* Vista Cenital del escenario completo*/
            camx = 0;
            camy = 70;
            camz = 1;
            glu.gluLookAt(camx, camy, camz, 0, 0, 0, 0, 1, 0);
        }
//******************************************************************************************************************************************************************************************
// proceso para variar el estado del dia, si el contador es menos que el limite
// sigue aumentando, si no, se reinicia, y el booleano cambia de estado
//******************************************************************************************************************************************************************************************
        if (contador < limite) {
            contador++;
        } else {
            contador = 0;
            estado = !estado;
        }

//******************************************************************************************************************************************************************************************
// Dibujo los elementos, como son completos solo ubico todo, estan 2 de cada uno
// para agrandar el escenario, y  estan volteados
//******************************************************************************************************************************************************************************************
        this.suelo.Dibuja();

        this.lago1.Dibuja();
        this.parqueadero1.Dibuja();
        this.cancha1.Dibuja();
        this.parque_niño1.Dibuja();
        this.jardin1.Dibuja();
        this.Parq_Perritos1.Dibuja();
        this.caminos1.Dibuja();
        this.arboles1.Dibuja();
        this.personas1.Dibuja();

        this.lago2.Dibuja();
        this.parqueadero2.Dibuja();
        this.cancha2.Dibuja();
        this.parque_niño2.Dibuja();
        this.jardin2.Dibuja();
        this.Parq_Perritos2.Dibuja();
        this.caminos2.Dibuja();
        this.arboles2.Dibuja();
        this.personas2.Dibuja();

        // De acuerdo al estado se grafican estrellas o nubes
        // y para un mejor resultado se toma en cuenta el contador 
        if (contador < (limite / 2) && estado == true) {
            this.estrellitas.Dibuja();
        }
        if (contador > (limite / 2) && estado == false) {
            this.estrellitas.Dibuja();
        }
        if (contador < (limite / 2) && estado == false) {
            this.nubes.Dibuja();
        }
        if (contador > (limite / 2) && estado == true) {
            this.nubes.Dibuja();
        }

        this.cielo.Dibuja();
//        this.personaje.Dibuja(true);

//        this.cesped.Dibuja();
//******************************************************************************************************************************************************************************************
// Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

}
