package GUI;
//import of self coded Java-classes
import Functionalities.Select;
import Geometries.Circle;
import Geometries.Figure;
import Geometries.Point;
import Geometries.Polygon;
import Geometries.PolyLine;
import Geometries.Rectangle;
import Geometries.Triangle;
//import of general Java-classes
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * GUI of the project, also a lot of functionaliies are implemented here
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        21.10.2016
 * @version         18.01.2017
 */
public class drawingGUI extends javax.swing.JFrame {
    //Initialize boolean variables for all functions
    //Drawing
    boolean inside=false;
    boolean dpoint=false;
    boolean dline=false;
    boolean dtri3sides=false;
    boolean drectangle=false;
    boolean dCirCentRad=false;
    boolean dpolygon=false;
    //Editing, selecting, deleting, saving and opening
    boolean edit=false;
    boolean select=false;
    boolean delete=false;
    boolean save=false;
    boolean open=false;
    
    //*************Own global variables***********************     
    //***********POINTS*****************
    //List of points
    private List<Point> points=new ArrayList<Point>();
    //Points ID
    private int pointID=0;
    
    //***********LINES*****************
    //List of lines
    private Point first_line_point;
    private Point temporal_line_point;
    private boolean digit=false;
    private List<PolyLine> lines=new ArrayList<PolyLine>();
    private PolyLine currentLine=new PolyLine("Polyline", Color.RED);   //The current line (for capturing)
    
    //***********TRIANGLES*****************
    //List of triangles
    private Point first_tri_point;
    private Point temporal_tri_point;
    private boolean digit_tri=false;
    private List<Triangle> triangles=new ArrayList<Triangle>();
    private Triangle current_tri=new Triangle("Triangle", Color.MAGENTA);   //The current triangle (for capturing)
    
    //***********RECTANGLES*****************
    //List of rectangles
    private List<Rectangle> rectangles=new ArrayList<Rectangle>();
    Point startDrag, endDrag;
    private Rectangle current_rect; //The current rectangle (for capturing)
    private Rectangle temp_rect;
    
    private boolean digit_rect=false;
    private boolean finish_rect;
    
    //***********CIRCLES*****************
    //List of circles
    private List<Circle> circles=new ArrayList<Circle>();
    Point center, endRadius;
    private Circle current_circ; //The current circle (for capturing)
    private Circle temp_circ;
    private boolean motion_circ=false;
    
    private boolean digit_circ=false;
    private boolean finish_circ;
    
    //***********POLYGONS*****************
    //List of triangles
    private Point first_poly_point;
    private Point temporal_poly_point;
    private boolean digit_pol=false;
    private boolean finish=false;
    private List<Polygon> polygons=new ArrayList<Polygon>();
    private Polygon current_pol=new Polygon("Polygon", Color.CYAN);   //The current polygon (for capturing)
    
    
    public Graphics g;

    //***********SELECT*****************
    //List of selected objects
    private List<Figure> selectedObjects=new ArrayList<Figure>();
    private Select selectObjects = null;
    
    //**********EDIT*********************
    String feature="";
    //Variable that indicates if the element has been snapped
    boolean snap=false;
    //Variable that indicates if the snapped element has been clicked
    boolean movePoint=false;
    //Variable that indicates if the clicked element has started to move its coordinates
    boolean eddited=false;
    
    //*******POINTS********
    private Point editPoint;
        
    //*******POLYLINES******
    private PolyLine editLine;
    
    //*******TRIANGLES******
    private Triangle editTriangle;
    
    //*******RECTANGLES******
    private Rectangle editRectangle;
    private Point editIniPoint;
    private Point editEndPoint;
    private boolean initial_Snap;
    private boolean end_Snap;
    
    //*******CIRCLES******
    private Circle editCircle;
    
    //*******POLYGONS******
    private Polygon editPolygon;
    
