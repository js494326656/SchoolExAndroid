package com.landscape.schoolexandroid.views.home;

import com.landscape.schoolexandroid.mode.worktask.ExaminationTaskInfo;
import com.landscape.schoolexandroid.presenter.BasePresenter;
import com.landscape.schoolexandroid.views.BaseView;

import java.util.List;

/**
 * Created by 1 on 2016/6/22.
 */
public interface WorkTaskListView<T extends BasePresenter> extends BaseListView<T> {

    void listWork(List<ExaminationTaskInfo> listData);

    interface OnListItemSelectListener{
        void onSelect(ExaminationTaskInfo taskInfo);
    }

    void setListItemSelectListener(OnListItemSelectListener listener);

}
