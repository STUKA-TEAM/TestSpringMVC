package TestSpringInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor { 
		  
	    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,  
	            Exception arg3) throws Exception {  
	        System.out.println("最后执行，一般用于释放资源！");  
	    }  
	  
	    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,  
	            ModelAndView arg3) throws Exception {  
	        System.out.println("action执行之后，生成视图之前执行！");  
	    }  
	  
	    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2)  
	            throws Exception {  
	    	arg0.setAttribute("interceptorMes", "interceptor");
	        System.out.println("action之前执行！");  
	        return true; // 继续执行action  
	    }  
}
