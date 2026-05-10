/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

public class sonic
extends MIDlet
implements Runnable {
    private MainCanvas main = new MainCanvas(this);
    public static boolean LoadOK;
    private Display display;

    public void vibrate(int n) {
        try {
            this.display.vibrate(n);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public sonic() {
        Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.main);
        this.display = Display.getDisplay((MIDlet)this);
        new Thread(this).start();
    }

    public void startApp() {
        if (!LoadOK) {
            try {
                LoadOK = true;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public void run() {
        this.main.initAll();
        this.main.GameMain();
    }

    public void pauseApp() {
        MainCanvas.moveRsm = true;
        MainCanvas.drawRsm = true;
    }

    public void destroyApp(boolean bl) {
    }

    public String GetAppProperty(String string) {
        return this.getAppProperty(string);
    }

    public void doExit() {
        try {
            this.destroyApp(false);
            this.notifyDestroyed();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}
