package ambaltextiles;

/**
 *
 * @author Sridhar
 */
public class AmbalTextiles {

    public static void main(String[] args) {

        // SplashScreen
        Login log;
        SplashScreen screen = new SplashScreen();
        screen.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(50);
                screen.loadingNumber.setText(Integer.toString(i) + " %");
                screen.loadingBar.setValue(i);
            }
            screen.setVisible(false);
            log = new Login();
            log.setVisible(true);
        } catch (Exception e) {
            // don't do anything
        }

    }

}
