package autotest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingListModel extends BaseModel{
    @JsonProperty("name")
    public String name;

    @JsonProperty("primary")
    public Boolean primary;
}
