//package io.luan.bank.web.aop
//
//import io.luan.bank.web.exception.ConstraintViolationException
//import org.aspectj.lang.ProceedingJoinPoint
//import org.aspectj.lang.annotation.Around
//import org.aspectj.lang.annotation.Aspect
//import org.springframework.stereotype.Component
//
//@Aspect
//@Component
//class ResultAspect {
//    @Around("@annotation(ResultHandler)")
//    @Throws(Throwable::class)
//    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
//        var proceed: Any? = null
//        proceed = try {
//            joinPoint.proceed()
//        } catch (cve: ConstraintViolationException) {
//            return Result.failure(cve)
//        } catch (e: Exception) {
//            return Result.failure(e)
//        }
//        return proceed
//    }
//}