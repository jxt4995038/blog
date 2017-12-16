package com.jxt.controller.response;


public class SuccessResponse extends AbstractResponse {
  public SuccessResponse() {
    super(IResponse.STATUS_SUCCESS, IResponse.SUC_CODE);
  }

  public SuccessResponse(Object data) {
    this();
    this.setData(data);
  }
}
