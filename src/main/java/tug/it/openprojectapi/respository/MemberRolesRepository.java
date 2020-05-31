package tug.it.openprojectapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tug.it.openprojectapi.domain.MemberRoles;

public interface MemberRolesRepository extends JpaRepository<MemberRoles, Integer> {
    MemberRoles findByMemberId(Integer memberId);
}
