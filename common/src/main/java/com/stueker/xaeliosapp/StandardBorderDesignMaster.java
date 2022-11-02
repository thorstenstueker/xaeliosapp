package com.stueker.xaeliosapp;

import com.codename1.system.Lifecycle;
import com.codename1.ui.*;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.Paint;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import java.awt.*;

import static com.codename1.ui.CN.*;

public class StandardBorderDesignMaster extends Lifecycle {
public Stroke stroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
public Form hi;
public Label labelchen;
    protected Component sasa;
    private Object g;

    @Override
    public void runApp() {
        hi = new Form("Sample", new BorderLayout());
        labelchen = new Label();
        Container left = new Container(BoxLayout.y()) {
            @Override
            protected Dimension calcPreferredSize() {
                Dimension d = super.calcPreferredSize();
                d.setWidth(getDisplayWidth() / 5);
                return d;
            }
        };
        Container right = new Container(BoxLayout.y()) {
            @Override
            protected Dimension calcPreferredSize() {
                Dimension d = super.calcPreferredSize();
                d.setWidth(getDisplayWidth() / 6);
                return d;
            }
        };
        Button alter = new Button("Alter");
        alter.addActionListener(e->{hello();});
        Button dalter = new Button("Dark Alter");
        BoxLayout boxlayer = new BoxLayout(BoxLayout.Y_AXIS);
        //boxlayer.setAlign(Component.BRB_CENTER_OFFSET);

        Container northtainer = new Container(FlowLayout.encloseCenterMiddle().getLayout());
        northtainer.add(alter);
        northtainer.add(dalter);

        hi.add(NORTH,northtainer);
        left.setScrollableY(true);
        Button leftone = new Button("Left" );
        left.add(leftone);
        TextField nameone = new TextField();
        left.add(nameone);
        TextArea textone = new TextArea("LoremIpsum and Ipsum Loren LoremIpsum and Ipsum Loren LoremIpsum and Ipsum Loren LoremIpsum and Ipsum Loren LoremIpsum and Ipsum Loren LoremIpsum and Ipsum Loren ");

        left.add(textone);
        right.setScrollableY(true);
        Button rightone = new Button("Right" );
        right.add(rightone);
        ComboBox box = new ComboBox<String>();
        box.addItem("One");
        box.addItem("Two");
        right.add(box);
        hi.add(EAST,right);
        hi.add(WEST, left);
        hi.add(SOUTH, BoxLayout.encloseX(new Button("Button 1"), new Button("Button 2")));

        sasa = new Component(){
            @Override
            public void paint(Graphics g) {
                // red color
                g.setColor(0xff0000);
                // paint the screen in red

                // draw hi world in white text at the top left corner of the screen


                // paint the screen in red

int maxX = g.getClipX() + g.getClipWidth();
                System.out.println("maxX: " + maxX);
                int maxY = g.getClipY() + g.getClipHeight();
                System.out.println("maxY: " + maxY);
              //g.translate(-currX, -currY);
g.drawLine(getX(),getY(),maxX,maxY);
                System.out.println("Window Height"+g.getClipHeight());


// Reset the translation to zeroes


                g.drawString("Hi World", getX(), getY());
                g.drawString("Hld", getX(), getY());
                g.drawString("Hld", 0,0);
            } };

        hi.add(BorderLayout.CENTER, sasa);


        hi.show();
        System.out.println(sasa.getAbsoluteY());
    }



    private void hello() {
        hi.repaint();
        sasa = new Component(){
            @Override
            public void paint(Graphics g) {
                // red color
                g.setColor(0x000000);
                // paint the screen in red

                // draw hi world in white text at the top left corner of the screen


                // paint the screen in red

                int maxX = g.getClipX() + g.getClipWidth();
                System.out.println("maxX: " + maxX);
                int maxY = g.getClipY() + g.getClipHeight();
                System.out.println("maxY: " + maxY);
                //g.translate(-currX, -currY);
                g.drawLine(getX(),getY(),maxX,maxY);
                System.out.println("Window Height"+g.getClipHeight());


// Reset the translation to zeroes


                g.drawString("Hi World", getX(), getY());
                g.drawString("Hld", getX(), getY());
                g.drawString("Hld", 0,0);
                ;

            } };

        hi.add(BorderLayout.CENTER, sasa);
        System.out.println("added new");
        labelchen.setText("hälloooh");
        hi.setTitle("Hallöchen Jannöschen");

      //Dialog.show("Hello Codename One", "Welcome to Codename One", "OK", null);
    }


}
