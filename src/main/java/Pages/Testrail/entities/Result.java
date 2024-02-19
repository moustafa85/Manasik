package Pages.Testrail.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result {

    private int id;
    private int caseId;
    private int testId;
    private int statusId;
    private String comment;
    private String elapsed;
    private Screenshot screenshot;


}
