package Evan.demo.pojo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryDTO {
    @NotNull(message = "id can't empty")
    private Integer id;

    @NotEmpty(message = "categoryName can't empty")
    private String categoryName;

    @NotEmpty(message = "categoryAlias can't empty")
    private String categoryAlias;
}
