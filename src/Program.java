
import org.lgna.story.*;
import org.lgna.common.EachInTogetherRunnable;
import static org.lgna.common.ThreadUtilities.doTogether;
import static org.lgna.common.ThreadUtilities.eachInTogether;

public class Program extends SProgram {

    public Program() {
        super();
    }

    public static void main(final String[] args) {
        final Program story = new Program();
        story.initializeInFrame(args);
        story.setActiveScene(story.getMyScene());
    }

    public Scene getMyScene() {
        return this.myScene;
    }
    private final Scene myScene = new Scene();
}
