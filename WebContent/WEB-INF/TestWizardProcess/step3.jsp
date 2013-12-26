<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
step3
  <input id ="stepData" value="${dataBean.step3Data}"/>
  <button type="button" onclick="cancel()">取消</button>
  <button type="button" onclick="backStep('backstep2')">上一步</button>
  <button type="button" onclick="nextStep('finish')">完成</button>