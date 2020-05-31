package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tug.it.openprojectapi.domain.MemberRoles;
import tug.it.openprojectapi.domain.Members;
import tug.it.openprojectapi.domain.Roles;
import tug.it.openprojectapi.model.MembersDto;
import tug.it.openprojectapi.respository.MemberRolesRepository;
import tug.it.openprojectapi.respository.MembersRepository;
import tug.it.openprojectapi.respository.RolesRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final MembersRepository membersRepository;
    private final MemberRolesRepository memberRolesRepository;
    private final RolesRepository rolesRepository;

    private final UsersService usersService;

    public List<MembersDto> getAllByProjectId(Integer projectId) {
        List<Members> members = Optional.of(membersRepository.findAllByProjectId(projectId))
                .orElse(Collections.EMPTY_LIST);

        return members.stream()
                .map(this::buildDto)
                .collect(toList());
    }

    private MembersDto buildDto(Members members) {
        Integer memberRoleId = Optional.ofNullable(memberRolesRepository.findByMemberId(members.getId()))
                .orElseGet(MemberRoles::getDefaultMemberRoles)
                .getRoleId();

        String roleName = StringUtils.capitalize(
                rolesRepository.findById(memberRoleId)
                .orElseGet(Roles::getDefaultRoles)
                .getName()
        );

        return MembersDto.builder()
                .user(usersService.getUserFirstLastName(members.getUserId()))
                .role(roleName)
                .build();
    }
}
