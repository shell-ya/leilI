package com.linkwin.task;

public interface IDealBoxCodeApplyTaskService {


    public void dealApply();

    public void generateCode(long applyId,int year,String tableName,int generateNum);


}
