package autotest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSLErrorResponse extends BaseModel {

    @JsonProperty("code")
    public String code;

    @JsonProperty("error_code")
    public String errorCode;

    @JsonProperty("message")
    public String message;
}
