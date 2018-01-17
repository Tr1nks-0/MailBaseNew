package com.tr1nksgroup.model.engines;

import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.services.DomensService;
import com.tr1nksgroup.model.services.GroupService;
import com.tr1nksgroup.model.services.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.regex.Pattern;

@Component
public class EmailToOutEngine {
    @Resource
    private StudentService studentService;
    @Resource
    private GroupService groupService;
    @Resource
    private DomensService domensService;
    private static final Pattern patternInnerGroupChiper = Pattern.compile("^0");
    private static final Pattern patternOuterGroupChiper = Pattern.compile("\\.0");

    public String get(String name, String surname, String groupChiper) {
        String grr = patternOuterGroupChiper.matcher((patternInnerGroupChiper.matcher(groupChiper).replaceAll(""))).replaceAll(".");
        String[] groupCipherArray = grr.split("\\.");
        int level = Integer.parseInt(groupCipherArray[0]);
        int faculty = Integer.parseInt(groupCipherArray[1]);
        int speciality = Integer.parseInt(groupCipherArray[2]);
        int specialization;
        int year;
        int num;
        if (groupCipherArray.length == 6) {
            specialization = Integer.parseInt(groupCipherArray[3]);
            year = Integer.parseInt(groupCipherArray[4]);
            num = Integer.parseInt(groupCipherArray[5]);
        } else {
            specialization = 99999;
            year = Integer.parseInt(groupCipherArray[3]);
            num = Integer.parseInt(groupCipherArray[4]);
        }
        GroupEntity groupEntity = groupService.getByStudyLevelEntityLevelIdAndFacultyEntityFacultyIdAndSpecializationEntitySpecializationIdAndYearAndNum(level, faculty, speciality, specialization, year, num);
        StudentEntity student = studentService.getBySurnameAndNameAndGroup(surname, name, groupEntity);
        if (student == null) {
            return "{null}";
        } else {
            return student.getLogin() + '@' + domensService.getEmailDomen();
        }
    }
}
