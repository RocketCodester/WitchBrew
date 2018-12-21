
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.*;
import org.lgna.common.EachInTogetherRunnable;
import static org.lgna.common.ThreadUtilities.doTogether;
import static org.lgna.common.ThreadUtilities.eachInTogether;

public class Scene extends SScene {

    public Scene() {
        super();
    }

    private void performCustomSetup() {
    }

    private void performGeneratedSetUp() {
        this.setAtmosphereColor(new Color(0.588, 0.886, 0.988));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        ground.setPaint(SGround.SurfaceAppearance.GRASS);
        ground.setOpacity(1.0);
        ground.setName("ground");
        ground.setVehicle(this);
        camera.setName("camera");
        camera.setVehicle(this);
        camera.setOrientationRelativeToVehicle(new Orientation(0.0, 0.995646, 0.0932105, 6.12323E-17));
        camera.setPositionRelativeToVehicle(new Position(9.61E-16, 2.0, -7.25));
        witch.setPaint(Color.WHITE);
        witch.setOpacity(1.0);
        witch.setName("witch");
        witch.setVehicle(this);
        witch.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        witch.setPositionRelativeToVehicle(new Position(1.07, 0.0, 1.39));
        witch.setSize(new Size(0.737, 1.49, 1.25));
        cauldron.setPaint(Color.WHITE);
        cauldron.setOpacity(1.0);
        cauldron.setName("cauldron");
        cauldron.setVehicle(this);
        cauldron.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        cauldron.setPositionRelativeToVehicle(new Position(-0.829, 0.0, 1.39));
        cauldron.setSize(new Size(1.79, 1.29, 1.8));
    }

    private void initializeEventListeners() {
        this.addSceneActivationListener(new SceneActivationListener() {
            public void sceneActivated(final SceneActivationEvent e) {
                Scene.this.myFirstMethod();
            }
        });
    }

    protected void handleActiveChanged(final Boolean isActive, final Integer activationCount) {
        if (isActive) {
            if (activationCount == 1) {
                this.performGeneratedSetUp();
                this.performCustomSetup();
                this.initializeEventListeners();
            } else {
                this.restoreStateAndEventListeners();
            }
        } else {
            this.preserveStateAndEventListeners();
        }
    }

    public void myFirstMethod() {
        double witchDepth = witch.getDepth();
        double cauldronDepth = cauldron.getDepth();
        double personalSpace = (witchDepth * 0.5)+ (cauldronDepth * 0.5);
        witch.say("I need to check on my brew.");
        witch.turnToFace(cauldron);
        witch.moveToward(cauldron, witch.getDistanceTo(cauldron)-personalSpace);
    }

    public SGround getGround() {
        return ground;
    }

    public SCamera getCamera() {
        return camera;
    }

    public Witch getWitch() {
        return witch;
    }

    public Cauldron getCauldron() {
        return cauldron;
    }
    private final SGround ground = new SGround();
    private final SCamera camera = new SCamera();
    private final Witch witch = new Witch();
    private final Cauldron cauldron = new Cauldron();
}
