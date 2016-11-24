package com.shine.core.utils.spring;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//import javax.transaction.HeuristicMixedException;
//import javax.transaction.HeuristicRollbackException;
//import javax.transaction.RollbackException;
//import javax.transaction.Status;
//import javax.transaction.SystemException;
//import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.jta.JtaTransactionManager;

@Aspect    
@Component
public class ADFTransactionAspect {
    @Autowired
    private JtaTransactionManager transactionManager;
    private  static final   ThreadLocal transSession = new ThreadLocal();  //事务管理会话
    private  static  final  ThreadLocal   transFlags=new ThreadLocal();    //事务轨迹标记   实际环境最好用堆栈实现
    
    public ADFTransactionAspect() {
        super();
    }
    
    protected static Logger logger = Logger.getLogger(ADFTransactionAspect.class);
    
    //层切点
    @Pointcut("execution(* com.shine.view.service..*.register*(..)) ||execution(* com.shine.view.service..*.add*(..)) || execution(* com.shine.view.service..*.create*(..)) || execution(* com.shine.view.service..*.update*(..))|| execution(* com.shine.view.service..*.cancel*(..)) || execution(* com.shine.view.service..*.delete*(..)) || execution(* com.shine.view.service..*.update*(..)) ||execution(* com.shine.view.service..*.accumulate*(..)) || execution(* com.shine.view.service..*.import*(..))|| execution(* com.shine.view.service..*.save*(..))|| execution(* com.shine.view.service..*.login*(..))|| execution(* com.shine.view.service..*.pull*(..))")
    public void aspect() {
    }
    
    //声明环绕通知
    @Around("aspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object o = pjp.proceed();
        Object target = pjp.getTarget();
        logger.info(pjp.getSignature() +" notify apply");
        Method method =  target.getClass().getMethod("apply");
        if(method !=null){
            method.invoke(target);
        }
        return o;
    }
//    /**
//     *事务处理  前置通知
//     * @param pjp
//     * @return
//     * @throws Throwable
//     */
//    @Before("aspect()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        //step1 打印基本信息
//        System.out.println("执行前置通知");
//      
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        List transFlagList=null;
//        System.out.println("The method " +  methodName + " begins with " + args);
//        //step2-1 从当前线程获取事务轨迹标志
//        if(transFlags.get()!=null){
//            transFlagList=(List)transFlags.get();
//        }else{
//           transFlagList =Collections.synchronizedList(new ArrayList<String>());
//           transFlags.set(transFlagList);
//        }
//        
//        //step2-2 从当前线程获取事务
//        UserTransaction  trans=null;
//        if(transSession.get()!=null){
//            trans=(UserTransaction)transSession.get();
//        }else{
//            trans= transactionManager.getUserTransaction();
//            transSession.set(trans);
//        }
//        //step3 如果没有事务,开启事务,否则将当前操作纳入事务中
//        if(transFlagList.size()==0){
//           trans.begin(); //开启事务
//           System.out.println("开启事务成功");
//        }
//        transFlagList.add(methodName);
//        
//    }
//    /**
//     *事务处理 后置返回通知
//     * @param joinPoint
//     * @throws Throwable
//     */
//    @AfterReturning("aspect()")
//    public void doAfterReturning(JoinPoint joinPoint) throws Throwable {
//        //step1 打印基本信息
//        System.out.println("执行后置返回通知");
//        List transFlagList=(List)transFlags.get();
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("The method " +  methodName + " begins with " + args);
//        //step2 获取线程绑定事务
//        UserTransaction  trans=(UserTransaction)transSession.get();
//        if(transFlagList.contains(methodName)){
//           transFlagList.remove(methodName);
//        }
//        //step3 根据条件进行事务提交
//        if(transFlagList.size()==0){
//            trans.commit();  //提交事物
//            //初始化
//            transFlags.set(null);
//            transSession.set(null);
//            System.out.println("提交事务成功");
//        }
//        
//      
//    
//    }
//    /**
//     *事务处理 异常通知
//     * @param joinPoint
//     * @throws Throwable
//     */
//    @AfterThrowing("aspect()")
//    public void  AfterThrowing(JoinPoint joinPoint) throws Throwable {
//        //step1 打印基本信息
//        System.out.println("执行异常通知");
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("The method " +  methodName + " begins with " + args);
//        //step2 获取线程绑定的事务
//        UserTransaction  trans=(UserTransaction)transSession.get();
//        //if(trans.getStatus()!=Status.STATUS_NO_TRANSACTION){
//        //step3 回滚事务
//        trans.rollback();  //回滚事务
//        transFlags.set(null);
//        transSession.set(null);
//        System.out.println("回滚事务成功");
//       // }
//       
//    }
}
