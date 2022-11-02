package com.stueker.xaeliosapp;

import com.codename1.system.Lifecycle;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import static com.codename1.ui.CN.*;

public class StandardBorderDesignMaster extends Lifecycle {

    public Component sasa;

    @Override
    public void runApp() {
        Form hi = new Form("Sample", new BorderLayout());
        Label labelchen = new Label();
        Container left = new Container(BoxLayout.y()) {
            @Override
            protected Dimension calcPreferredSize() {
                Dimension d = super.calcPreferredSize();
                d.setWidth(getDisplayWidth() / 6);
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
                g.fillRect(getX(), getY(), getWidth(), getHeight());
                // draw hi world in white text at the top left corner of the screen
                g.setColor(0xffffff);
                g.drawString("Hi World", getX(), getY());
            } };



        hi.add(BorderLayout.CENTER, sasa);


        hi.show();    }



    private void hello() {
        Dialog.show("Hello Codename One", "Welcome to Codename One", "OK", null);
    }


}
