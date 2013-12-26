<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
step2
  <input id ="stepData" value="${dataBean.step2Data}"/>
  <button type="button" onclick="cancel()">取消</button>
  <button type="button" onclick="backStep('backstep1')">上一步</button>
  <button type="button" onclick="nextStep('step3')">下一步</button>