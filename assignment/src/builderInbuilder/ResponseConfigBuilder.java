package assignment.src.builderInbuilder;

public class ResponseConfigBuilder{
    private final Config.ConfigBuilder parentBuilder;
    public String body;
    public String type;

    public ResponseConfigBuilder body(String body){
        this.body = body;
        return this;
    }
    public ResponseConfigBuilder body(){
        this.body = null;
        return this;
    }
    public ResponseConfigBuilder type(String type){
        this.type = type;
        return this;
    }
    public ResponseConfigBuilder type(){
        this.type = null;
        return this;
    }
    public Config.ConfigBuilder and(){
        return parentBuilder;
    }
    public ResponseConfigBuilder(Config.ConfigBuilder cb){
        this.parentBuilder = cb;
    }
    public Config build() {
        return parentBuilder.build();
    }

}
