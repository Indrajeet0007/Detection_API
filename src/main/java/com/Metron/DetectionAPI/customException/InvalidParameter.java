package com.Metron.DetectionAPI.customException;

public class InvalidParameter extends  RuntimeException{
    private String message;
    public InvalidParameter (String message){
        super(message);
        this.message= message;
    }
public InvalidParameter(){

}
    @Override
    public String getMessage() {
        return message;
    }
}
