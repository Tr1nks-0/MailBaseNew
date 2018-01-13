package com.tr1nksgroup.model.components;

import com.tr1nksgroup.model.components.properties.InitialUnitsProperties;
import com.tr1nksgroup.model.entities.*;
import com.tr1nksgroup.model.services.*;
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
    private static final Pattern NAME_PATTERN = Pattern.compile("name[\\s?]*=[\\s?]*\"([а-яА-Яa-zA-Z ,\\-`'’ҐґІіЇїЄє0-9]*)\"[\\s?]*,?");
    private static final Pattern DOMEN_GMAIL_PATTERN = Pattern.compile("gmail[\\s?]*=[\\s?]*\"([a-zA-Z1-9 .\\-]*)\"[\\s?]*,?");
    private static final Pattern DOMEN_OFFICE_PATTERN = Pattern.compile("office[\\s?]*=[\\s?]*\"([a-zA-Z1-9 .\\-]*)\"[\\s?]*,?");
    private static final Pattern DOMEN_IMAGINE_PATTERN = Pattern.compile("imagine[\\s?]*=[\\s?]*\"([a-zA-Z1-9 .\\-]*)\"[\\s?]*,?");
    private static final Pattern ABBR_PATTERN = Pattern.compile("abbr[\\s?]*=[\\s?]*\"([а-яА-Яa-zA-Z ҐґІіЇїЄє]*)\"[\\s?]*,?");
    private static final Pattern STUDYLEVEL_ID_PATTERN = Pattern.compile("studylevelId[\\s?]*=[\\s?]*(\\d*)[\\s?]*,?");
    private static final Pattern FACULTY_ID_PATTERN = Pattern.compile("facultyId[\\s?]*=[\\s?]*(\\d*)[\\s?]*,?");
    private static final Pattern SPECIALITY_ID_PATTERN = Pattern.compile("specialityId[\\s?]*=[\\s?]*(\\d*)[\\s?]*,?");
    private static final Pattern SPECIALIZATION_ID_PATTERN = Pattern.compile("specializationId[\\s?]*=[\\s?]*(\\d*)[\\s?]*,?");
    @Resource
    private InitialUnitsProperties initialUnitsProperties;
    @Resource
    private StudyLevelService studyLevelService;
    @Resource
    private FacultyService facultyService;
    @Resource
    private CathedraService cathedraService;
    @Resource
    private SpecialityService specialityService;
    @Resource
    private SpecializationService specializationService;
    @Resource
    private UserService userService;
    @Resource
    private DomensService domensService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        UserEntity ue = new UserEntity("em@d.c", "root", SiteRolesEnum.ADMIN, true, "name", "surname", UUID.randomUUID());
//        userService.save(ue);

        DomensEntity domensEntity = getDomensEntity(initialUnitsProperties.getDomensStr());
        if (null != domensEntity && !domensService.containsByAllDomens(domensEntity.getEmailDomen(), domensEntity.getImagineDomen(), domensEntity.getOfficeDomen())) {
            domensService.save(domensEntity);
        }

        for (StudyLevelEntity studyLevelEntity : getStudyLevelEntityList(initialUnitsProperties.getStudylevelArrStr())) {
            if (!studyLevelService.containsByLevelId(studyLevelEntity.getLevelId())) {
                studyLevelService.save(studyLevelEntity);
            }
        }
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
        for (SpecialityEntity specialityEntity : getSpecialityEntityList(initialUnitsProperties.getSpecialityArrStr())) {
            if (!specialityService.containsByspecialityId(specialityEntity.getSpecialityId())) {
                specialityService.save(specialityEntity);
            }
        }
        for (SpecializationEntity specializationEntity : getSpecializationEntityList(initialUnitsProperties.getSpecializationArrStr())) {
            if (!specializationService.containsByspecializationIdAndSpecialityEntity(specializationEntity.getSpecializationId(), specializationEntity.getSpecialityEntity())) {
                specializationService.save(specializationEntity);
            }
        }
    }

    private DomensEntity getDomensEntity(String domensStr) {
        Matcher gmailMatcher = DOMEN_GMAIL_PATTERN.matcher(domensStr);
        Matcher imagineMatcher = DOMEN_IMAGINE_PATTERN.matcher(domensStr);
        Matcher officeMatcher = DOMEN_OFFICE_PATTERN.matcher(domensStr);
        if (gmailMatcher.find() && imagineMatcher.find() && officeMatcher.find()) {
            return new DomensEntity(gmailMatcher.group(1), imagineMatcher.group(1), officeMatcher.group(1));
        }
        return null;
    }

    private List<StudyLevelEntity> getStudyLevelEntityList(String[] facultyArrStr) {
        List<StudyLevelEntity> list = new ArrayList<>();
        for (String str : facultyArrStr) {
            Matcher nameMatcher = NAME_PATTERN.matcher(str);
            Matcher studyLevelMatcher = STUDYLEVEL_ID_PATTERN.matcher(str);
            if (nameMatcher.find() && studyLevelMatcher.find()) {
                list.add(new StudyLevelEntity(Integer.parseInt(studyLevelMatcher.group(1)), nameMatcher.group(1)));
            }
        }
        return list;
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

    private List<SpecialityEntity> getSpecialityEntityList(String[] specialityArrStr) {
        List<SpecialityEntity> list = new ArrayList<>();
        for (String str : specialityArrStr) {
            Matcher nameMatcher = NAME_PATTERN.matcher(str);
            Matcher specialityIdMatcher = SPECIALITY_ID_PATTERN.matcher(str);
            if (nameMatcher.find() && specialityIdMatcher.find()) {
                list.add(new SpecialityEntity(Integer.parseInt(specialityIdMatcher.group(1)), nameMatcher.group(1)));
            }
        }
        return list;
    }

    private List<SpecializationEntity> getSpecializationEntityList(String[] specialityArrStr) {
        List<SpecializationEntity> list = new ArrayList<>();
        for (String str : specialityArrStr) {
            Matcher nameMatcher = NAME_PATTERN.matcher(str);
            Matcher specializationIdMatcher = SPECIALIZATION_ID_PATTERN.matcher(str);
            Matcher specialityIdMatcher = SPECIALITY_ID_PATTERN.matcher(str);
            if (nameMatcher.find() && specializationIdMatcher.find() && specialityIdMatcher.find()) {
                list.add(new SpecializationEntity(Integer.parseInt(specializationIdMatcher.group(1)), nameMatcher.group(1), specialityService.getBySpecialityId(Integer.parseInt(specialityIdMatcher.group(1)))));
            }
        }
        return list;
    }
}