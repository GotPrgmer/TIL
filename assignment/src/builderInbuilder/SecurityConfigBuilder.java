package assignment.src.builderInbuilder;

public class SecurityConfigBuilder{

    private final Config.ConfigBuilder parentBuilder;

    public String roles;
    public String authorization;

    public SecurityConfigBuilder roles(String roles){
        this.roles = roles;
        return this;
    }
    public SecurityConfigBuilder authorization(String authorization){
        this.authorization = authorization;
        return this;
    }
    public Config.ConfigBuilder and(){
        return parentBuilder;
    }

    public SecurityConfigBuilder(Config.ConfigBuilder cb){
        this.parentBuilder = cb;
    }

}
