package autotest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostShoppingListModel extends BaseModel{
    @JsonProperty("name")
    public String name;

    @JsonProperty("primary")
    public Boolean primary;

    public PostShoppingListModel() {
        this.name = "string";
        this.primary = false;
    }

    public PostShoppingListModel(String name, Boolean primary) {
        this.name = name;
        this.primary = primary;
    }
}