    //*******************************GENERATED CODE********************
    /**
     * Creates new form drawingGUI
     */
    public drawingGUI() {
        setTitle("Drawing GUI");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     * The following part up to line 381 is autogenerated by creating the GUI
     * it defines the GUI and set mouseListener to all buttons and the canvas
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        info_label = new javax.swing.JLabel();
        coordinates_title = new javax.swing.JLabel();
        coordinates_label = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        canvas = new javax.swing.JPanel();
        open_label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        point_bttn = new javax.swing.JMenu();
        line_bttn = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        three_sides = new javax.swing.JMenuItem();
        rectangle = new javax.swing.JMenuItem();
        center_radius = new javax.swing.JMenuItem();
        poligon = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        edit_bttn = new javax.swing.JMenu();
        select_bttn = new javax.swing.JMenu();
        delete_bttn = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        save_bttn = new javax.swing.JMenu();
        open_bttn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 0));

        info_label.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        info_label.setText("© Adrían Castelló Martínez, Fabian Finkbeiner, Benedikt Futterer, Macarena Parizas Siles");
        info_label.setToolTipText("");

        coordinates_title.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        coordinates_title.setText("Coordinates:");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo.gif"))); // NOI18N
        logo.setToolTipText("");

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                canvasMouseMoved(evt);
            }
        });
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                canvasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                canvasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        jMenuBar1.setMaximumSize(new java.awt.Dimension(213, 400));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(35, 35));

        point_bttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/point.png"))); // NOI18N
        point_bttn.setToolTipText("Point");
        point_bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                point_bttnMouseClicked(evt);
            }
        });
        jMenuBar1.add(point_bttn);

        line_bttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/line.png"))); // NOI18N
        line_bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                line_bttnMouseClicked(evt);
            }
        });
        jMenuBar1.add(line_bttn);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/polygon.png"))); // NOI18N

        three_sides.setText("Triangle");
        three_sides.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                three_sidesMousePressed(evt);
            }
        });
        jMenu3.add(three_sides);

        rectangle.setText("Rectangle");
        rectangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rectangleMousePressed(evt);
            }
        });
        jMenu3.add(rectangle);

        center_radius.setText("Circle");
        center_radius.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                center_radiusMousePressed(evt);
            }
        });
        jMenu3.add(center_radius);

        poligon.setLabel("Polygon");
        poligon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                poligonMousePressed(evt);
            }
        });
        jMenu3.add(poligon);

        jMenuBar1.add(jMenu3);

        jMenu4.setAlignmentX(5.0F);
        jMenu4.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jMenuBar1.add(jMenu4);

        edit_bttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/edit.gif"))); // NOI18N
        edit_bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_bttnMouseClicked(evt);
            }
        });
        jMenuBar1.add(edit_bttn);

        select_bttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Select_v2.png"))); // NOI18N
        select_bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                select_bttnMouseClicked(evt);
            }
        });
        jMenuBar1.add(select_bttn);

        delete_bttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete.gif"))); // NOI18N
        delete_bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_bttnMouseClicked(evt);
            }
        });
        jMenuBar1.add(delete_bttn);

        jMenu6.setAlignmentX(5.0F);
        jMenu6.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jMenuBar1.add(jMenu6);

        save_bttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/SAVEi.gif"))); // NOI18N
        save_bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_bttnMouseClicked(evt);
            }
        });
        jMenuBar1.add(save_bttn);

        open_bttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/open.gif"))); // NOI18N
        open_bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                open_bttnMouseClicked(evt);
            }
        });
        jMenuBar1.add(open_bttn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coordinates_title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(coordinates_label, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(info_label)
                                .addGap(0, 415, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(open_label, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(open_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 514, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coordinates_title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinates_label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info_label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(45, Short.MAX_VALUE)
                    .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //******************BUTTON LISTENERS***************************
    private void point_bttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_point_bttnMouseClicked
        /**
         * the following methods (up to line 466) the description is nearly the same,
         * therefore it is done here just once.
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         03.11.2016
        * @version          18.01.2017
        * if button for drawing points is clicked, set boolean variable for draw point method dpoint to true and
        * print "Point"
        * return           dpoint=true
        */
        dpoint=true;
        dline=false;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=false;
        edit=false;
        select=false;
        delete=false;
        save=false;
        open=false;
        
        System.out.println("Point");       
    }//GEN-LAST:event_point_bttnMouseClicked

    private void line_bttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_line_bttnMouseClicked
        /**
        * @author Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * @version 18.01.2017
        */
        dpoint=false;
        dline=true;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=false;
        edit=false;
        select=false;
        delete=false;
        save=false;
        open=false;
        
        System.out.println("Line");
    }//GEN-LAST:event_line_bttnMouseClicked

    private void rectangleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rectangleMousePressed
        /**
        * @author Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * @version 18.01.2017
        */
        dpoint=false;
        dline=false;
        dtri3sides=false;
        drectangle=true;
        dCirCentRad=false;
        dpolygon=false;
        edit=false;
        select=false;
        delete=false;
        save=false;
        open=false;
        
        System.out.println("Rectangle");
    }//GEN-LAST:event_rectangleMousePressed

    private void poligonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poligonMousePressed
        /**
        * @author Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * @version 18.01.2017
        */
        dpoint=false;
        dline=false;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=true;
        edit=false;
        select=false;
        delete=false;
        save=false;
        open=false;
        
        System.out.println("Polygon");
    }//GEN-LAST:event_poligonMousePressed
  
void deselect(){
        Graphics g=(Graphics2D)canvas.getGraphics();
        /**
        * this function will deselect all selected features
        * therefore the color of the selected features will set back to their original ones
        * and the array in which the selected features are stored will be cleared
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         17.11.2016
        * @version          18.01.2017
        * return           set the color of feature back to the original ones
        * return           clear array selectedObjects
        */
        for(Figure figure : selectedObjects) {
            if (figure instanceof Point)
                figure.setColor(Color.GREEN);
            else if(figure instanceof PolyLine)
                figure.setColor(Color.RED);
            else if(figure instanceof Rectangle)
                figure.setColor(Color.PINK);
            else if(figure instanceof Triangle)
                figure.setColor(Color.MAGENTA);
            else if(figure instanceof Circle)
                figure.setColor(Color.ORANGE);
            else if(figure instanceof Polygon)
                figure.setColor(Color.CYAN);
        }
        selectedObjects.clear();
        /*redrawing canvas
         * 1)clear canvas by drawing it white
         * 2)repaint all the objects
        */
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        paintall(g);
    }    
    
    
    private void canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMousePressed
        /**
        * Definition of methods, which are executed if the corresponding boolean variable is true
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         04.11.2016
        * @version          18.01.2017
        */
        Graphics2D g=(Graphics2D)canvas.getGraphics();
        
        //*****If POINT button is clicked
        if (dpoint==true){
            /**
             * draw point on left click
             * insert point to database
             * for the following statements is nearly the same, just the feature type changes (until line 681)
             */
            if (evt.getButton()==1){
                Color color=Color.GREEN;
                Point newPoint=new Point("Point", color, evt.getX(), evt.getY());
                points.add(newPoint);
                
                //Insert into database
                newPoint.insertSQL();
                
                paintall(g);
                deselect();
            }
        }
        
        //******If LINE button is clicked
        if (dline==true){
            if (evt.getButton()==1){
                //if (digit==false){
                digit=true;
                if (digit){
                    int x1=evt.getX();
                    int y1=evt.getY();
                    first_line_point=new Point("Point", Color.RED, x1, y1);
                    currentLine.addPoint(first_line_point, g);
                    paintall(g);
                    //clear ArrayList of selected objects
                    deselect();
                }
            }
            if (evt.getButton()==3){
                if (currentLine.getSize()>1){
                    digit=false;
                    lines.add(currentLine);                    
                    //Insert into database
                    currentLine.insertSQL();
                    paintall(g);
                    //clear ArrayList of selected objects
                    deselect();
                    currentLine = new PolyLine("Polyline", Color.RED);
                }
            }
        }
        
        //******If TRIANGLE button is clicked
        if (dtri3sides==true){
            if (evt.getButton()==1){
                //if (digit==false){
                digit_tri=true;
                if (digit_tri==true && current_tri.getSize()<2){
                    int x1=evt.getX();
                    int y1=evt.getY();
                    first_tri_point=new Point("Point", Color.RED, x1, y1);
                    current_tri.addPoint(first_tri_point, g);
                    paintall(g);
                    //clear ArrayList of selected objects
                    deselect();
                }
            }
            if (evt.getButton()==3){
                if (current_tri.getSize()>1){
                    digit_tri=false;
                    Point end_point=new Point("Point", Color.RED, evt.getX(), evt.getY());
                    current_tri.addPoint(end_point, g);
                    triangles.add(current_tri);                    
                    //Insert into database
                    current_tri.insertSQL();                    
                    paintall(g);
                    //clear ArrayList of selected objects
                    deselect();
                    current_tri = new Triangle("Triangle", Color.MAGENTA);
                }
            }
        }
        
        //******If RECTANGLE button is clicked
        if (drectangle==true){
            if (evt.getButton()==1){
                digit_rect=true;
                finish_rect=false;
                startDrag=new Point("Point", Color.ORANGE, evt.getX(), evt.getY());
                endDrag=startDrag;
                paintall(g);
            }
            
            if (evt.getButton()==3){
                digit_rect=false;
                endDrag=new Point("Point", Color.ORANGE, evt.getX(), evt.getY());
                current_rect= new Rectangle("Rectangle", Color.PINK, startDrag, endDrag);
                rectangles.add(current_rect);                
                //Insert into database
                current_rect.insertSQL();                    
                startDrag=null;
                endDrag=null;
                finish_rect=true;
                deselect();
                paintall(g);
            }
        }
        
        //******If CIRCLE button is clicked
        if (dCirCentRad==true){
            if (evt.getButton()==1){
                digit_circ=true;
                finish_circ=false;
                motion_circ=false;
                center=new Point("Point", Color.ORANGE, evt.getX(), evt.getY());
                endRadius=center;
                paintall(g);
            }
            
            if (evt.getButton()==3){
                digit_circ=false;
                motion_circ=false;
                endRadius=new Point("Point", Color.ORANGE, evt.getX(), evt.getY());
                current_circ= new Circle("Circle", Color.ORANGE, center, endRadius);
                circles.add(current_circ);                
                //Insert into database
                current_circ.insertSQL();                
                center=null;
                endRadius=null;
                finish_circ=true;
                deselect();
                paintall(g);
            }
        }
        
        //******If POLYGON button is clicked
        if (dpolygon==true){
            if (evt.getButton()==1){
                //if (digit==false){
                digit_pol=true;
                finish=false;
                if (digit_pol==true){
                    int x1=evt.getX();
                    int y1=evt.getY();
                    first_poly_point=new Point("Point", Color.RED, x1, y1);
                    current_pol.addPoint(first_poly_point, g);
                    paintall(g);
                    //clear ArrayList of selected objects
                    deselect();
                }
            }
            if (evt.getButton()==3){
                if (current_pol.getSize()>2){
                    digit_pol=false;
                    finish=true;
                    Point end_point=new Point("Point", Color.RED, evt.getX(), evt.getY());                    
                    //Insert into database
                    current_pol.insertSQL();                    
                    current_pol.addPoint(end_point, g);
                    polygons.add(current_pol);
                    paintall(g);
                    //clear ArrayList of selected objects
                    deselect();
                    current_pol = new Polygon("Polygon", Color.CYAN);
                }
            }
        }
                
        //*****If SELECT button is clicked
        /**
        * select objects by an rectangle
        * selected objects are shown in dark blue
        * and stored in the arryList selectedObjects
        * Added [feature type] is printed
        * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation        17.11.2016
        * @version         18.01.2017
        * up to line 850
        */
        if (select==true){
            select=false;
            if (evt.getButton()==1){
                //clear ArrayList of selected objects
                deselect();
                selectObjects = new Select(evt.getX(), evt.getY());                
            }
        } else if(selectObjects != null) {
            //redrawing canvas
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            paintall(g);
            
            //**********************POINTS***********************
            for (Point point : points){
                //check if Point is inside selection rectangle
                if (point.getX() > selectObjects.fromX
                        && point.getX() < selectObjects.toX 
                        && point.getY() > selectObjects.fromY
                        && point.getY() < selectObjects.toY) {
                    //set color of Point to blue, if he is inside selection rectangle
                    point.setColor(Color.BLUE);
                    //add point to Selected Objects Array List
                    selectedObjects.add(point);
                    //print comment "Added Point"
                    System.out.println("Added Point");
                }
            }
            
            //**********************POLYLINES***********************
            for (PolyLine line:lines) {
                for (Point point : line.getPointList()) {
                    if (point.getX() > selectObjects.fromX
                            && point.getX() < selectObjects.toX 
                            && point.getY() > selectObjects.fromY
                            && point.getY() < selectObjects.toY) {
                    line.setColor(Color.BLUE);
                        selectedObjects.add(line);
                        System.out.println("Added Line");
                        break;
                    }
                }
            }
            
            //**********************TRIANGLES***********************
            for (Triangle tri:triangles) {
                for (Point point : tri.getPointList()) {
                    if (point.getX() > selectObjects.fromX
                            && point.getX() < selectObjects.toX 
                            && point.getY() > selectObjects.fromY
                            && point.getY() < selectObjects.toY) {
                        tri.setColor(Color.BLUE);
                        selectedObjects.add(tri);
                        System.out.println("Added Triangle");
                        break;
                    }
                }
            }
            
            //**********************RECTANGLES***********************
            for (Rectangle rect:rectangles) {                
                if (rect.getInitialPoint().getX() > selectObjects.fromX
                        && rect.getInitialPoint().getX() < selectObjects.toX 
                        && rect.getInitialPoint().getY() > selectObjects.fromY
                        && rect.getInitialPoint().getY() < selectObjects.toY) {
                rect.setColor(Color.BLUE);
                    selectedObjects.add(rect);
                    System.out.println("Added Rectangle (InitialPoint");
                    break;
                }
                if (rect.getEndPoint().getX() > selectObjects.fromX
                        && rect.getEndPoint().getX() < selectObjects.toX 
                        && rect.getEndPoint().getY() > selectObjects.fromY
                        && rect.getEndPoint().getY() < selectObjects.toY) {
                rect.setColor(Color.BLUE);
                    selectedObjects.add(rect);
                    System.out.println("Added Rectangle(EndPoint)");
                    break;
                }
                if (rect.getInitialPoint().getX() > selectObjects.fromX
                        && rect.getInitialPoint().getX() < selectObjects.toX 
                        && rect.getEndPoint().getY() > selectObjects.fromY
                        && rect.getEndPoint().getY() < selectObjects.toY) {
                rect.setColor(Color.BLUE);
                    selectedObjects.add(rect);
                    System.out.println("Added Rectangle (InitialPoint");
                    break;
                }
                if (rect.getEndPoint().getX() > selectObjects.fromX
                        && rect.getEndPoint().getX() < selectObjects.toX 
                        && rect.getInitialPoint().getY() > selectObjects.fromY
                        && rect.getInitialPoint().getY() < selectObjects.toY) {
                rect.setColor(Color.BLUE);
                    selectedObjects.add(rect);
                    System.out.println("Added Rectangle(EndPoint)");
                    break;
                }
            }
            
            //**********************CIRCLES***********************
            for (Circle cir:circles) {                
                if (cir.getCenter().getX()-cir.getRadius()/2 > selectObjects.fromX
                        && cir.getCenter().getX()-cir.getRadius()/2 < selectObjects.toX 
                        && cir.getCenter().getY()-cir.getRadius()/2 > selectObjects.fromY
                        && cir.getCenter().getY()-cir.getRadius()/2 < selectObjects.toY) {
                    cir.setColor(Color.BLUE);
                    selectedObjects.add(cir);
                    System.out.println("Added Circle");
                    break;
                }                
                if (cir.getCenter().getX()-cir.getRadius()/2 > selectObjects.fromX
                        && cir.getCenter().getX()-cir.getRadius()/2 < selectObjects.toX 
                        && cir.getCenter().getY()+cir.getRadius()/2 > selectObjects.fromY
                        && cir.getCenter().getY()+cir.getRadius()/2 < selectObjects.toY) {
                    cir.setColor(Color.BLUE);
                    selectedObjects.add(cir);
                    System.out.println("Added Circle");
                    break;
                }                
                if (cir.getCenter().getX()+cir.getRadius()/2 > selectObjects.fromX
                        && cir.getCenter().getX()+cir.getRadius()/2 < selectObjects.toX 
                        && cir.getCenter().getY()-cir.getRadius()/2 > selectObjects.fromY
                        && cir.getCenter().getY()-cir.getRadius()/2 < selectObjects.toY) {
                    cir.setColor(Color.BLUE);
                    selectedObjects.add(cir);
                    System.out.println("Added Circle");
                    break;
                }                
                if (cir.getCenter().getX()+cir.getRadius()/2 > selectObjects.fromX
                        && cir.getCenter().getX()+cir.getRadius()/2 < selectObjects.toX 
                        && cir.getCenter().getY()+cir.getRadius()/2 > selectObjects.fromY
                        && cir.getCenter().getY()+cir.getRadius()/2 < selectObjects.toY) {
                    cir.setColor(Color.BLUE);
                    selectedObjects.add(cir);
                    System.out.println("Added Circle");
                    break;
                }
            }
            
            //**********************POLYGONS***********************
            for (Polygon pol:polygons) {
                for (Point point : pol.getPointList()) {
                    if (point.getX() > selectObjects.fromX
                            && point.getX() < selectObjects.toX 
                            && point.getY() > selectObjects.fromY
                            && point.getY() < selectObjects.toY) {
                    pol.setColor(Color.BLUE);
                        selectedObjects.add(pol);
                        System.out.println("Added Polygon");
                        break;
                    }
                }
            }
            //redrawing canvas
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            paintall(g);
            selectObjects = null;   
        }
        
        //*********************** EDDITING FEATURES ************************
        /**
        * edit shape of objects
        * save new coordinates of changed edges
        * all editable edges are shown in yellow
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         10.11.2016
        * @version          18.01.2017
        * up to line 958
        */
        if (edit==true){
            if (evt.getButton()==1){
                    if(snap==true){
                        System.out.println("clicked");
                        movePoint=true; 
                    }
                }
            
            if (evt.getButton()==3){
                //************************** POINTS ****************************
                if(movePoint==true && feature=="Point"){
                    points.get(points.indexOf(editPoint)).setX(evt.getX());
                    points.get(points.indexOf(editPoint)).setY(evt.getY());
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    paintall(g);
                    movePoint=false;
                    eddited=false;
                }
                
                //************************** LINES *****************************
                if(movePoint==true && feature=="Line"){
                    List<Point> line_points=lines.get(lines.indexOf(editLine)).getPointList();
                    line_points.get(line_points.indexOf(editPoint)).setX(evt.getX());
                    line_points.get(line_points.indexOf(editPoint)).setY(evt.getY());
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    paintall(g);
                    movePoint=false;
                    eddited=false;
                    editLine=null;
                }
                
                //************************** TRIANGLES *************************
                if(movePoint==true && feature=="Triangle"){
                    List<Point> line_points=triangles.get(triangles.indexOf(editTriangle)).getPointList();
                    line_points.get(line_points.indexOf(editPoint)).setX(evt.getX());
                    line_points.get(line_points.indexOf(editPoint)).setY(evt.getY());
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    paintall(g);
                    movePoint=false;
                    eddited=false;
                    editTriangle=null;
                }

                //*************************RECTANGLES***************************
                if(movePoint==true && feature=="Rectangles"){
                    eddited=true;
                    if(initial_Snap){
                        rectangles.get(rectangles.indexOf(editRectangle)).getInitialPoint().setX(evt.getX());
                        rectangles.get(rectangles.indexOf(editRectangle)).getInitialPoint().setY(evt.getY());
                    }
                    if(end_Snap){
                        rectangles.get(rectangles.indexOf(editRectangle)).getEndPoint().setX(evt.getX());
                        rectangles.get(rectangles.indexOf(editRectangle)).getEndPoint().setY(evt.getY());
                    }
                    //redrawing canvas
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    paintall(g);
                    movePoint=false;
                    eddited=false;
                    editRectangle=null;
                }
                
                //****************************CIRCLE****************************
                if(movePoint==true && feature=="Circles"){
                    eddited=true;
                    Point new_center=new Point("Point", Color.BLACK, evt.getX(), evt.getY());
                    circles.get(circles.indexOf(editCircle)).setCenter(new_center);
                    //redrawing canvas
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    paintall(g);
                    movePoint=false;
                    eddited=false;
                    editCircle=null;
                }
                
                //**************************POLYGONS****************************
                if(movePoint==true && feature=="Polygons"){
                    eddited=true;
                    List<Point> pol_points=polygons.get(polygons.indexOf(editPolygon)).getPointList();
                    pol_points.get(pol_points.indexOf(editPoint)).setX(evt.getX());
                    pol_points.get(pol_points.indexOf(editPoint)).setY(evt.getY());
                    //redrawing canvas
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    paintall(g);
                    movePoint=false;
                    eddited=false;
                    editPolygon=null;
                }
            }
        }
    }//GEN-LAST:event_canvasMousePressed

    private void canvasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseMoved
        /**
        * Definition of methods, which are executed if the corresponding boolean variable is true
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         04.11.2016 
        * @version          18.01.2017
        */
        Graphics2D g=(Graphics2D)canvas.getGraphics();
        
        //***************** IF A DRAWING BUTTON IS PRESSED *************************
        /**
         * drawing features
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         03.11.2016
        * @version          18.01.2017
        */
        
        //************************* MOVING LINES *******************************
        if(dline==true){
            //Temporal Line created when moving
            if(digit==true){                
                int x=evt.getX();
                int y=evt.getY();
                temporal_line_point=new Point("Point", Color.GREEN, x, y);
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
                currentLine.drawMotion(temporal_line_point, g);             
            }
        }
        
        //************************* MOVING TRIANGLES ***************************
        if(dtri3sides==true){
            //Temporal Lines created when moving
            if(digit_tri==true){                
                int x=evt.getX();
                int y=evt.getY();
                temporal_tri_point=new Point("Point", Color.GREEN, x, y);
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
                current_tri.drawMotion(temporal_tri_point, Color.LIGHT_GRAY, g);             
            }
        }
        
        
        //************************* MOVING RECTANGLES **************************
        if (drectangle==true){
            //Temporal rectangle created when moving
            if (digit_rect==true){
                endDrag=new Point("Point", Color.ORANGE, evt.getX(), evt.getY());
                temp_rect= new Rectangle("Rectangle", Color.LIGHT_GRAY, startDrag, endDrag);
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
                temp_rect.draw(g);
            } 
        }
        
        //************************* MOVING CIRCLES *****************************
        if (dCirCentRad==true){
            //Temporal circle created when moving
            if (digit_circ==true){
                motion_circ=true;
                System.out.println(evt.getX()+", "+evt.getY());
                endRadius=new Point("Point", Color.ORANGE, evt.getX(), evt.getY());
                temp_circ= new Circle("Rectangle", Color.LIGHT_GRAY, center, endRadius);
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
                temp_circ.draw(g);
            } 
        }
        
        //************************* MOVING POLYGON-LINE ************************
        if(dpolygon==true){
            //Temporal Line created when moving
            if(digit_pol==true){                
                int x=evt.getX();
                int y=evt.getY();
                temporal_poly_point=new Point("Point", Color.GREEN, x, y);
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
                current_pol.drawMotion(temporal_poly_point, Color.LIGHT_GRAY, g);             
            }
        }
        
        //*********************** NOTHING SELECTED *****************************
        if (selectObjects != null) {
            selectObjects.moved(evt.getX(), evt.getY());
            //redrawing canvas
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            paintall(g);
            selectObjects.draw(g);
        }
        
        //***************** IF EDDIT BUTTON IS PRESSED *************************
        /**
         * editing features
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         10.11.2016
        * @version          18.01.2017
        */
        if (edit==true){
            //**********************POINTS***********************
            for (Point point : points){
                if (point.getX() > evt.getX()-10
                        && point.getX() < evt.getX()+10 
                        && point.getY() > evt.getY()-10
                        && point.getY() < evt.getY()+10) {
                    if (eddited==false) {
                        editPoint=point;
                    }
                    point.setColor(Color.YELLOW);
                    point.draw(g);
                    snap=true;
                    feature="Point";
                    break;
                } 
                else {
                    point.setColor(Color.GREEN);
                    point.draw(g);
                }    
            }

            //**********************POLYLINES***********************
            for (PolyLine line : lines){
                List<Point> points_list=line.getPointList();
                for (Point point : points_list) {
                    if (point.getX() > evt.getX()-10
                            && point.getX() < evt.getX()+10 
                            && point.getY() > evt.getY()-10
                            && point.getY() < evt.getY()+10) {
                        if (eddited==false) {
                            editPoint=point; 
                            feature="Line";
                        }
                        snap=true;
                        point.setColor(Color.YELLOW);
                        point.draw(g);
                        editLine=line;                        
                        break;
                    } 
                    else {
                        point.setColor(Color.BLACK);
                        point.draw(g);
                    }
                }     
            }
            
            //**********************TRIANGLES***********************
            for (Triangle tri : triangles){
                List<Point> points_list=tri.getPointList();
                for (Point point : points_list) {
                    if (point.getX() > evt.getX()-10
                            && point.getX() < evt.getX()+10 
                            && point.getY() > evt.getY()-10
                            && point.getY() < evt.getY()+10) {
                        if (eddited==false) {
                            editPoint=point; 
                            feature="Triangle";
                        }
                        snap=true;
                        point.setColor(Color.YELLOW);
                        point.draw(g);
                        editTriangle=tri;                        
                        break;
                    } 
                    else {
                        point.setColor(Color.BLACK);
                        point.draw(g);
                    }
                }     
            }
            
            //**********************RECTANGLES***********************
            for (Rectangle rect : rectangles){
                Point initial=rect.getInitialPoint();
                Point end=rect.getEndPoint();
                if (initial.getX() > evt.getX()-10
                        && initial.getX() < evt.getX()+10 
                        && initial.getY() > evt.getY()-10
                        && initial.getY() < evt.getY()+10) {
                    if (eddited==false) {
                        editIniPoint=initial;
                        initial_Snap=true;
                        end_Snap=false;
                        feature="Rectangles";
                    }
                    snap=true;
                    initial.setColor(Color.YELLOW);
                    initial.draw(g);
                    editRectangle=rect;

                    break;
                }
                else if (end.getX() > evt.getX()-10
                        && end.getX() < evt.getX()+10 
                        && end.getY() > evt.getY()-10
                        && end.getY() < evt.getY()+10) {
                    if (eddited==false) {
                        editEndPoint=end;
                        end_Snap=true;
                        initial_Snap=false;
                        feature="Rectangles";
                    }
                    snap=true;
                    end.setColor(Color.YELLOW);
                    end.draw(g);
                    editRectangle=rect;
                    break;
                }
                else {
                    initial.setColor(Color.BLACK);
                    initial.draw(g);
                    end.setColor(Color.BLACK);
                    end.draw(g);
                }   
            }
            
            //**********************CIRCLES***********************
            for (Circle circ : circles){
                Point point=circ.getCenter();
                if (point.getX() > evt.getX()-10
                        && point.getX() < evt.getX()+10 
                        && point.getY() > evt.getY()-10
                        && point.getY() < evt.getY()+10) {
                    if (eddited==false) {
                        editPoint=point;
                    }
                    point.setColor(Color.YELLOW);
                    point.draw(g);
                    snap=true;
                    feature="Circles";
                    editCircle=circ;
                    break;
                } 
                else {
                    point.setColor(Color.BLACK);
                    point.draw(g);
                }    
            }
            
            //**********************POLYGONS***********************
            for (Polygon pol : polygons){
                List<Point> points_list=pol.getPointList();
                for (Point point : points_list) {
                    if (point.getX() > evt.getX()-10
                            && point.getX() < evt.getX()+10 
                            && point.getY() > evt.getY()-10
                            && point.getY() < evt.getY()+10) {
                        if (eddited==false) {
                            editPoint=point; 
                            feature="Polygons";
                        }
                        snap=true;
                        point.setColor(Color.YELLOW);
                        point.draw(g);
                        editPolygon=pol;                        
                        break;
                    } 
                    else {
                        point.setColor(Color.BLACK);
                        point.draw(g);
                    }
                }     
            }
            
            //*****************POINTS*********************
            if(movePoint==true && feature=="Point"){
                eddited=true;
                points.get(points.indexOf(editPoint)).setX(evt.getX());
                points.get(points.indexOf(editPoint)).setY(evt.getY());
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
            }

            //*****************LINES*********************
            if(movePoint==true && feature=="Line"){
                eddited=true;
                List<Point> line_points=lines.get(lines.indexOf(editLine)).getPointList();
                line_points.get(line_points.indexOf(editPoint)).setX(evt.getX());
                line_points.get(line_points.indexOf(editPoint)).setY(evt.getY());
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
            }
            
            //*****************TRIANGLES*********************
            if(movePoint==true && feature=="Triangle"){
                eddited=true;
                List<Point> line_points=triangles.get(triangles.indexOf(editTriangle)).getPointList();
                line_points.get(line_points.indexOf(editPoint)).setX(evt.getX());
                line_points.get(line_points.indexOf(editPoint)).setY(evt.getY());
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
            }

            //*****************RECTANGLES*********************
            if(movePoint==true && feature=="Rectangles"){
                eddited=true;
                if(initial_Snap){
                    rectangles.get(rectangles.indexOf(editRectangle)).getInitialPoint().setX(evt.getX());
                    rectangles.get(rectangles.indexOf(editRectangle)).getInitialPoint().setY(evt.getY());
                }
                if(end_Snap){
                    rectangles.get(rectangles.indexOf(editRectangle)).getEndPoint().setX(evt.getX());
                    rectangles.get(rectangles.indexOf(editRectangle)).getEndPoint().setY(evt.getY());
                }
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
            }
            
            //*****************CIRCLE*********************
            if(movePoint==true && feature=="Circles"){
                eddited=true;
                Point new_center=new Point("Point", Color.BLACK, evt.getX(), evt.getY());
                circles.get(circles.indexOf(editCircle)).setCenter(new_center);
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
            }
            
            //*****************POLYGONS*********************
            if(movePoint==true && feature=="Polygons"){
                eddited=true;
                List<Point> pol_points=polygons.get(polygons.indexOf(editPolygon)).getPointList();
                pol_points.get(pol_points.indexOf(editPoint)).setX(evt.getX());
                pol_points.get(pol_points.indexOf(editPoint)).setY(evt.getY());
                //redrawing canvas
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintall(g);
            }            
        }
       
        //*********************** COORDINATES LABEL ****************************
        /**
         * set coordinates of pointer to JLabel cordinates_label
         */
        if(inside==true){
            coordinates_label.setText("("+evt.getX()+", "+evt.getY()+")");
        }
    }//GEN-LAST:event_canvasMouseMoved

    private void canvasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseEntered
        /**
        * mouse is into canvas
        *
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         04.11.2016
        * @version          18.01.2017
        */
        inside=true;
    }//GEN-LAST:event_canvasMouseEntered

    private void canvasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseExited
        /**
        * if mouse leaves canvas, set coordinate display empty
        *
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         04.11.2016
        * @version          18.01.2017
        */
        coordinates_label.setText("");
        inside=false;
    }//GEN-LAST:event_canvasMouseExited

    private void edit_bttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_bttnMouseClicked
        /**
         * the following methods (up to line 1667) the description is nearly the same,
         * therefore it is done here just once.
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         03.11.2016
        * @version          18.01.2017
        * if button for editing is clicked, set boolean variable for editing method dpoint to true and
        * print "Edit"
        * return           edit=true
        */
        dpoint=false;
        dline=false;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=false;
        edit=true;
        select=false;
        delete=false;
        save=false;
        open=false;
        
        System.out.println("Edit");
    }//GEN-LAST:event_edit_bttnMouseClicked

    private void select_bttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_select_bttnMouseClicked
        /**
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         03.11.2016
        * @version          18.01.2017
        */
        dpoint=false;
        dline=false;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=false;
        edit=false;
        select=true;
        delete=false;
        save=false;
        open=false;
        
        System.out.println("Select");
    }//GEN-LAST:event_select_bttnMouseClicked

    private void delete_bttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_bttnMouseClicked
        /**
        * Delete the elements inside the selection rectangle
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         18.11.2016
        * @version          18.01.2017
        */
        dpoint=false;
        dline=false;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=false;
        edit=false;
        select=false;
        delete=true;
        save=false;
        open=false;
        
        System.out.println("Delete");
        Graphics g=(Graphics2D)canvas.getGraphics();
        
        //Delete the elements inside the selection rectangle
        for(Figure figure : selectedObjects) {
                System.out.println("Deleted");
            if (figure instanceof Point)
                points.remove(figure);
            else if(figure instanceof PolyLine)
                lines.remove(figure);
            else if(figure instanceof Rectangle)
                rectangles.remove(figure);
            else if(figure instanceof Triangle)
                triangles.remove(figure);
            else if(figure instanceof Circle)
                circles.remove(figure);
            else if(figure instanceof Polygon)
                polygons.remove(figure);
        }
        //redrawing canvas
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        paintall(g);
    }//GEN-LAST:event_delete_bttnMouseClicked

    //***************************** SAVING IN CSV ******************************
    private void save_bttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_bttnMouseClicked
        /**
        * Save objects to a CSV file "saved_geometry.csv"
        *
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         07.12.2016
        * @version          18.01.2017
        */
        String message="";
        try {
            PrintWriter pw=new PrintWriter(new File("saved_geometry.csv"));
            StringBuilder sb=new StringBuilder();
            //*****************POINTS****************//
            if (points.size()>0){
                for (Point point : points){
                    sb.append(point.toCSV()+"\n");
                }
                if(message==""){
                    message+="Points";
                }
                else{
                    message+=", Points";
                }
            }
            //*****************LINES****************//
            if (lines.size()>0){
                for (PolyLine line : lines){
                    sb.append(line.toCSV()+"\n");
                }
                if(message==""){
                    message+="Lines";
                }
                else{
                    message+=", Lines";
                }
            }
            //*****************TRIANGLES****************//
            if (triangles.size()>0){
                for (Triangle tri : triangles){
                    sb.append(tri.toCSV()+"\n");
                }
                if(message==""){
                    message+="Triangles";
                }
                else{
                    message+=", Triangles";
                }
            }
            //*****************RECTANGLE****************//
            if (rectangles.size()>0){
                for (Rectangle rect : rectangles){
                    sb.append(rect.toCSV()+"\n");
                }
                if(message==""){
                    message+="Rectangles";
                }
                else{
                    message+=", Rectangles";
                }
            }
            //*****************CIRCLE****************//
            if (circles.size()>0){
                for (Circle circ : circles){
                    sb.append(circ.toCSV()+"\n");
                }
                if(message==""){
                    message+="Circles";
                }
                else{
                    message+=", Circles";
                }
            }
            //*****************POLYGON****************//
            if (polygons.size()>0){
                for (Polygon pol : polygons){
                    sb.append(pol.toCSV()+"\n");
                }
                if(message==""){
                    message+="Polygons";
                }
                else{
                    message+=", Polygons";
                }
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(drawingGUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
        message+=" Saved!";        
        JOptionPane.showMessageDialog(null, message);
    }//GEN-LAST:event_save_bttnMouseClicked

    private void open_bttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_open_bttnMouseClicked
        /**
        * Open a CSV file and draw all the objects found
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         07.12.2016
        * @version          18.01.2017
        */
        Graphics2D g=(Graphics2D)canvas.getGraphics();
        dpoint=false;
        dline=false;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=false;
        edit=false;
        select=false;
        delete=false;
        save=false;
        open=true;
        
        //Creates file chooser
        JFileChooser fileChooser = new JFileChooser("./");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Data", "csv");
	fileChooser.addChoosableFileFilter(filter);											
	fileChooser.setAcceptAllFileFilterUsed(false);	
        fileChooser.setDialogTitle("Import CSV");
        
        //Show file chooser
        int rueckgabeWert = fileChooser.showOpenDialog(null);
        
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
        {
            //Output path of the selected file
            System.out.println("File: " + fileChooser.getSelectedFile().getPath());
            String csv_path=fileChooser.getSelectedFile().getPath();
            open_label.setText(csv_path);
            
            //Restarts the arrays of the objects
            points=new ArrayList<Point>();
            lines=new ArrayList<PolyLine>();
            triangles=new ArrayList<Triangle>();
            rectangles=new ArrayList<Rectangle>();
            circles=new ArrayList<Circle>();
            polygons=new ArrayList<Polygon>();
            
            //redrawing canvas
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            paintall(g);
            
            //Creates buffered reader for reading the csv file
            BufferedReader br=null;
            String csv_line="";
            String csvSplitBy=",";
            
            
            try {
                br=new BufferedReader(new FileReader(csv_path));
                while((csv_line=br.readLine())!=null) {
                    //use coma as separator
                    String element[]=csv_line.split(csvSplitBy);
                    String line_element=element[0];
                    
                    //***************POINTS********************//
                    if(line_element.equals("Point")){
                        int x=Integer.parseInt(element[1]);
                        int y=Integer.parseInt(element[2]);
                        Point point=new Point("Point", Color.GREEN, x, y);
                        points.add(point);
                    }
                    //***************LINES********************//
                    if(line_element.equals("PolyLine")){
                        PolyLine line=new PolyLine("PolyLine", Color.RED);
                        for (int i=1; i<element.length; i++){
                            String coord[]=element[i].split(";");
                            int x=Integer.parseInt(coord[0]);
                            int y=Integer.parseInt(coord[1]);
                            
                            Point point=new Point("Point", Color.GREEN, x, y);
                            line.addPoint(point, g);
                        }
                        lines.add(line);
                    }
                    //***************TRIANGLES********************//
                    if(line_element.equals("Triangle")){
                        Triangle tri=new Triangle("Triangle", Color.MAGENTA);
                        for (int i=1; i<element.length; i++){
                            String coord[]=element[i].split(";");
                            int x=Integer.parseInt(coord[0]);
                            int y=Integer.parseInt(coord[1]);
                            
                            Point point=new Point("Point", Color.GREEN, x, y);
                            tri.addPoint(point, g);
                        }
                        triangles.add(tri);
                    }
                    //***************RECTANGLES********************//
                    if(line_element.equals("Rectangle")){
                        int x1=Integer.parseInt(element[1]);
                        int y1=Integer.parseInt(element[2]);
                        Point point_ini=new Point("Point", Color.GREEN, x1, y1);
                        int x2=Integer.parseInt(element[3]);
                        int y2=Integer.parseInt(element[4]);
                        Point point_end=new Point("Point", Color.GREEN, x2, y2);
                        Rectangle rect=new Rectangle("Rectangle", Color.PINK, point_ini, point_end);
                        rectangles.add(rect);
                    }
                    //***************CIRCLES********************//
                    if(line_element.equals("Circle")){
                        int x=Integer.parseInt(element[1]);
                        int y=Integer.parseInt(element[2]);
                        Point cent=new Point("Point", Color.GREEN, x, y);
                        int x2=Integer.parseInt(element[3]);
                        int y2=Integer.parseInt(element[4]);
                        Point end=new Point("Point", Color.GREEN, x2, y2);
                        Circle circ=new Circle("Circle", Color.ORANGE, cent, end);
                        circles.add(circ);
                    }
                    //***************POLYGONS********************//
                    if(line_element.equals("Polygon")){
                        Polygon pol=new Polygon("Polygon", Color.CYAN);
                        for (int i=1; i<element.length; i++){
                            String coord[]=element[i].split(";");
                            int x=Integer.parseInt(coord[0]);
                            int y=Integer.parseInt(coord[1]);                            
                            Point point=new Point("Point", Color.GREEN, x, y);
                            pol.addPoint(point, g);
                        }
                        polygons.add(pol);
                    }
                }
              paintall(g); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(drawingGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(drawingGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
    }//GEN-LAST:event_open_bttnMouseClicked

    private void three_sidesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_three_sidesMousePressed
        /**
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         10.11.2016
        * @version          18.01.2017
        */
        dpoint=false;
        dline=false;
        dtri3sides=true;
        drectangle=false;
        dCirCentRad=false;
        dpolygon=false;
        edit=false;
        select=false;
        delete=false;
        save=false;
        open=false;
    }//GEN-LAST:event_three_sidesMousePressed

    private void center_radiusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_center_radiusMousePressed
        /**
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         27.12.2016
        * @version          18.01.2017
        */
        dpoint=false;
        dline=false;
        dtri3sides=false;
        drectangle=false;
        dCirCentRad=true;
        dpolygon=false;
        edit=false;
        select=false;
        delete=false;
        save=false;
        open=false;
    }//GEN-LAST:event_center_radiusMousePressed
    
    
    
    //**********************PAINTING METHOD*******************************//
    public void paintall(Graphics g) {
        /**
         * paint all the features
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         11.11.2016
        * @version          18.01.2017
        */
        //********* POINTS *************
        if (points.size()>0){
            for (Point point : points){
                point.draw((Graphics2D) g);
            }
        }
        
        //********* LINES *************
        if (lines.size()>0){
            for (PolyLine line:lines) {
                line.draw((Graphics2D) g);
            };
        }
        if (currentLine.getSize()>0) {
            currentLine.draw((Graphics2D) g);
        }
        
        //********* TRIANGLES *************
        if (triangles.size()>0){
            for (Triangle tri:triangles) {
                tri.draw((Graphics2D) g);
            };
        }
        if (current_tri.getSize()>0) {
            current_tri.draw((Graphics2D) g);
        }
        
        //********* RECTANGLES *************
        if (rectangles.size()>0){
            for (Rectangle rect : rectangles){
                rect.draw((Graphics2D) g);
            }
        }
        
        //********* CIRCLES *************
        if (circles.size()>0){
            for (Circle circ : circles){
                circ.draw((Graphics2D) g);
            }
        }
        
        //********* POLYGONS *************
        if (polygons.size()>0){
            for (Polygon pol:polygons) {
                pol.draw((Graphics2D) g, true);
            };
        }
        if (current_pol.getSize()>0) {
            current_pol.draw((Graphics2D) g, finish);
        }
    }    
    
    //****************************GENERATED CODE**************************
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /**
        * @author           Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
        * creation         21.10.2016
        * @version          18.01.2017
        */
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(drawingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(drawingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(drawingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(drawingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new drawingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel canvas;
    private javax.swing.JMenuItem center_radius;
    private javax.swing.JLabel coordinates_label;
    private javax.swing.JLabel coordinates_title;
    private javax.swing.JMenu delete_bttn;
    private javax.swing.JMenu edit_bttn;
    private javax.swing.JLabel info_label;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu line_bttn;
    private javax.swing.JLabel logo;
    private javax.swing.JMenu open_bttn;
    private javax.swing.JLabel open_label;
    private javax.swing.JMenu point_bttn;
    private javax.swing.JMenuItem poligon;
    private javax.swing.JMenuItem rectangle;
    private javax.swing.JMenu save_bttn;
    private javax.swing.JMenu select_bttn;
    private javax.swing.JMenuItem three_sides;
    // End of variables declaration//GEN-END:variables
}