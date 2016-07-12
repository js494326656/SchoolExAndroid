package com.landscape.schoolexandroid.utils;

import com.landscape.schoolexandroid.mode.account.UserAccount;
import com.landscape.schoolexandroid.mode.worktask.ExaminationTaskInfo;
import com.utils.datahelper.TimeConversion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 1 on 2016/7/11.
 */
public class WorkTaskHelper {

    public static Map<String, List<ExaminationTaskInfo>> sortTaskByDate(List<ExaminationTaskInfo> infos) {
        Map<String, List<ExaminationTaskInfo>> taskMap = new HashMap<>();
        for (int i=0;i<infos.size();i++) {
            String date = TimeConversion.getYearsMonthsData(
                    TimeConversion.getDurationWithGMT(infos.get(i).getCanStartDateTime()));
            List<ExaminationTaskInfo> tempTasks = taskMap.get(date);
            if (tempTasks == null) {
                tempTasks = new ArrayList<>();
                taskMap.put(date, tempTasks);
            }
            tempTasks.add(infos.get(i));
        }
        return taskMap;
    }

    public static List<String> sortDate(Set<String> keys) {
        List<String> dates = new ArrayList<>();
        for (String key : keys) {
            dates.add(key);
        }
        Collections.sort(dates);
        Collections.reverse(dates);
        return dates;
    }

    public static List<UserAccount.DataBean.SubjectTypeBean> getValidSubjectType(List<UserAccount.DataBean.SubjectTypeBean> source) {
        List<UserAccount.DataBean.SubjectTypeBean> result = new ArrayList<>();
        for (UserAccount.DataBean.SubjectTypeBean subjectTypeBean : source) {
            if (subjectTypeBean.getStatus() == 0) {
                result.add(subjectTypeBean);
            }
        }
        return result;
    }

    public static List<UserAccount.DataBean.SubjectTypeBean> addDefSubjectType(List<UserAccount.DataBean.SubjectTypeBean> source) {
        List<UserAccount.DataBean.SubjectTypeBean> result = new ArrayList<>();
        UserAccount.DataBean.SubjectTypeBean def = new UserAccount.DataBean.SubjectTypeBean();
        def.setName("默认");
        def.setStatus(0);
        def.setId(-1);
        result.add(def);
        result.addAll(source);
        return result;
    }

    public static List<UserAccount.DataBean.ExaminationPapersTypeBean> addDefPaperType(List<UserAccount.DataBean.ExaminationPapersTypeBean> source) {
        List<UserAccount.DataBean.ExaminationPapersTypeBean> result = new ArrayList<>();
        UserAccount.DataBean.ExaminationPapersTypeBean def = new UserAccount.DataBean.ExaminationPapersTypeBean();
        def.setId(-1);
        def.setName("默认");
        result.add(def);
        result.addAll(source);
        return result;
    }
}