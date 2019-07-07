package mypackage;

import javax.microedition.global.Formatter;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.FullScreen;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;

public class PointsScreen extends MainScreen implements FieldChangeListener {

	/**
	 * 
	 */
	
	private Bitmap backgroundBitmap;
	VerticalFieldManager verticalManager;
	RichTextField rtfHeading;
	Font fontHeading = null;
	private EditField x1Edit;
	private EditField y1Edit;
	private EditField x2Edit;
	private EditField y2Edit;
	private LabelField x1Label;
	private LabelField y1Label;
	private LabelField x2Label;
	private LabelField y2Label;
	ButtonField calculateButton;
	ButtonField backButton;
	Border roundedBorder;
	
	
	public PointsScreen() {
		

		

		super(MainScreen.NO_HORIZONTAL_SCROLL | MainScreen.USE_ALL_WIDTH | MainScreen.USE_ALL_HEIGHT | MainScreen.NO_VERTICAL_SCROLL);
        setTitle( "Points 2 Lines" );
        roundedBorder = BorderFactory.createRoundedBorder(new XYEdges(10,10,10,10), Color.WHITE, Border.STYLE_FILLED);
        
        backgroundBitmap = Bitmap.getBitmapResource("background.jpg");
        verticalManager  = new VerticalFieldManager(VerticalFieldManager.USE_ALL_WIDTH | VerticalFieldManager.USE_ALL_HEIGHT){
        	 public void paint(Graphics graphics)
             {
                 //Draw the background image and then call paint.
                 graphics.drawBitmap(0, 0, Display.getWidth(),Display.getHeight(), backgroundBitmap, 0, 0);
                 super.paint(graphics);
             }
        };
        
        rtfHeading = new RichTextField("Points Calculation", RichTextField.TEXT_ALIGN_HCENTER){
        	protected void paint(Graphics g){ 
                g.setColor(0xffffffff);
                super.paint(g);
            }
        };
        rtfHeading.setMargin(20, 50, 20, 50);
        fontHeading = getFontToDisplay("Times New Roman", 55);
        rtfHeading.setFont(fontHeading);
        verticalManager.add(rtfHeading);
        
        x1Edit = new EditField("","",10, TextField.NO_LEARNING | TextField.NO_NEWLINE | TextField.NON_SPELLCHECKABLE ){
            protected void paint(Graphics graphics) {
                graphics.clear();
                graphics.setBackgroundColor( Color.WHITE );
         
                super.paint(graphics);
              }
            };
            x1Edit.setBorder(roundedBorder);
            x1Edit.setMargin(10,10,20,10);
	    x1Label = new LabelField( "Point A - (X1) : " ){
            public void paint(Graphics g ){
                g.setColor(Color.WHITE);
                super.paint(g);
              }
            };
            x1Label.setFont( Font.getDefault().derive(Font.EMBOSSED_EFFECT,25,Ui.UNITS_px) );   
		verticalManager.add(x1Label);
		verticalManager.add(x1Edit);
		
		y1Edit = new EditField("","",10, TextField.NO_LEARNING | TextField.NO_NEWLINE | TextField.NON_SPELLCHECKABLE ){
            protected void paint(Graphics graphics) {
                graphics.clear();
                graphics.setBackgroundColor( Color.WHITE );
         
                super.paint(graphics);
              }
            };
            y1Edit.setBorder(roundedBorder);
            y1Edit.setMargin(10,10,20,10);
	    y1Label = new LabelField( "Point A - (Y1) : " ){
            public void paint(Graphics g ){
                g.setColor(Color.WHITE);
                super.paint(g);
              }
            };
            y1Label.setFont( Font.getDefault().derive(Font.EMBOSSED_EFFECT,25,Ui.UNITS_px) );   
		verticalManager.add(y1Label);
		verticalManager.add(y1Edit);
		
		x2Edit = new EditField("","",10, TextField.NO_LEARNING | TextField.NO_NEWLINE | TextField.NON_SPELLCHECKABLE ){
            protected void paint(Graphics graphics) {
                graphics.clear();
                graphics.setBackgroundColor( Color.WHITE );
         
                super.paint(graphics);
              }
            };
            x2Edit.setBorder(roundedBorder);
            x2Edit.setMargin(10,10,20,10);
	    x2Label = new LabelField( "Point B - (X2) : " ){
            public void paint(Graphics g ){
                g.setColor(Color.WHITE);
                super.paint(g);
              }
            };
            x2Label.setFont( Font.getDefault().derive(Font.EMBOSSED_EFFECT,25,Ui.UNITS_px) );   
		verticalManager.add(x2Label);
		verticalManager.add(x2Edit);
		
		
		y2Edit = new EditField("","",10, TextField.NO_LEARNING | TextField.NO_NEWLINE | TextField.NON_SPELLCHECKABLE ){
            protected void paint(Graphics graphics) {
                graphics.clear();
                graphics.setBackgroundColor( Color.WHITE );
         
                super.paint(graphics);
              }
            };
            y2Edit.setBorder(roundedBorder);
            y2Edit.setMargin(10,10,20,10);
	    y2Label = new LabelField( "Point B - (Y2) : " ){
            public void paint(Graphics g ){
                g.setColor(Color.WHITE);
                super.paint(g);
              }
            };
            y2Label.setFont( Font.getDefault().derive(Font.EMBOSSED_EFFECT,25,Ui.UNITS_px) );   
		verticalManager.add(y2Label);
		verticalManager.add(y2Edit);
		
		
		
	        fontHeading = getFontToDisplay("Comic Sans MS", 30);
	        calculateButton = new ButtonField( "Calculate", ButtonField.CONSUME_CLICK | FIELD_HCENTER );
	        calculateButton.setChangeListener(this);
	        calculateButton.setFont(fontHeading);
	        calculateButton.setMargin(35, 40, 0, 80);
	        
	        backButton = new ButtonField( "Back", ButtonField.CONSUME_CLICK | FIELD_HCENTER );
	        backButton.setChangeListener(this);
	        backButton.setFont(fontHeading);
	        backButton.setMargin(35, 40, 0, 80);
	        
	        
	        
	        HorizontalFieldManager horizontalManager = new HorizontalFieldManager(USE_ALL_WIDTH);
	        horizontalManager.add(calculateButton);
	        horizontalManager.add(backButton);
		verticalManager.add(horizontalManager);
		add(verticalManager);
	
		
		
	
		
	}
	
	
	public void fieldChanged(Field field, int context) {

		double x1 = 0;
		double y1 = 0;
		double x2 = 0;
		double y2 = 0;
		
		double distance = 0;
		double slope = 0;
		double yintercept = 0;
		
		StringBuffer stResult = new StringBuffer();
		Formatter format = new Formatter();

		if(field == calculateButton)
		{
			if(calculateButton.getLabel().equals("Calculate"))
			{
				calculateButton.setLabel("Reset");
				x1Edit.setEditable(false);
				y1Edit.setEditable(false);
				x2Edit.setEditable(false);
				y2Edit.setEditable(false);

				try {
					x1 = Double.parseDouble(x1Edit.getText());
					y1 = Double.parseDouble(y1Edit.getText());
					x2 = Double.parseDouble(x2Edit.getText());
					y2 = Double.parseDouble(y2Edit.getText());

					distance = Math.sqrt(((x1-x2) * (x1-x2)) + ((y1-y2) * (y1-y2)));
					stResult.append("(X1,Y1) - (" + format.formatNumber(x1,3) + "," + format.formatNumber(y1,3) + ")\n\n");
					stResult.append("(X2,Y2) - (" + format.formatNumber(x2,3) + "," + format.formatNumber(y2,3) + ")\n\n");
					stResult.append("Mid - Point (X,Y) : (" + format.formatNumber(((x1 + x2) / 2 ),3) + "," + format.formatNumber(((y1 + y2) / 2 ),3) + ")\n\n");
					stResult.append("Distance : " + format.formatNumber(distance, 3) + "\n\n");
					if(x1 == x2)
					{
						stResult.append("Equation of the Line formed by the Points (X = constant) : X = " + format.formatNumber(x1, 3) + "\n\n");
						stResult.append("Slope of the Line (m) : \u221E");
					}
					else
					{
						slope = (y2 - y1) / (x2 - x1);
						yintercept = y2 - (slope * x2);
						
						stResult.append("Equation of the Line formed by the Points (Y = mX + c) :\n Y = " + format.formatNumber(slope,3) + " X + ( " + format.formatNumber(yintercept,3) + ")\n\n");
						stResult.append("Slope of the Line (m) : " + format.formatNumber(slope,3));
					}
					
					IntermediateScreen.setStResultData(stResult.toString());
					IntermediateScreen.setStResultHeading("Points Calculation");
					UiApplication.getUiApplication().pushScreen(new ResultScreen());
					stResult = null;
				} catch (NumberFormatException e) {
					
					Dialog.inform("Please Enter Number!!!!");
					
				}
				catch (ArithmeticException e) {
					
						Dialog.inform("Error!!!! Please try after some time");
						UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());

				}
				catch (Exception e) {

					Dialog.inform("Error!!!! Please try after some time");
					UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());

				}
				
			}
			else
			{
				calculateButton.setLabel("Calculate");
				x1Edit.setText("");
				y1Edit.setText("");
				x2Edit.setText("");
				y2Edit.setText("");
				x1Edit.setEditable(true);
				y1Edit.setEditable(true);
				x2Edit.setEditable(true);
				y2Edit.setEditable(true);
				stResult = null;
			}
		}
		else if(field == backButton)
		{
			UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());
		}
		
	}
	
	private Font getFontToDisplay(String stFontName, int fontSize)
    {
    	try
        {
            FontFamily ff1 = FontFamily.forName(stFontName);
            fontHeading = ff1.getFont(Font.ITALIC | Font.EXTRA_BOLD , fontSize);
            return fontHeading;
        }
        catch (Exception e) {
			e.printStackTrace();
			Dialog.inform("Error Occurred. Please try after some time");
			return null;
		}
    }
    
    protected boolean onSavePrompt() {
        return true;
    }

}
