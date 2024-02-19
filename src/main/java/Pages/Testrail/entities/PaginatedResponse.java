package Pages.Testrail.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PaginatedResponse {

    private int offset;
    private int limit;
    private int size;
    private PaginationLinks _links;

    private ArrayList<Section> sections;
    private ArrayList<Case> cases;
    private ArrayList<Test> tests;
    private ArrayList<Result> results;
}
