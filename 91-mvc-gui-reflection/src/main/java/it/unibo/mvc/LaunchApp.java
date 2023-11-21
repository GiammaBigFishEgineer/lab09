package it.unibo.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import it.unibo.mvc.api.DrawNumber;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws SecurityException
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        final var model = new DrawNumberImpl();
        final DrawNumberControllerImpl controller = new DrawNumberControllerImpl(model);
        for(final var i: List.of("OnlyOutput", "Swing")){
            Class<?> aClass = Class.forName("it.unibo.mvc.view.DrawNumber" + i + "View");
            if(i.equals("Swing")){
                for (int k = 0; k < 3; k++){
                    initUI(controller,aClass);
                }
            }else{
                initUI(controller,aClass);
            }
            
        }
    }

    private static void initUI(final DrawNumberController controller, final Class<?> toInstance) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        final var newView = toInstance.getConstructor().newInstance();
        if (DrawNumberView.class.isAssignableFrom(newView.getClass())){
            controller.addView((DrawNumberView) newView);
        } else {
            throw new IllegalStateException(toInstance + " is not a sub Object or same object");
        }
    }
}
