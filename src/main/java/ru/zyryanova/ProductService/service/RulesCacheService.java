package ru.zyryanova.ProductService.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.bd.HairType;
import ru.zyryanova.ProductService.entity.bd.RelevantRange;
import ru.zyryanova.ProductService.enums.Group;
import ru.zyryanova.ProductService.repo.HairTypeRepo;
import ru.zyryanova.ProductService.repo.RelevantRangeRepo;
import ru.zyryanova.ProductService.tools.Range;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RulesCacheService {

    private final HairTypeRepo hairTypeRepo;
    private final RelevantRangeRepo relevantRangeRepo;

    private volatile Map<Integer, EnumMap<Group, Range>> rules = Map.of();
    private volatile List<Integer> hairTypesId = List.of();

    public RulesCacheService(HairTypeRepo hairTypeRepo, RelevantRangeRepo relevantRangeRepo) {
        this.hairTypeRepo = hairTypeRepo;
        this.relevantRangeRepo = relevantRangeRepo;
    }

    @PostConstruct
    @Transactional(readOnly = true)
    public void init() {
        reload();
    }

    @Transactional(readOnly = true)
    public synchronized void reload() {
        List<HairType> hairTypes = hairTypeRepo.findAll();

        hairTypesId = hairTypes.stream()
                .map(HairType::getHairTypeId)
                .toList();

        List<RelevantRange> ranges = relevantRangeRepo.findByHairType_HairTypeIdIn(hairTypesId);

        Map<Integer, EnumMap<Group, Range>> built = new HashMap<>();
        for (RelevantRange rr : ranges) {
            int hairTypeId = rr.getHairType().getHairTypeId();
            Group group = rr.getGroup().getGroupName();
            built.computeIfAbsent(hairTypeId, k -> new EnumMap<>(Group.class)).put(group, new Range(rr.getMinValue(), rr.getMaxValue()));
        }

        rules = built;
    }

    public Map<Integer, EnumMap<Group, Range>> getRules() {
        return rules;
    }

    public List<Integer> getHairTypes() {
        return hairTypesId;
    }
}
