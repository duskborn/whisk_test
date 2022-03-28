package autotest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

public class SLSuccessResponse extends BaseModel {
    public static class List {
        @JsonProperty("id")
        public String id;
        @JsonProperty("name")
        public String name;
    }

    @JsonProperty("list")
    public List list;

    @JsonProperty("content")
    public JsonObject content;
}
