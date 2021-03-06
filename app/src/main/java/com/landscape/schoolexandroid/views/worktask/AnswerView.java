package com.landscape.schoolexandroid.views.worktask;

import com.landscape.schoolexandroid.mode.worktask.QuestionInfo;
import com.landscape.schoolexandroid.presenter.BasePresenter;
import com.landscape.schoolexandroid.views.BaseView;
import com.landscape.weight.FlingRelativeLayout;
import com.landscape.weight.ScrollWebView;

/**
 * Created by 1 on 2016/6/30.
 */
public interface AnswerView<T extends BasePresenter> extends BaseView<T> {

    void previewTask(String url);

    void startTimeTick(int startTime);
    void setLocation(int idx,int total);
    void setTimeEnable(boolean isEnable);
    void setAnswerCard(QuestionInfo info,int SubjectTypeId);
    boolean isAnswerChanged();
    String getAnswer();
    String getDuration();

    void setBtnClickListener(BtnClickListener btnClickListener);
    interface BtnClickListener{
        void finish();
        void location();
    }

    void setTimeCounterCallbk(TimeCounterCallbk timeCounterCallbk);
    interface TimeCounterCallbk{
        void timeOut();
    }

    void setDragListener(ScrollWebView.DragHorizontalListener dragListener);
}
