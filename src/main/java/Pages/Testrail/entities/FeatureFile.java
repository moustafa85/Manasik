package Pages.Testrail.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class FeatureFile {
    private int sectionId;
    private String name;
    // tags and file header
    private String description;
    private ArrayList<FeatureFileScenario> scenarios;

    public FeatureFile(int id, String name, String description) {
        this.sectionId = id;
        this.name = name;
        this.description = description;
        scenarios = new ArrayList<>();
    }


    @Override
    public String toString() {
        String text = "@testrail " + description + "\n";

        for (FeatureFileScenario scenario : scenarios) {
            text += "\n";
            if (scenario.getPreconds() != null)
                text += scenario.getPreconds() + "\n";
            text += scenario.getIdString() + "\n";
            text += scenario.getTitle() + "\n";
            text += scenario.getSteps() + "\n";
            text = text.replace("\u00a0", "");
        }
        return text;
    }
}
