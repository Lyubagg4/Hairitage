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
    private Map<Integer, EnumMap<Group, Range>> rules;
    private List<Integer> hairTypesId;

    public RulesCacheService(HairTypeRepo hairTypeRepo, RelevantRangeRepo relevantRangeRepo) {
        this.hairTypeRepo = hairTypeRepo;
        this.relevantRangeRepo = relevantRangeRepo;
    }

    @Transactional(readOnly = true)
    public Map<Integer, EnumMap<Group, Range>> getRules() {
        if (rules == null) {
            rules = buildRules();
        }
        return rules;
    }

    @Transactional(readOnly = true)
    public void reload() {
        rules = buildRules();
    }

    @Transactional(readOnly = true)
    protected Map<Integer, EnumMap<Group, Range>> buildRules() {
        List<RelevantRange> ranges = relevantRangeRepo.findAll();
        Map<Integer, EnumMap<Group, Range>> built = new HashMap<>();
        for (RelevantRange rr : ranges) {
            int hairTypeId = rr.getHairType().getHairTypeId();
            Group group = rr.getGroup().getGroupName();
            built.computeIfAbsent(hairTypeId, k -> new EnumMap<>(Group.class))
                    .put(group, new Range(rr.getMinValue(), rr.getMaxValue()));
        }
        return built;
    }

    public void setRules(Map<Integer, EnumMap<Group, Range>> rules) {
        this.rules = rules;
    }
}
