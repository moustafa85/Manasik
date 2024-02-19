package Pages.Testrail.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeatureFileScenario {

    private int id;
    private String title;
    private String preconds;
    private String steps;
    private String idString;

    public FeatureFileScenario(int id, String title, String preconds, String custom_steps) {
        this.id = id;
        this.title = title;
        this.preconds = preconds;
        this.steps = custom_steps;
        this.idString = "@C" + id;
    }


}
