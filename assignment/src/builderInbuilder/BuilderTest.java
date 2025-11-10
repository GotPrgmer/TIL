package assignment.src.builderInbuilder;
/*
빌더의 빌더 패턴

Config.builder() <-ConfigBuilder
    .requestConfig() <-RequestConfigBuilder
        .header()
        .cookie()
        .and()
    .responseConfig() <-RequestConfigBuilder
        .body()
        .type()
        .and()
    .securityConfig() <-RequestConfigBuilder
        .authorization()
        .roles()
    .build() <-Config
    requestConfig, responseConfig, securityConfig를 부르는 순서는 상관이 없으며,
     각 config 별 메소드들 또한 and를 제외하고는 부르는 순서에 따른 결과에 영향이 없어야 합니다.
      또한 build()메소드는 언제든지 불러서 마무리할 수 있어야 합니다.

위와 같은 형태로 실행되어야 함.
마지막에 상속이 걸려있어서 자동적으로 super()가 호출이 되어 stackOverFlowError가 발생하였음.

 */
import java.io.IOException;
public class BuilderTest {
    public static void main(String[] args) throws IOException {
        Config c = Config.builder()
                .requestConfig()
                .header()
                .cookie()
                .and()
                .responseConfig()
                .body()
                .type()
                .and()
                .securityConfig()
                .authorization()
                .roles()
                .build();
        System.out.println(c);
    }
}
