//package io.luan.bank.web
//
//import io.luan.bank.application.TransferService
//import jakarta.servlet.http.HttpSession
//import org.springframework.stereotype.Controller
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//import java.math.BigDecimal
//
//@RestController
//@RequestMapping("/bank")
//class TransferController(private val transferService: TransferService) {
//    @GetMapping("/test")
//    fun test(): String {
//        return "李春江---Hello World!"
//    }
//
//    @GetMapping("/transfer")
//    fun transfer(
//        targetAccountNumber: String,
//        amount: BigDecimal,
//        session: HttpSession,
//    ): Result<Boolean> {
//        return try {
//            val userId = session.getAttribute("userId") as Long
//            val b = transferService.transfer(userId, targetAccountNumber, amount, "CN")
//            Result.success(b)
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//
//}