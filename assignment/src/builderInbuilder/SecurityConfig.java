package assignment.src.builderInbuilder;

public class SecurityConfig {
    public String authorization;
    public String roles;
    public SecurityConfig(SecurityConfigBuilder scb) {
        this.authorization = scb.authorization;
        this.roles = scb.roles;
    }
}
