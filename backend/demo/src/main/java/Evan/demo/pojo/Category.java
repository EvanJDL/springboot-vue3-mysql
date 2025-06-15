package Evan.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer id;
    private String categoryName;
    private String categoryAlias;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}