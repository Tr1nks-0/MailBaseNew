package com.tr1nksgroup.model.components;

import com.tr1nksgroup.config.properties.InitialUnitsProperties;
import com.tr1nksgroup.model.entities.CathedraEntity;
import com.tr1nksgroup.model.entities.FacultyEntity;
import com.tr1nksgroup.model.services.CathedraService;
import com.tr1nksgroup.model.services.FacultyService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Pattern NAME_PATTERN = Pattern.compile("name[\\s?]*=[\\s?]*\"([а-яА-Яa-zA-Z ,\\-'`]*)\"[\\s?]*,?");
    private static final Pattern ABBR_PATTERN = Pattern.compile("abbr[\\s?]*=[\\s?]*\"([а-яА-Яa-zA-Z ]*)\"[\\s?]*,?");
    private static final Pattern FACULTY_ID_PATTERN = Pattern.compile("facultyId[\\s?]*=[\\s?]*(\\d*)[\\s?]*,?");
    @Resource
    InitialUnitsProperties initialUnitsProperties;
    @Resource
    FacultyService facultyService;
    @Resource
    CathedraService cathedraService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (FacultyEntity facultyEntity : getFacultyEntityList(initialUnitsProperties.getFacultyArrStr())) {
            if (!facultyService.containsByFacultyId(facultyEntity.getFacultyId())) {
                facultyService.save(facultyEntity);
            }
        }
        for (CathedraEntity cathedraEntity : getCathedraEntityList(initialUnitsProperties.getCathedraArrStr())) {
            if (!cathedraService.containsByAbbr(cathedraEntity.getAbbr())) {
                cathedraService.save(cathedraEntity);
            }
        }
    }

    private List<FacultyEntity> getFacultyEntityList(String[] facultyArrStr) {
        List<FacultyEntity> list = new ArrayList<>();
        for (String str : facultyArrStr) {
            Matcher nameMatcher = NAME_PATTERN.matcher(str);
            Matcher facultyIdMatcher = FACULTY_ID_PATTERN.matcher(str);
            Matcher abbrMatcher = ABBR_PATTERN.matcher(str);
            if (nameMatcher.find() && facultyIdMatcher.find() && abbrMatcher.find()) {
                list.add(new FacultyEntity(Integer.parseInt(facultyIdMatcher.group(1)), nameMatcher.group(1), abbrMatcher.group(1)));
            }
        }
        return list;
    }

    private List<CathedraEntity> getCathedraEntityList(String[] cathedraArrStr) {
        List<CathedraEntity> list = new ArrayList<>();
        for (String str : cathedraArrStr) {
            Matcher nameMatcher = NAME_PATTERN.matcher(str);
            Matcher facultyIdMatcher = FACULTY_ID_PATTERN.matcher(str);
            Matcher abbrMatcher = ABBR_PATTERN.matcher(str);
            if (nameMatcher.find() && facultyIdMatcher.find() && abbrMatcher.find()) {
                list.add(new CathedraEntity(facultyService.getByFacultyId(Integer.parseInt(facultyIdMatcher.group(1))), nameMatcher.group(1), abbrMatcher.group(1)));
            }
        }
        return list;
    }
}