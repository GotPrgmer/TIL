package assignment;

public class RequestConfigBuilder{
    private final Config.ConfigBuilder parentBuilder;
    public String header;
    public String cookie;

    public RequestConfigBuilder header(String header){
        this.header = header;
        return this;
    }
    public RequestConfigBuilder cookie(String cookie){
        this.cookie = cookie;
        return this;
    }
    public Config.ConfigBuilder and(){
        return this.parentBuilder;
    }

    public RequestConfigBuilder(Config.ConfigBuilder cb){
        this.parentBuilder = cb;
    }
    public Config build(){
        return new Config(this);
    }
}
