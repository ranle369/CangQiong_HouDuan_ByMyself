package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLoginVO implements Serializable {
    private Long id;
    private String username;
    private String name;

//    准备使用jtw令牌
    private String token;
}
