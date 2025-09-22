package config;

import org.springframework.context.annotation.Import;
import property.JwtProperty;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({JwtProperty.class}) // 直接在这里导入
public @interface EnableCommonModule {
}
