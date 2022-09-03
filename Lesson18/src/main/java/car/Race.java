package car;

import car.obstacles.Stage.Stage;

import java.util.Arrays;
import java.util.Vector;

public class Race {
    private Vector<Stage> stages;

    public Vector<Stage> getStages(){
        return stages;
    }

    public Race(Stage... stages){
        this.stages = new Vector<>(Arrays.asList(stages));
    }
}
