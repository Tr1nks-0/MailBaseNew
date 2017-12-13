package com.tr1nksgroup.model.engines;

import com.tr1nksgroup.model.models.UploadModel;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UploadEngine {
    private static final String FILE_STORAGE_PATH = "./fileStorage/";
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//    private static final Pattern patternInnerGroupChiper = Pattern.compile("^0");
//    private static final Pattern patternOuterGroupChiper = Pattern.compile("\\.0");
//    @Resource
//    private StudentService studentService;
//    @Resource
//    private GroupService groupService;
//    @Resource
//    private FacultyService facultyService;
//    @Resource
//    private LoginPasswordUtil loginPasswordUtil;

    /**
     * загрузить файл
     *
     * @param file файл
     * @return данные страницы загрузки на сервер с предпросмотром по фильтрам по умолчанию
     */
    public UploadModel uploadFile(MultipartFile file) {
        if (!new File(FILE_STORAGE_PATH).exists()) {
            new File(FILE_STORAGE_PATH).mkdir();
        }
        String fn = dateFormat.format(new Date()) + "----" + file.getOriginalFilename();
        int add = 1;
        while (new File(FILE_STORAGE_PATH + fn).exists()) {
            fn = fn.replaceFirst("--\\d*--", "--" + add + "--");
            add++;
        }
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(FILE_STORAGE_PATH + fn)))) {
            stream.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        UploadModel uploadModel = new UploadModel();
        uploadModel.setFilename(fn);
//        refillWithNewFilterData(uploadModel);
        return uploadModel;
    }

//    /**
//     * пере-заполнить с учетом даных фильтров
//     *
//     * @param uploadModel пере-заполненные данные страницы
//     */
//    public void refillWithNewFilterData(UploadModel uploadModel) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_STORAGE_PATH + uploadModel.getFilename()), uploadModel.getCodepage().getValue()))) {
//            String buf;
//            byte i = 0;
//            while ((buf = reader.readLine()) != null && i < 2) {
//                uploadModel.getFileStrings()[i] = buf.split(uploadModel.getDelimiter().getValue());
//                i++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * парсить из файла
//     *
//     * @param uploadPD данные страницы
//     * @return данные для страницы с загруженными персонами
//     */
//    public Model parseFromFile(UploadModel uploadPD) {
//        Model model = null;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_STORAGE_PATH + uploadPD.getFilename()), uploadPD.getCodepage().getValue()))) {
//            if (PersonEnum.STUDENT.equals(uploadPD.getPerson())) {
//                model = parseStudents(reader, uploadPD.getDelimiter().getValue(), uploadPD.getMask());
//            } else if (PersonEnum.TEACHER.equals(uploadPD.getPerson())) {
//                model = new TeacherModel();//stub fixme
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return model;
//    }
//
//    /**
//     * парсить студентов из файла
//     *
//     * @param reader    читатель файла
//     * @param delimiter символ-разделитель в строке
//     * @param mask      маска положения столбцов
//     * @return данные страницы студенты
//     * @throws IOException ошибки чтения reader-ом
//     */
//    private StudentModel parseStudents(BufferedReader reader, String delimiter, UploadFileMaskEnum[] mask) throws IOException {
//        List<StudentEntity> students = new ArrayList<>();
//        String buf;
//        boolean errFlag = false;
//        while ((buf = reader.readLine()) != null) {
//            if (buf.toLowerCase().contains("имя") || buf.toLowerCase().contains("name")) {
//                continue;
//            }
//            String[] arr = parseArrOnMask(buf.split(delimiter), mask);
//            arr[4] = patternOuterGroupChiper.matcher((patternInnerGroupChiper.matcher(arr[4]).replaceAll(""))).replaceAll(".");
//            GroupEntity groupEntity = groupService.getByCipher(arr[4]);
//            if (null == groupEntity) {
//                String[] ga = arr[4].split("\\.");
////                groupEntity = new GroupEntity(Integer.valueOf(ga[0]), facultyService.getByFacultyId(Integer.valueOf(ga[1])), Integer.valueOf(ga[2]), Integer.valueOf(ga[3]), Integer.valueOf(ga[4]));
//                groupService.save(groupEntity);
//            }
//            StudentEntity student = new StudentEntity(arr[0], arr[1], arr[2], arr[3], groupEntity, loginPasswordUtil.createLogin(arr[0], arr[1]), loginPasswordUtil.generatePassword(8), parseTrueFlag(arr[5]));
//            if (studentService.testCode(arr[3])) {
//                studentService.addStudent(student);
//            } else {
//                student.setErrorMessage("Дубликат кода");
//                errFlag = true;
//            }
//            students.add(student);
//        }
//        StudentPageData pd = new StudentPageData();
//        pd.setErrFlg(errFlag);
//        pd.setStudents(students);
//        return pd;
//    }
//
//    /**
//     * разложить массив в правильном порядке по маске
//     *
//     * @param inp  входной массив
//     * @param mask маска
//     * @return массив  в порядке : {фамилия, имя, отчество, код, группа, бюджет}
//     */
//    private String[] parseArrOnMask(String[] inp, UploadFileMaskEnum[] mask) {
//        int i = 0;
//        String[] out = new String[6];
//        while (i < mask.length && i < inp.length) {
//            switch (mask[i]) {
//                case SURNAME:
//                    out[0] = inp[i];
//                    break;
//                case NAME:
//                    out[1] = inp[i];
//                    break;
//                case PATRONYMIC:
//                    out[2] = inp[i];
//                    break;
//                case CODE:
//                    out[3] = inp[i];
//                    break;
//                case GROUP:
//                    out[4] = inp[i];
//                    break;
//                case BUDGET:
//                    out[5] = inp[i];
//                    break;
//                default:
//                    break;
//            }
//            i++;
//        }
//        return out;
//    }
//
//    /**
//     * преобразование во флаг о наличии
//     *
//     * @param s строка для преобразования
//     * @return true если строка соответствует "true","да","+","yes","1"  и false в остальных случаях
//     */
//    private boolean parseTrueFlag(String s) {
//        return s.equals("true") || s.equals("да") || s.equals("+") || s.equals("yes") || s.equals("1");
//    }

}
