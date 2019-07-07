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

public class LineScreen extends MainScreen implements FieldChangeListener {

	/**
	 * 
	 */
	
	private Bitmap backgroundBitmap;
	VerticalFieldManager verticalManager;
	RichTextField rtfHeading;
	RichTextField rtfSubHeading;
	Font fontHeading = null;
	Font fontSubHeading = null;
	private EditField aEdit;
	private EditField bEdit;
	private EditField cEdit;
	private LabelField aLabel;
	private LabelField bLabel;
	private LabelField cLabel;
	ButtonField calculateButton;
	ButtonField backButton;
	Border roundedBorder;
	
	
	public LineScreen() {
		

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
        
        rtfHeading = new RichTextField("Lines Calculation", RichTextField.TEXT_ALIGN_HCENTER){
        	protected void paint(Graphics g){ 
                g.setColor(0xffffffff);
                super.paint(g);
            }
        };
        rtfHeading.setMargin(20, 50, 20, 50);
        fontHeading = getFontToDisplay("Times New Roman", 55);
        rtfHeading.setFont(fontHeading);
        verticalManager.add(rtfHeading);
        
        rtfSubHeading = new RichTextField("Line Equation : aX + bY = c", RichTextField.TEXT_ALIGN_HCENTER){
        	protected void paint(Graphics g){ 
                g.setColor(0xffffffff);
                super.paint(g);
            }
        };
        rtfSubHeading.setMargin(50, 80, 50, 80);
        fontSubHeading = getFontToDisplay("Times New Roman", 25);
        rtfHeading.setFont(fontSubHeading);
        verticalManager.add(rtfSubHeading);
        
        aEdit = new EditField("","",10, TextField.NO_LEARNING | TextField.NO_NEWLINE | TextField.NON_SPELLCHECKABLE ){
            protected void paint(Graphics graphics) {
                graphics.clear();
                graphics.setBackgroundColor( Color.WHITE );
         
                super.paint(graphics);
              }
            };
            aEdit.setBorder(roundedBorder);
            aEdit.setMargin(20,20,30,20);
	    aLabel = new LabelField( "Value of 'a' : " ){
            public void paint(Graphics g ){
                g.setColor(Color.WHITE);
                super.paint(g);
              }
            };
            aLabel.setFont( Font.getDefault().derive(Font.EMBOSSED_EFFECT,25,Ui.UNITS_px) );   
		verticalManager.add(aLabel);
		verticalManager.add(aEdit);
		
		bEdit = new EditField("","",10, TextField.NO_LEARNING | TextField.NO_NEWLINE | TextField.NON_SPELLCHECKABLE ){
            protected void paint(Graphics graphics) {
                graphics.clear();
                graphics.setBackgroundColor( Color.WHITE );
         
                super.paint(graphics);
              }
            };
            bEdit.setBorder(roundedBorder);
            bEdit.setMargin(20,20,30,20);
	    bLabel = new LabelField( "Value of 'b' : " ){
            public void paint(Graphics g ){
                g.setColor(Color.WHITE);
                super.paint(g);
              }
            };
            bLabel.setFont( Font.getDefault().derive(Font.EMBOSSED_EFFECT,25,Ui.UNITS_px) );   
		verticalManager.add(bLabel);
		verticalManager.add(bEdit);
		
		cEdit = new EditField("","",10, TextField.NO_LEARNING | TextField.NO_NEWLINE | TextField.NON_SPELLCHECKABLE ){
            protected void paint(Graphics graphics) {
                graphics.clear();
                graphics.setBackgroundColor( Color.WHITE );
         
                super.paint(graphics);
              }
            };
            cEdit.setBorder(roundedBorder);
            cEdit.setMargin(20,20,30,20);
	    cLabel = new LabelField( "Value of 'c' : " ){
            public void paint(Graphics g ){
                g.setColor(Color.WHITE);
                super.paint(g);
              }
            };
            cLabel.setFont( Font.getDefault().derive(Font.EMBOSSED_EFFECT,25,Ui.UNITS_px) );   
		verticalManager.add(cLabel);
		verticalManager.add(cEdit);
		
		
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

		double a = 0;
		double b = 0;
		double c = 0;
		
		String xintercept = "";
		String slope = "";
		String yintercept = "";
		
		double slop = 0;
		double xinter = 0;
		double yinter = 0;
		
		StringBuffer stResult = new StringBuffer();
		Formatter format = new Formatter();

		if(field == calculateButton)
		{
			if(calculateButton.getLabel().equals("Calculate"))
			{
				calculateButton.setLabel("Reset");
				aEdit.setEditable(false);
				bEdit.setEditable(false);
				cEdit.setEditable(false);

				try {
					a = Double.parseDouble(aEdit.getText());
					b = Double.parseDouble(bEdit.getText());
					c = Double.parseDouble(cEdit.getText());

					if(a == 0 && b == 0)
					{
						Dialog.inform("Value of 'a' and 'b' cannot be zero");
					}
					else
					{
						if(a == 0)
						{
							slope = "0";
							xintercept = "none";
							yinter = c / b ;
							yintercept = format.formatNumber(yinter, 3);
						}
						else if(b == 0)
						{
							slope = "\u221E";
							yintercept = "none";
							xinter = c / a;
							xintercept = format.formatNumber(xinter, 3);
						}
						else
						{
							slop = (-a) / b;
							yinter = c / b;
							xinter = c / a;
							
							slope = format.formatNumber(slop, 3);
							xintercept = format.formatNumber(xinter, 3);
							yintercept = format.formatNumber(yinter, 3);
						}
						
						stResult.append("Equation of the line : \n" + format.formatNumber(a,3) + "X + (" + format.formatNumber(b,3) + ") Y = " + format.formatNumber(c,3) + "\n\n");
						stResult.append("Slope : \n" + slope + "\n\n");
						stResult.append("X - intercept (X,0) : \n (" + xintercept + ", 0)\n\n");
						stResult.append("Y - intercept (0,Y) : \n (0, " + yintercept + ")\n\n");
						
						IntermediateScreen.setStResultData(stResult.toString());
						IntermediateScreen.setStResultHeading("Line Calculation");
						UiApplication.getUiApplication().pushScreen(new ResultScreen());
						stResult = null;
					}
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
				aEdit.setText("");
				bEdit.setText("");
				cEdit.setText("");
				aEdit.setEditable(true);
				bEdit.setEditable(true);
				cEdit.setEditable(true);
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
