package com.myself.proprety;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cangqiong.jwt")
@Data
public class JwtProperty {

//    网页端属性
    private long adminExpireTime;
    private String adminTokenName;
    private String adminSecretKey;
}
