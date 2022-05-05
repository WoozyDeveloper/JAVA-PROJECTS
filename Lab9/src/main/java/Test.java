import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;


public class Test {
    private boolean repainted = false;

    public Test() {
        Frame frame = new Frame("Testing");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.add(new ImageCanvas());
        frame.pack();
        frame.setVisible(true);
    }

    public class ImageCanvas extends Canvas {

        private BufferedImage img;

        public ImageCanvas() {
            try {
                img = ImageIO.read(new File("src/main/resources/map2.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(img.getWidth(), img.getHeight()) : new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (img != null) {
                g.setColor(Color.YELLOW);
                g.fillOval(600,600,5,5);
                g.drawOval(600,600,5,5);

                g.drawImage(img, 0, 0, this);

                int lineNumber = 0;
                File file = new File("src/main/resources/concap.csv");
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    for (String line; (line = br.readLine()) != null; ) {
                        if (lineNumber == 0) {
                            lineNumber++;
                            continue;
                        }
                        String[] myString = line.split(",");

                        double lat = Float.parseFloat(myString[2]);
                        double lon = Float.parseFloat(myString[3]);
                        g.setColor(Color.RED);

                        int mapWidth = 1024;
                        int mapHeight = 1024;

                        double mapLonLeft = -180;
                        double mapLonRight = 180;
                        double mapLonDelta = mapLonRight - mapLonLeft;

                        double mapLatBottom = -85.05112878;
                        double mapLatBottomDegree = mapLatBottom * Math.PI / 180;
                        double worldMapWidth = ((mapWidth / mapLonDelta) * 360) / (2 * Math.PI);
                        double mapOffsetY = (worldMapWidth / 2 * Math.log((1 + Math.sin(mapLatBottomDegree)) / (1 - Math.sin(mapLatBottomDegree))));

                        double x = (lon - mapLonLeft) * (mapWidth / mapLonDelta) - 5;
                        double y = 0.1;
                        if (lat < 0) {
                            lat = lat * Math.PI / 180;
                            y = mapHeight - ((worldMapWidth / 2 * Math.log((1 + Math.sin(lat)) / (1 - Math.sin(lat)))) - mapOffsetY);
                        } else if (lat > 0) {
                            lat = lat * Math.PI / 180;
                            lat = lat * -1;
                            y = mapHeight - ((worldMapWidth / 2 * Math.log((1 + Math.sin(lat)) / (1 - Math.sin(lat)))) - mapOffsetY);
                            //System.out.println("y before minus: " + y);
                            y = mapHeight - y;
                        } else {
                            y = mapHeight / 2;
                        }


//                        double x = (longitude + 180) * (mapWidth/360);
//                        double latRad = latitude * Math.PI / 180;
//                        double mercN = Math.log(Math.tan((Math.PI/4)+(latRad/2)));
//                        double y = (mapHeight/2) - (mapWidth*mercN / (2*Math.PI));

//                        double x = (mapWidth * (180 + longitude) / 360) % mapWidth;
//                        double y = (mapHeight * (180 + latitude) / 360) % mapHeight;

                        g.fillOval((int)x,(int)y,5,5);
                        g.drawOval((int)x,(int)y,5,5);


                        //System.out.print(countryName + capitalName + "\n");
                    }
                    // line is not visible here.
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(repainted == false)
                repaint();
            repainted = true;

        }

    }

}