/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ee;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/greet")
public class App extends Application{
    public String getGreeting() {
        return "Hello world.";
    }

}
