package com.jxt.controller.response;

public interface IResponse {

  public IResponse SUCCESS_RESPONSE = new SuccessResponse();
  public IResponse FAILED_RESPONSE = new FailResponse();

  public final String STATUS_SUCCESS = "success";
  public final String STATUS_FAIL = "fail";

  //默认的成功代码，目前无实际意义
  public final String SUC_CODE = "0";
  //默认的错误码
  public final String ERR_CODE = "9999";
  public final String ERR_CODE_SCHEME_EXIST = "1000";
  public final String ERR_CODE_SCHEME_INVALID = "1001";
  public final String ERR_CODE_SCHEME_NOT_EXIST = "1003";
  public final String ERR_CODE_SCHEME_DELETE_FAILED = "1004";
  //参数错误
  public final String ERR_CODE_PARAM_ERROR = "2000";
  //上传数据错误
  public final String ERR_CODE_UPLOAD_DATA_ERROR = "2001";
}

