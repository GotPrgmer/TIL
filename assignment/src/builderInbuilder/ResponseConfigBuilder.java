package assignment.src.builderInbuilder;

public class ResponseConfigBuilder{
    private final Config.ConfigBuilder parentBuilder;
    public String body;
    public String type;

    public ResponseConfigBuilder body(String header){
        this.body = body;
        return this;
    }
    public ResponseConfigBuilder type(String cookie){
        this.type = type;
        return this;
    }
    public Config.ConfigBuilder and(){
        return parentBuilder;
    }
    public ResponseConfigBuilder(Config.ConfigBuilder cb){
        this.parentBuilder = cb;
    }


}
