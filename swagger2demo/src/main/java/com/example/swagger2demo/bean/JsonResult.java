package com.example.swagger2demo.bean;

/**
 * @author waylanpunch
 * @ClassName com.example.swagger2demo.bean.JsonResult
 * @Description JsonResult Bean
 */
public class JsonResult {
    private String status = null;

    private Object result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
