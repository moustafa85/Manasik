package Pages.Testrail.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Case {

    private int id;
    private String title;
    private int section_id;
    private String custom_preconds;
    private String custom_steps;


}
