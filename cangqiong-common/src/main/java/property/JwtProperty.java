package property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//component需要在启动项子包内，或者使用其他方式放到ioc容器中（import）
@Component
@ConfigurationProperties(prefix = "cangqiong.jwt")
@Data
public class JwtProperty {

//    网页端属性
    private long adminExpireTime;
    private String adminTokenName;
    private String adminSecretKey;
}
