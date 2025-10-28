package assignment;

public class RequestConfig{
    public String header;
    public String cookie;

    public RequestConfig(RequestConfigBuilder rcb) {
        this.header = rcb.header;
        this.cookie = rcb.cookie;
    }
}
