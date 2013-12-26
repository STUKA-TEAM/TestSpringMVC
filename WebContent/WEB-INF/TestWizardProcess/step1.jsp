<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
step1
  <input id ="stepData" value="${dataBean.step1Data}"/>
  <button type="button" onclick="cancel()">取消</button>
  <button type="button" onclick="nextStep('step2')">下一步</button>