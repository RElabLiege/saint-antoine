package be.relab.projection.controls;
import be.relab.projection.constants.ProjectionConstants;
import be.relab.projection.core.Projection;
import processing.core.*;
import controlP5.*;
import java.awt.Frame;
import java.awt.BorderLayout;

/**
 * Created with IntelliJ IDEA.
 * User: MacBookPro17
 * Date: 29/09/13
 * Time: 14:01
 * To change this template use File | Settings | File Templates.
 */
public class ControlFrame extends PApplet {
    int w, h;
    Projection parent;
    ControlP5 cp5;

    public ControlFrame(Projection _parent, int _w, int _h, String _name) {
        parent = _parent;
        w = _w;
        h = _h;
        Frame f = new Frame(_name);
        f.add(this);
        this.init();
        f.setTitle(_name);
        f.setSize(this.w, this.h);
        f.setLocation(1025,10);
        f.setResizable(false);
        f.setVisible(true);
    }

    public void setup() {
        size(w, h);
        frameRate(25);
        cp5 = new ControlP5(this);
        cp5.addSlider("Sound Threshold").plugTo(parent, "soundThreshold").setRange(0, 15).setValue(2).setPosition(10, 10);
        cp5.addSlider("Part size").plugTo(parent, "partSizeModifier").setRange(0.1f,2).setValue(1).setPosition(10, 30);

        cp5.addSlider("particles X").plugTo(parent, "partX").setRange(0, 578).setValue(289).setPosition(10, 50);
        cp5.addSlider("particles y").plugTo(parent, "partY").setRange(0,1024).setValue(1024).setPosition(10, 70);

        cp5.addSlider("gravity").plugTo(parent, "gravMod").setRange(-200, 200).setValue(0).setPosition(10, 100);
        cp5.addSlider("Wind mod ").plugTo(parent, "windMultiplier").setRange(.001f,1f).setValue(.009f).setPosition(10,130);
        // cp5.addSlider("grid width").plugTo(parent.grid, "width").setRange(-100,100).setValue(0).setPosition(10, 120);

        cp5.addSlider("Rect width").plugTo(parent,"RECT_WIDTH").setRange(95,120).setValue(114).setPosition(170,10).setId(0);
        cp5.addSlider("Rect Height").plugTo(parent,"RECT_HEIGHT").setRange(100,200).setValue(183.83f).setPosition(170,30).setId(0);
        cp5.addSlider("colonne").plugTo(parent,"COLONNE").setRange(0,150).setValue(43).setPosition(170,50).setId(0);
        cp5.addSlider("Margin bottom").plugTo(parent,"MARGIN_BOTTOM").setRange(0,20).setValue(5).setPosition(170,70).setId(0);
        cp5.addSlider("Margin Left").plugTo(parent,"MARGIN_LEFT").setRange(-100,100).setValue(39.39f).setPosition(170,90).setId(0);
        cp5.addSlider("Position Y").plugTo(parent,"VIT_POS_Y").setRange(-300,300).setValue(-130.30f).setPosition(170,110).setId(0);
        cp5.addSlider("Part. Life").plugTo(parent,"partLifeMod").setRange(0,1500).setValue(300).setPosition(170,130);
        cp5.addSlider("Sound bang").plugTo(parent,"bang").setRange(5,35).setValue(10).setPosition(170,150);

        // cp5.addButton("Update positions").plugTo(parent,"updatePositions").setPosition(10,150);

        cp5.addToggle("displayMess").plugTo(parent).setValue(true).setPosition(10,height-70);
        cp5.addToggle("displayParts").plugTo(parent).setValue(false).setPosition(90,height-70);
        cp5.addToggle("animateWords").plugTo(parent).setValue(true).setPosition(10,height-140);
        cp5.addToggle("animateLetters").plugTo(parent).setValue(true).setPosition(90,height-140);
        cp5.addToggle("flip").plugTo(parent).setValue(true).setPosition(90,height-170);




        cp5.loadProperties(("vitrail.properties"));

  /*
    cp5.addRadioButton("drawingType").plugTo(parent, "drawingType").setPosition(10,100)
       .addItem("H lines", 1).addItem("V Lines",2).addItem("Triangles",3).activate(0);
    // cp5.addButton("export").plugTo(parent,"initExport").setPosition(10,150);
    // cp5.addSlider("Epaisseur").plugTo(parent, "weight").setRange(1, 5).setPosition(10, 110);
    */

    }


    public void keyPressed() {
        // default properties load/save key combinations are
        // alt+shift+l to load properties
        // alt+shift+s to save properties
        if (key=='s') {
            cp5.saveProperties(("vitrail.properties"));
        }
        else if (key=='l') {
            cp5.loadProperties(("vitrail.properties"));
        }
    }
    public void draw() {
    }
    public ControlP5 control() {
        return cp5;
    }
    private ControlFrame() {
    }
}

