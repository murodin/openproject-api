package tug.it.openprojectapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel(value = "ProjectsDto", description = "Projects Data Transfer Objects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectsDto {

    @ApiModelProperty(notes = "id", example = "1453", position = 0)
    private Integer id;
    @ApiModelProperty(notes = "parent_id", example = "1071", position = 1)
    private Integer parent_id;

    @ApiModelProperty(notes = "name", example = "Test Project", position = 2)
    private String name;
    @ApiModelProperty(notes = "description", example = "Test", position = 3)
    private String description;
    @ApiModelProperty(notes = "identifier", example = "test-project", position = 4)
    private String identifier;

    @ApiModelProperty(notes = "budget",  position = 5)
    private BudgetDto budget;
    @ApiModelProperty(notes = "work_packages", position = 6)
    private List<WorkPackagesDto> work_packages;
    @ApiModelProperty(notes = "members", position = 6)
    private List<MemberDto> members;

    @ApiModelProperty(notes = "active", example = "true", position = 7)
    private boolean active;
    @ApiModelProperty(notes = "created_at", example = "2020-01-01T14:53:00+0000", position = 8)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime created_at;
    @ApiModelProperty(notes = "updated_at", example = "2020-01-01T14:53:00+0000", position = 9)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime updated_at;
}
