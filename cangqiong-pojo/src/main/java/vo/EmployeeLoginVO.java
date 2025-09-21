package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLoginVO {
    private Long id;
    private String username;
    private String name;

//    准备使用jtw令牌
    private String token;
}
