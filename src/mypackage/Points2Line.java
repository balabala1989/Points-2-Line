package mypackage;

import net.rim.device.api.ui.UiApplication;

/**
 * This class extends the UiApplication class, providing a graphical user interface.
 */
public class Points2Line extends UiApplication {
    /**
     * Entry point for application
     * 
     * @param args
     *            Command line arguments (not used)
     */
    public static void main( String[] args ) {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        Points2Line theApp = new Points2Line();
        theApp.enterEventDispatcher();
    }

    /**
     * Creates a new Points2Line object
     */
    public Points2Line() {
        // Push a screen onto the UI stack for rendering.
        pushScreen( new Points2LineScreen() );
    }
}
