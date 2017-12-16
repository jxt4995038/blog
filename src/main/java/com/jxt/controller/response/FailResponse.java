package com.jxt.controller.response;

public class FailResponse extends AbstractResponse {

  public FailResponse() {
    super(IResponse.STATUS_FAIL, IResponse.ERR_CODE);
  }

  public FailResponse(String code) {
    super(IResponse.STATUS_FAIL, code);
  }

  public FailResponse(String code, String error) {
    super(IResponse.STATUS_FAIL, IResponse.ERR_CODE);
    if (null != code) {
      this.setCode(code);
    }
    this.setError(error);
  }

  public FailResponse(String code, String error, Object data) {
    super(IResponse.STATUS_FAIL, IResponse.ERR_CODE);
    if (null != code) {
      this.setCode(code);
    }
    this.setError(error);
    this.setData(data);
  }
}
