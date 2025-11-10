package assignment.src.builderInbuilder;

public class Config{
    public RequestConfig requestConfig;
    public ResponseConfig responseConfig;
    public SecurityConfig securityConfig;
    public Config(ConfigBuilder cb){
        this.requestConfig = new RequestConfig(cb.rcb);
        this.responseConfig = new ResponseConfig(cb.rcbr);
        this.securityConfig = new SecurityConfig(cb.scb);
    }

    public static ConfigBuilder builder() {
        return new ConfigBuilder();
    }
    public static class ConfigBuilder{

        private RequestConfigBuilder rcb = new RequestConfigBuilder(this);
        private ResponseConfigBuilder rcbr = new ResponseConfigBuilder(this);
        private SecurityConfigBuilder scb = new SecurityConfigBuilder(this);


        public  RequestConfigBuilder requestConfig(){
            return rcb;
        }
        public  ResponseConfigBuilder responseConfig(){
            return rcbr;
        }
        public  SecurityConfigBuilder securityConfig(){
            return scb;
        }
        public Config build(){
            return new Config(this);
        }
    }

}
