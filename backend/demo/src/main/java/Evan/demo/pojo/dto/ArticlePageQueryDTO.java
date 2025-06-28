package Evan.demo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePageQueryDTO {
    private Integer pageNum;
    private Integer pageSize;
    private Integer categoryId;
    private String state;
}
