package tug.it.openprojectapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "MemberDto", description = "Members Data Transfer Objects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    @ApiModelProperty(notes = "user", example = "Şinasi Aşağıbakmaz", position = 0)
    private String user;

    @ApiModelProperty(notes = "role", example = "Proje Yöneticisi", position = 1)
    private String role;
}
