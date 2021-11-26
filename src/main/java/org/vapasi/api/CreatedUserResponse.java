package org.vapasi.api;

public class CreatedUserResponse {
    private int code;
    private String type;
    private String message;
    public int getCode()
    {
        return code;
    }
    public String getType()
    {
        return type;
    }
    public String getMessage()
    {
        return message;
    }
    public void setCode(int code)
    {
        this.code = code;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public void setType(String type)
    {
        this.type = type;
    }
}
