package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tug.it.openprojectapi.domain.CostTypes;
import tug.it.openprojectapi.respository.CostTypesRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CostTypesService {

    private final CostTypesRepository costTypesRepository;

    public String getCostTypesName(Integer costTypesId) {
        CostTypes costTypes = costTypesRepository.findById(
                Optional.ofNullable(costTypesId).orElse(0)
            ).orElseGet(CostTypes::getDefaultCostTypes);

        return costTypes.getName();
    }
}
