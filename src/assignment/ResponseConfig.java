package assignment;

public class ResponseConfig{
    public String body;
    public String type;
    public ResponseConfig(ResponseConfigBuilder rcb) {
        this.body = rcb.body;
        this.type = rcb.type;
    }
}
