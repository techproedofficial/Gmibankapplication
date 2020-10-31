package gmibank.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllApplicants {


    public NewApplicant[] getList() {
        return list;
    }

    public void setList(NewApplicant[] list) {
        this.list = list;
    }

    private NewApplicant[] list;


}
